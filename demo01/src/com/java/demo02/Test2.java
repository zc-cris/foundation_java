package com.java.demo02;

import java.util.Scanner;

/**
 * @ClassName Test2
 * @Description 统计输入的正数和负数的个数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        countNum();
    }

    private static void countNum() {
        Scanner scanner = new Scanner(System.in);
        int sum1 = 0;
        int sum2 = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("请输入整数，输入0则程序停止");
            int i = scanner.nextInt();
            if (i == 0) {
                flag = false;
            } else if (i > 0) {
                ++sum1;
            } else {
                ++sum2;
            }
        }
        System.out.println("正数个数 = " + sum1);
        System.out.println("负数个数 = " + sum2);
    }
}
