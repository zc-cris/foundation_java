package com.java.demo02;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Test3
 * @Description 猜随机数
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test3 {

    private static int number;

    public static void main(String[] args) {
        guessNum();
    }

    private static void guessNum() {
        Random random = new Random();
        int i = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            ++count;
            System.out.println("请输入一个数字猜猜生成的数字是多少：");
            number = scanner.nextInt();
            if (number == i) {
                System.out.println("恭喜你猜对了！，随机生成的数字是：" + i + ", 总共花费了：" + count + "次猜出结果");
                break;
            } else if (number > i) {
                System.out.println("大了");
            } else {
                System.out.println("小了");
            }
        }
    }
}
