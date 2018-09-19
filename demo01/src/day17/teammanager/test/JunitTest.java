package day17.teammanager.test;

import day17.teammanager.entity.employee.Employee;
import day17.teammanager.service.NameListService;
import day17.teammanager.service.TeamException;
import day17.teammanager.service.TeamService;
import org.junit.Test;

/**
 * 单元测试
 *
 * @author zc-cris
 * @version 1.0
 **/
public class JunitTest {

    @Test
    public void test() throws TeamException {
        NameListService nameListService = new NameListService();
//        Employee[] employees = nameListService.getEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//        Employee employee = nameListService.getEmployee(2);
//        System.out.println("employee = " + employee);
    }

    @Test
    public void test2() throws TeamException {
        NameListService nameListService = new NameListService();
        TeamService teamService = new TeamService();
        teamService.addMember(nameListService.getEmployee(1));
        teamService.addMember(nameListService.getEmployee(2));
        teamService.addMember(nameListService.getEmployee(2));
    }


}
