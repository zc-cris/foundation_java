package day17.teammanager.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 员工类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    String getInfo() {
        return
                getId() + "\t\t"
                        + getName() + "    "
                        + getAge() + "\t" + getSalary() + "\t";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
