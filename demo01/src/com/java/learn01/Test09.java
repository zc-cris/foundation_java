package com.java.learn01;


import java.util.Scanner;

/**
 * @ClassName Test09
 * @Description 快速排序三个整数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int a = scanner.nextInt();
        System.out.println("请输入第二个整数");
        int b = scanner.nextInt();
        System.out.println("请输入第三个整数");
        int c = scanner.nextInt();

        // 确保a的值比b的值小
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        // 确保b的值比c的值小
        if (b > c) {
            b = b ^ c;
            c = b ^ c;
            b = b ^ c;
        }
        // 确保a的值是最小的
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        System.out.println(a + "<=" + b + "<=" + c);


    }
}
