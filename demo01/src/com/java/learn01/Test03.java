package com.java.learn01;


/**
 * @ClassName Test03
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test03 {
    public static void main(String[] args) {
        int a = 123;
        System.out.println("百位数字 = " + a/100);
        System.out.println("十位数字 = " + (a/10)%10);
        System.out.println("个位数字 = " + a%10);

    }
}
