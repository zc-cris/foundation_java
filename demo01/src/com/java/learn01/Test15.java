package com.java.learn01;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @ClassName Test15
 * @Description 计算天数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test15 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字表示年份：");
        int year = scanner.nextInt();

        System.out.println("请输入数字表示月份：");
        int month = scanner.nextInt();

        System.out.println("请输入数字表示日期：");
        int date = scanner.nextInt();

        LocalDate inputlocalDate = LocalDate.of(year, month, date);
        LocalDate localDate = LocalDate.of(year, 1, 1);
        // 方法2
        long between = inputlocalDate.toEpochDay() - localDate.toEpochDay();
        System.out.println("今天是今年的第：" + (between + 1) + "天");

        // 方法1
//        long between = ChronoUnit.DAYS.between(localDate, now);
    }
}
