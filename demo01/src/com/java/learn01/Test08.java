package com.java.learn01;

import java.util.Scanner;

/**
 * @ClassName Test08
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test08 {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (score == 100) {
            System.out.println("奖励一辆宝马");
        } else if (score > 80) {
            System.out.println("奖励一台苹果手机");

        } else if (score >= 60) {
            System.out.println("奖励一个ipad");
        } else {
            System.out.println("什么奖励都没有！");
        }
    }
}
