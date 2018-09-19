package day17.teammanager.entity.employee;

import day17.teammanager.entity.Status;
import day17.teammanager.entity.equipment.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 程序员类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public String getBasicMessage() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t";
    }

    public String getMessage() {
        return getBasicMessage() + "程序员";
    }

    @Override
    public String toString() {
        return
                super.getInfo() + "程序员" + "\t" +
                        status + "\t" + "\t"
                        + equipment.getDescription()
                ;
    }
}
