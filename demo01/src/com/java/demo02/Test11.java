package com.java.demo02;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName Test11
 * @Description 使用lambda 完成质数的判断和收集
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test11 {
    public static void main(String[] args) {
        // 这里采用Stream API 里的分区收集
//        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.partitioningBy(Test11::isPrime));
        // map的forEach 遍历需要牢牢记住
//        collect.forEach((k, v) -> System.out.println(k + ":" + v));
        List<Integer> collect1 = IntStream.rangeClosed(101, 200).filter(Test11::isPrime).boxed().collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

    }

    public static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(x -> num % x == 0);
    }
}
