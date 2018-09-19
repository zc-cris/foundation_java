package com.java.learn01;

import java.util.Scanner;

/**
 * @ClassName Test06
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的名字：");
        String name = scanner.next();
        System.out.print("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入你的性别（男/女）：");
        char sex = scanner.next().charAt(0);
        System.out.print("请输入你的期望薪资：");
        double salary = scanner.nextDouble();
        System.out.println("您的名字是：" + name + "；您的年龄是：" + age + "；您的性别是：" + sex + "；你的期望薪资是：" + salary);
    }
}
