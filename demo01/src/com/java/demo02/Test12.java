package com.java.demo02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * @ClassName Test12
 * @Description 使用java 8 新的时间API 完成天数差的计算
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test12 {
    public static void main(String[] args) {
        fishingOrRest();
    }

    private static void fishingOrRest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = scanner.nextInt();
        System.out.println("请输入月：");
        int month = scanner.nextInt();
        System.out.println("请输入日：");
        int date = scanner.nextInt();

        LocalDate localDate = LocalDate.of(year, month, date);
        LocalDate past = LocalDate.of(2000, 1, 1);
        long days = ChronoUnit.DAYS.between(past, localDate);
        int l = (int) ((days + 1) % 5);
        System.out.println(l);
        switch (l) {
            case 1:
            case 2:
            case 3:
                System.out.println("打渔");
                break;
            case 4:
            case 0:
                System.out.println("晒网");
        }
    }
}
