package com.java.study03;

import java.util.Arrays;

/**
 * @ClassName Test10
 * @Description 使用Stream API 和二维数组完成杨辉三角形的打印
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test10 {
    public static void main(String[] args) {
        int[][] array = new int[11][];
        array[0] = new int[]{1};
        array[1] = new int[]{1, 1};
        for (int i = 2; i < array.length; i++) {
            array[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
            }
        }
        Arrays.stream(array).forEach(x -> {
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        });
    }

}
