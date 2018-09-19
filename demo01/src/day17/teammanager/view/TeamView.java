package day17.teammanager.view;


import day17.teammanager.entity.employee.Employee;
import day17.teammanager.entity.employee.Programmer;
import day17.teammanager.service.NameListService;
import day17.teammanager.service.TeamException;
import day17.teammanager.service.TeamService;
import day17.teammanager.util.TSUtility;

/**
 * 团队管理程序视图层
 *
 * @author zc-cris
 * @version 1.0
 **/
public class TeamView {

    private static final TeamService TEAM_SERVICE = new TeamService();
    private static NameListService NAME_LIST_SERVICE;

    static {
        try {
            NAME_LIST_SERVICE = new NameListService();
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        enterMainMenu();

    }

    /**
     * 界面显示
     */
    public static void enterMainMenu() {
        listAllEmployees(NAME_LIST_SERVICE.getEmployees());
        while (true) {
            char c = TSUtility.readMenuSelection();
            switch (c) {
                case ('1'):
                    listTeamMembers(TEAM_SERVICE.getProgrammers());
                    System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)");
                    break;
                case ('2'):
                    addMember();
                    listAllEmployees(NAME_LIST_SERVICE.getEmployees());
                    break;
                case ('3'):
                    deleteMember();
                    System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)");
                    break;
                default:
                    return;
            }

        }
    }

    /**
     * remove programmer from team
     */
    private static void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除的员工TId:");
        int id = TSUtility.readInt();
        try {
            TEAM_SERVICE.removeMember(id);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败，失败原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    /**
     * add programmer to team
     */
    private static void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID:");
        int id = TSUtility.readInt();
        try {
            Employee employee = NAME_LIST_SERVICE.getEmployee(id);
            TEAM_SERVICE.addMember(employee);
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败，失败原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    /**
     * show all members of team
     *
     * @param programmers the array of team
     */
    private static void listTeamMembers(Programmer[] programmers) {
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println("TID/ID  姓名    年龄    工资    职位    奖金    股票");
        for (int i = 0; i < TEAM_SERVICE.getTotal(); i++) {
            System.out.println(programmers[i].getMessage());
        }
        System.out.println("-----------------------------------------------------");

    }

    /**
     * show all employees
     *
     * @param employees the array of all employees
     */
    private static void listAllEmployees(Employee[] employees) {
        System.out.println("--------------开发团队调度软件-----------------");
        System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("--------------------------------------------");
        System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)");
    }

}
