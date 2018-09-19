package com.java.study03;

import java.util.Arrays;

/**
 * @ClassName Test9
 * @Description 使用Stream API 按照格式打印大写和小写字母
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test9 {
    public static void main(String[] args) {

        char[][] chars = new char[4][];
        char num = 'A';
        for (int i = 0; i < 4; i++) {
            if (i == 0 || i == 1) {
                chars[i] = new char[7];
                for (int j = 0; j < 7; j++) {
                    chars[i][j] = (char) (num++);
                }
            } else {
                chars[i] = new char[6];
                for (int j = 0; j < 6; j++) {
                    chars[i][j] = (char) (num++);
                }
            }
        }
        Arrays.stream(chars).forEach(x -> {
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]);
                System.out.print((char) (x[i] + 32) + " ");
            }
            System.out.println();
        });

    }
}
