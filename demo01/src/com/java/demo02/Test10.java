package com.java.demo02;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @ClassName Test10
 * @Description 使用lambda 表达式找出1000 以内的完数（一个数如果恰好等于它的因子之和，这个数就称为"完数"。（因子：除去这个数本身的约数））
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test10 {
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 1000).filter(x -> {

            int sum = IntStream.rangeClosed(1, x - 1).filter(y -> x % y == 0).sum();
            return x == sum;
        }).forEach(System.out::println);

    }
}
