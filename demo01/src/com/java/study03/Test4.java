package com.java.study03;

/**
 * @ClassName Test
 * @Description 两种选择排序
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test4 {
    public static void main(String[] args) {
        // selectSort1();

        selectSort2();

    }

    private static void selectSort2() {
        int[] array = {2, 23, 1, 0, 89, 57, 32};
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }

    private static void selectSort1() {
        int[] array = {2, 23, 1, 0, 89, 57};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }

        }
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }
}
