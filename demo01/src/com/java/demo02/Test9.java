package com.java.demo02;

import java.util.stream.IntStream;

/**
 * @ClassName Test9
 * @Description 使用lambda 打印星星
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test9 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 4).forEach(x -> {
            IntStream.rangeClosed(1, x).forEach(y -> System.out.print("*"));
            System.out.println();
        });

    }
}
