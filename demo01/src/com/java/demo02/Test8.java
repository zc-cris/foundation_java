package com.java.demo02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName Test8
 * @Description 使用lambda 表达式完成九九乘法表(顺序和倒序)
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test8 {
    public static void main(String[] args) {

        chengFaBiao2();

//        chengFaBiao();
    }

    private static void chengFaBiao2() {
        Stream.iterate(9, x -> x > 0, x -> x - 1).forEach(x -> {
            IntStream.rangeClosed(1, x).forEach(y -> System.out.print(y + "*" + x + "=" + y * x + "\t"));
            System.out.println();
        });
    }

    private static void chengFaBiao() {
        IntStream.rangeClosed(1, 9).forEach(x -> {
            IntStream.rangeClosed(1, x).forEach(y -> System.out.print(y + "*" + x + "=" + y * x + "\t"));
            System.out.println();
        });
    }
}
