package com.java.learn01;

import java.util.Scanner;

/**
 * @ClassName Test10
 * @Description 嫁给高富帅
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的身高（cm）：");
        int height = scanner.nextInt();
        System.out.println("请输入你的资产（千万）：");
        int money = scanner.nextInt();
        System.out.println("请输入你的长相（帅(true)/丑(false)）：");
        boolean handsome = scanner.nextBoolean();
        if (height >= 180 && money >= 1 && handsome) {
            System.out.println("我一定要嫁给这个高富帅！");
        } else if (height >= 180 || money >= 1 || handsome) {
            System.out.println("凑合凑合算了");
        } else {
            System.out.println("不嫁！");
        }

    }
}
