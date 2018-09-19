package com.java.demo02;

/**
 * @ClassName Test17
 * @Description 数组首尾交换的两种方式
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test17 {
    public static void main(String[] args) {
//        reverse1();

        reverse2();


    }

    private static void reverse2() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        for (int i = 0; i < chars.length / 2; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }
    }

    private static void reverse1() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        char[] newChars = new char[5];
        for (int i = 0; i < chars.length; i++) {
            newChars[chars.length - 1 - i] = chars[i];
        }

        for (char newChar : newChars) {
            System.out.println("newChar = " + newChar);
        }
    }
}
