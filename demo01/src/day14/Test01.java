package day14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Arrays;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test01 {

    public static void main(String[] args) {
        AbstractEmployee[] employees = {new SalariedEmployee(123.0, 24, 24).
                setName("cris").setNumber(1).setBirthday(new MyDate(12, 12, 2001)),
                new HourlyEmployee(90.0, 12).setName("james").setNumber(2).setBirthday(new MyDate(11, 11, 2001))};
        Arrays.stream(employees).forEach(x -> System.out.println("x = " + x.earnings()));

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class HourlyEmployee extends AbstractEmployee {

    private Double wage;
    private Integer hour;

    @Override
    public double earnings() {
        return wage * hour;
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
class SalariedEmployee extends AbstractEmployee {

    private Double monthSalary;
    private Integer workingDays;
    private Integer totalDays;

    @Override
    public double earnings() {
        return this.monthSalary * workingDays / totalDays;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
abstract class AbstractEmployee {
    private Integer number;
    private String name;
    private MyDate birthday;

    /**
    * @Author zc-cris
    * @Description
    * @Param []
    * @return double
    **/
    public abstract double earnings();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class MyDate {
    private Integer month;
    private Integer date;
    private Integer year;

}