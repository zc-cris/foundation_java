package com.java.object05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Scanner;

/**
 * @ClassName WifeAndHusband
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class WifeAndHusband {

    public static void main(String[] args) {
        Husband[] husbands = new Husband[3];
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        for (int i = 0; i < count; i++) {
            System.out.println("请输入第" + (i + 1) + "位丈夫的名字：");
            String name = scanner.next();
            System.out.println("请输入第" + (i + 1) + "位丈夫的年龄：");
            int age = scanner.nextInt();
            System.out.println("请输入第" + (i + 1) + "位丈夫的妻子的名字：");
            String wifeName = scanner.next();
            System.out.println("请输入第" + (i + 1) + "位丈夫的妻子的年龄：");
            int wifeAge = scanner.nextInt();

            husbands[i] = new Husband();
            husbands[i].setAge(age).setName(name).
                    setWife(new Wife().setAge(wifeAge).setName(wifeName).setHusband(husbands[i]));
        }

        for (Husband husband : husbands) {
            System.out.println("husband = " + husband);
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Husband {
    private Integer age;
    private String name;
    private Wife wife;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Wife {
    private Integer age;
    private String name;
    private Husband husband;
}
