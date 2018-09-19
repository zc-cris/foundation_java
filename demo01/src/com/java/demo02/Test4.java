package com.java.demo02;

import java.util.stream.IntStream;

/**
 * @ClassName Test4
 * @Description 使用lambda计算水仙花数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test4 {
    public static void main(String[] args) {
        IntStream.rangeClosed(100, 999).filter(x ->
                x == (int) (Math.pow(x / 100, 3) + Math.pow(((x / 10) % 10), 3) + Math.pow(x % 10, 3))
        ).forEach(System.out::println);
    }
}
