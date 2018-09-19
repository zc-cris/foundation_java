package com.java.demo02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test16
 * @Description 使用Stream API 求平均值
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test16 {
    public static void main(String[] args) {

        getAverage();


    }

    private static void getAverage() {
        int[] array = new int[5];
        System.out.println("请输入5个学生的成绩" );
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的成绩" );
            array[i] = scanner.nextInt();
        }

        double average = Arrays.stream(array).reduce(Integer::sum).getAsInt()/(double)array.length;
        System.out.println("平均分是： = " + average);
    }
}
