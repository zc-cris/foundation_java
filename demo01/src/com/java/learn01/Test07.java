package com.java.learn01;

import java.util.Scanner;

/**
 * @ClassName Test07
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test07 {
    public static void main(String[] args) {
        System.out.println("请输入成绩：" );
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (score >= 60) {
            System.out.println("合格" );
        }else {
            System.out.println("不合格" );
        }

    }
}
