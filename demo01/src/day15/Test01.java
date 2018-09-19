package day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Test01
 * @Description 自然排序和定制排序，以及使用新的java8的时间API进行时间排序
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        Employee[] employees = {new Employee(23, "cris", LocalDate.of(2012, 1, 1), 23.23),
                new Employee(21, "james", LocalDate.of(2014, 12, 12), 434.1),
                new Employee(30, "simida", LocalDate.of(2017, 3, 2), 11.11)};

        /// 自然排序，定制排序
     /*   Arrays.sort(employees);

        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }

        Arrays.sort(employees,new EmployeeComparator());
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }*/

//        Arrays.sort(employees, new EmployeeComparator2());
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
        Arrays.sort(employees, Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Employee implements Comparable<Employee> {

    private int age;
    private String name;
    private LocalDate hireDate;
    private double salary;

    @Override
    public int compareTo(Employee o) {
        return this.getAge() - o.getAge();
    }
}

class EmployeeComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
//        return (int) (o1.getSalary() - o2.getSalary());
    }
}

class EmployeeComparator2 implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getHireDate().compareTo(o2.getHireDate());
    }
}
