package com.java.learn01;

import java.util.Scanner;

/**
 * @ClassName Test13
 * @Description 生肖和季节判断
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test13 {
    public static void main(String[] args) {
//        testSeason();
        testYear();

    }

    private static void testYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份数字：");
        int year = scanner.nextInt();
        int num = year % 12;
        switch (num) {
            case 1:
                System.out.println("鸡年");
                break;
            case 2:
                System.out.println("狗年");
                break;
            case 3:
                System.out.println("猪年");
                break;
            case 4:
                System.out.println("鼠年");
                break;
            case 5:
                System.out.println("牛年");
                break;
            case 6:
                System.out.println("虎年");
                break;
            case 7:
                System.out.println("兔年");
                break;
            case 8:
                System.out.println("龙年");
                break;
            case 9:
                System.out.println("蛇年");
                break;
            case 10:
                System.out.println("马年");
                break;
            case 11:
                System.out.println("羊年");
            case 0:
                System.out.println("猴年" );
        }
    }


    private static void testSeason() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份数字：");
        int num = scanner.nextInt();
        switch (num) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
        }
    }
}
