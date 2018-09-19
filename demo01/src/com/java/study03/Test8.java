package com.java.study03;

import java.util.Arrays;

/**
 * @ClassName Test8
 * @Description 借助Stream API 完成特定的二维图像的打印
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test8 {
    public static void main(String[] args) {
        print1();

    }

    private static void print1() {
        int[][] array = new int[4][5];
        int a = 1;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                array[i][i1] = a;
            }
            a++;
        }
        Arrays.stream(array).forEach(x ->{
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println();
        });
    }
}
