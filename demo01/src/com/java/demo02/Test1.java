package com.java.demo02;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName Test1
 * @Description 使用lambda 表达式代替简单的for 循环计算
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        // 求出前100的数字的和
        int sum1 = IntStream.rangeClosed(1, 100).sum();
        System.out.println("reduce = " + sum1);

        // 计算前100 的偶数的和 方法1(效率没有方法2高)
        int sum = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).sum();
        System.out.println("reduce1 = " + sum);
        // 计算前100 的偶数的和 方法2
        int sum3 = IntStream.iterate(0, x -> x < 101, x -> x + 2).sum();
        System.out.println("sum3 = " + sum3);

        // 打印所有前100的偶数
        Stream.iterate(0, x -> x < 101, x -> x + 2).forEach(System.out::println);

    }
}
