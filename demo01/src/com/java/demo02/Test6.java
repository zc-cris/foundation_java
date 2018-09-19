package com.java.demo02;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @ClassName Test6
 * @Description 使用lambda 表达式计算最大公约数和最小公倍数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test6 {
    public static void main(String[] args) {
        getResult();

    }

    private static void getResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int a = scanner.nextInt();
        System.out.println("请再输入一个数");
        int b = scanner.nextInt();

        int min = a > b ? b : a;
        int max = a + b - min;

        int maxGongyueshu = 0;
        int minGongbeishu = 0;

        if (max % min == 0) {
            maxGongyueshu = min;
            minGongbeishu = max;
        } else {
            // Java 9 中的重载iterate 方法
            Optional<Integer> first =
                    Stream.iterate(min / 2, x -> x > 0, x -> x - 1).filter(x -> max % x == 0 && min % x == 0).findFirst();
            maxGongyueshu = first.get();
            minGongbeishu = max * min;
        }
        System.out.println("最大公约数是: " + maxGongyueshu);
        System.out.println("最小公倍数是: " + minGongbeishu);
    }
}
