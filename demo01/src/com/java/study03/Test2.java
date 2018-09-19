package com.java.study03;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
//        method1();

//        method2();

//        method3();

        method4();

    }

    private static void method4() {
        int[] arr = new int[]{8,2,1,0,3};
        int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tel = "";
        for(int i = 0;i < index.length;i++){
            tel += arr[index[i]];
        }
        System.out.println("联系方式：" + tel);
    }

    private static void method3() {
        String[] names = {"张三","李四","王五","赵六","钱七"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个名字：" );
        String name = scanner.next();
        boolean flag = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                System.out.println("下标是：" +i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("未找到" );
        }
    }

    private static void method2() {
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("请输入年份：");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        System.out.println("请输入日期：");
        int date = scanner.nextInt();

        LocalDate localDate = LocalDate.of(year, 1, 1);
        LocalDate localDate1 = LocalDate.of(year, month, date);
        System.out.println("这一天是今年的第：" + (localDate1.toEpochDay() - localDate.toEpochDay() + 1) + "天");
    }


    private static void method1() {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个星期的数字：");
        int number = scanner.nextInt();
        System.out.println("这个数字代表的日期是：" + weeks[number - 1]);
    }
}
