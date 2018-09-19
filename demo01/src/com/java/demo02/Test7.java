package com.java.demo02;

import java.util.stream.IntStream;

/**
 * @ClassName Test7
 * @Description 使用lambda 表达式打印前100中个位数不含3或者7的数字
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test7 {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 100).filter(x -> x % 10 != 3 && x % 10 != 7).forEach(System.out::println);
    }
}
