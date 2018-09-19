package day26;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc-cris
 * @version 1.0
 **/
public class DemoTest {
    public static void main(String[] args) {
        //TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length));
        Map<Integer, Student> map = new HashMap<>() {
            {
                put(1, new Student(1000.0, "cris"));
                put(2, new Student(1653.0, "james"));
                put(3, new Student(1233.0, "curry"));
            }
        };
        map.forEach((k, v) -> {
            if (v.getSalary() < 1500) {
                v.setSalary(v.getSalary() + 666);
            }
        });
        System.out.println("map = " + map);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Student {
    private double salary;
    private String name;
}
