package com.java.demo02;

import java.util.stream.IntStream;

/**
 * @ClassName Test5
 * @Description 借助lambda 表达式使用特定的格式打印特定的数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test5 {
    public static void main(String[] args) {
        printNum();
    }

    private static void printNum() {
        IntStream.rangeClosed(1, 150).forEach(x -> {
            if (x % 3 == 0) {
                System.out.print("foo");
            }
            if (x % 5 == 0) {
                System.out.print("biz");
            }
            if (x % 7 == 0) {
                System.out.print("baz");
            }

            System.out.println(x);
        });
    }
}
