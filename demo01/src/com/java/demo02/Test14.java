package com.java.demo02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName Test14
 * @Description 使用java 9 新增的Stream API 完成递减的数字打印
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test14 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).forEach(x -> {
            Stream.iterate(6 - x, y -> y > 0, y -> y - 1).forEach(System.out::print);
            System.out.println();
        });
    }
}
