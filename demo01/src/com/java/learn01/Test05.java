package com.java.learn01;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test05 {

    public static void main(String[] args) {
        int day = 89;
        System.out.println("花费时间为 = " + (day / 24) + "天" + (day % 24) + "小时");
        test2();
        test4();
    }

    public static void test2() {
        int a = 100 % 7;
        System.out.println("100天后是：周" + (2 + a));

    }

    @Test
    public void test3() {
//        LocalDate now = LocalDate.now();

        LocalDate localDate1 = LocalDate.of(2018, 1, 3);
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        // 方法1(推荐使用)
        long between = ChronoUnit.DAYS.between(localDate, localDate1);
        // 方法2
//        long between = now.toEpochDay() - localDate.toEpochDay();
        System.out.println("今天是今年的第：" + (between + 1) + "天");
    }

    public static void test4() {
        int a = 222 % 5;
        System.out.println("a = " + a);
        if (a <= 3) {
            System.out.println("今天打渔");
        } else {
            System.out.println("今天晒网");
        }
    }

}