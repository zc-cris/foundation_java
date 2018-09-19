package day17.teammanager.service;

import day17.teammanager.entity.Status;
import day17.teammanager.entity.employee.Architect;
import day17.teammanager.entity.employee.Designer;
import day17.teammanager.entity.employee.Employee;
import day17.teammanager.entity.employee.Programmer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 团队管理service
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TeamService {

    /**
     * record current programmer's memberId
     **/
    private static int count;
    /**
     * definite the max count of programmers array
     **/
    private static final int MAX_MEMBER = 5;
    /**
     * definite the programmers array
     **/
    private Programmer[] programmers = new Programmer[MAX_MEMBER];
    /**
     * record the really current capacity of the programmers array
     **/
    private int total;
    /**
     * the allowed count of architect
     **/
    private final int ALLOW_ARCHITECT_COUNT = 1;
    /**
     * the allowed count of programmer
     **/
    private final int ALLOW_PROGRAMMER_COUNT = 2;
    /**
     * the allowed count of designer
     **/
    private final int ALLOW_DESIGNER_COUNT = 2;
    /**
     * record current architect count
     **/
    private int currentArchitectCount;
    /**
     * record current programmer count
     **/
    private int currentProgrammerCount;
    /**
     * record current designer count
     **/
    private int currentDesignerCount;

    /**
     * add employee to team
     *
     * @param employee the employee to add
     * @throws TeamException 抛出各种异常
     */
    public void addMember(Employee employee) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        for (int i = 0; i <= total; i++) {
            if (programmers[i] == employee) {
                throw new TeamException("该员已是团队成员");
            }
        }
        if (((Programmer) employee).getStatus() == Status.VOCATION) {
            throw new TeamException("该员正在休假，无法添加");
        }


        if (employee instanceof Architect) {
            if (currentArchitectCount >= ALLOW_ARCHITECT_COUNT) {
                throw new TeamException("团队中只能有一名架构师");
            }
            currentArchitectCount++;
        } else if (employee instanceof Designer) {
            if (currentDesignerCount >= ALLOW_DESIGNER_COUNT) {
                throw new TeamException("团队中只能有二名设计员");

            }
            currentDesignerCount++;
        } else {
            if (currentProgrammerCount >= ALLOW_PROGRAMMER_COUNT) {
                throw new TeamException("团队中只能有二名程序员");
            }
            currentProgrammerCount++;
        }
        this.programmers[total++] = (Programmer) employee;
        ((Programmer) employee).setMemberId(++count);
        ((Programmer) employee).setStatus(Status.BUSY);
    }


    /**
     * remove the member of team by according memberId
     *
     * @param memberId the memberId user want to remove from team
     * @throws TeamException the memberId don't exist in the team members
     */
    public void removeMember(int memberId) throws TeamException {
        boolean exist = false;
        int index = 0;
        for (int i = 0; i < total; i++) {
            if (programmers[i].getMemberId() == memberId) {
                exist = true;
                index = i;
                programmers[i].setStatus(Status.FREE);
                if (programmers[i] instanceof Architect) {
                    currentArchitectCount--;
                } else if (programmers[i] instanceof Designer) {
                    currentDesignerCount--;
                } else {
                    currentProgrammerCount--;
                }
                break;
            }
        }
        if (!exist) {
            throw new TeamException("this memberId is not exist in the team");
        }
        System.arraycopy(programmers, index + 1, programmers, index, total - index - 1);
        programmers[total--] = null;

    }

    /**
     * @return the programmers
     */
    public Programmer[] getTeam() {
        return this.programmers;
    }

}
