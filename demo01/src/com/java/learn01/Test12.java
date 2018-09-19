package com.java.learn01;


import java.util.Scanner;

/**
 * @ClassName Test12
 * @Description 彩票
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test12 {
    public static void main(String[] args) {

        // 生成随机数方法一：[0,1)*bound ---> [0,bound)
        double random = Math.random();
        int num = (int) (random * 10 + 10);   // 生成[10,20)的随机数
        int a = num / 10;
        int b = num % 10;

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String s = "请输入一个两位数来猜彩票，猜中或者输入0停止游戏：";
        while (flag) {
            System.out.print(s);
            int c = scanner.nextInt();
            int d = c / 10;
            int e = c % 10;
            if (c == 0) {
                flag = false;
                System.out.println("退出游戏");
            } else if (c == num) {
                flag = false;
                System.out.println("恭喜你猜中了，奖励1个亿！");
            } else if (a == e && b == d) {
                System.out.println("奖励5千万");
            } else if (a == d || b == e) {
                System.out.println("奖励1千万");
            } else if (a == e || b == d) {
                System.out.println("奖励5百万");
            } else {
                System.out.println("输入的数字不和彩票数字匹配，请重新输入");
            }

        }


        // 生成随机数方法二：nextInt（bound）---> 生成[0，bound) 范围的随机整数
//        Random random1 = new Random();
//        int i = random1.nextInt(2);
    }
}
