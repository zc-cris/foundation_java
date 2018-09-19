package com.java.demo02;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @ClassName Test13
 * @Description 使用lambda 表达式打印实心菱形和空心菱形
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test13 {
    public static void main(String[] args) {
        method1();

//        method2();


    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要打印的行数(奇数)：");
        int hang = scanner.nextInt();
        // 总共每行需要打印的数据个数

        IntStream.rangeClosed(1, hang).forEach(x -> {
            if (x <= hang / 2) {
                int numKongGe = (hang - (2 * x - 1)) / 2;
                IntStream.rangeClosed(1, numKongGe).forEach(y -> System.out.print(" "));

                if (x == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("*");
                    IntStream.rangeClosed(1, 2 * x - 3).forEach(y -> System.out.print(" "));
                    System.out.print("*");
                }

                System.out.println();
            } else if (x == hang / 2 + 1) {
                System.out.print("*");
                IntStream.rangeClosed(1, hang - 2).forEach(y -> System.out.print(" "));
                System.out.print("*");
                System.out.println();
            } else {
                int numXing = ((hang - x) * 2 + 1);
                int numKongGe = (hang - numXing) / 2;
                IntStream.rangeClosed(1, numKongGe).forEach(y -> System.out.print(" "));
                if (x == hang) {

                    System.out.print("*");
                } else {
                    System.out.print("*");

                    IntStream.rangeClosed(1, numXing - 2).forEach(y -> System.out.print(" "));
                    System.out.print("*");
                }
                System.out.println();

            }
        });
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要打印的行数(奇数)：");
        int hang = scanner.nextInt();
        // 总共每行需要打印的数据个数

        IntStream.rangeClosed(1, hang).forEach(x -> {
            if (x <= hang / 2) {

                int numKongGe = (hang - (2 * x - 1)) / 2;
                IntStream.rangeClosed(1, numKongGe).forEach(y -> System.out.print(" "));
                IntStream.rangeClosed(1, 2 * x - 1).forEach(y -> System.out.print("*"));
                System.out.println();
            } else if (x == hang / 2 + 1) {
                IntStream.rangeClosed(1, hang).forEach(y -> System.out.print("*"));
                System.out.println();
            } else {
                int numXing = ((hang - x) * 2 + 1);
                int numKongGe = (hang - numXing) / 2;
                IntStream.rangeClosed(1, numKongGe).forEach(y -> System.out.print(" "));
                IntStream.rangeClosed(1, numXing).forEach(y -> System.out.print("*"));
                System.out.println();

            }

        });
    }
}
