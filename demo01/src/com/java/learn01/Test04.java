package com.java.learn01;

/**
 * @ClassName Test04
 * @Description 快速交换两个变量的数值
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test04 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // 一个数a对另外一个数b位亦或两次，得到的是还是原数a；还有一种方法是a+b的和，然后减
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("b = " + b);
        System.out.println("a = " + a);
    }
}
