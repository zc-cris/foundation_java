package com.java.study03;

import java.util.stream.IntStream;

/**
 * @ClassName Test3
 * @Description 两种冒泡排序
 * @Author zc-cris
 * @Version 1.0
 **/
@SuppressWarnings("unused")
public class Test3 {
    public static void main(String[] args) {
        bubbleSort1();

//        bubbleSort2();
    }

    private static void bubbleSort2() {
        int[] array = {23, 12, 0, 42, 14, 1};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; --j) {
                if (array[j] < array[j - 1]) {
                    array[j] = array[j] ^ array[j - 1];
                    array[j - 1] = array[j] ^ array[j - 1];
                    array[j] = array[j] ^ array[j - 1];
                }
            }
        }
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }

    private static void bubbleSort1() {


        int[] array = {23, 12, 0, 42, 14, 2};
        IntStream.range(0, array.length - 1).forEach(x ->
                IntStream.range(0, array.length - 1 - x).forEach(j -> {
                    if (array[j] > array[j + 1]) {
                        array[j] = array[j] ^ array[j + 1];
                        array[j + 1] = array[j] ^ array[j + 1];
                        array[j] = array[j] ^ array[j + 1];
                    }
                })
        );

//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if (array[j] > array[j + 1]) {
//                    array[j] = array[j] ^ array[j + 1];
//                    array[j + 1] = array[j] ^ array[j + 1];
//                    array[j] = array[j] ^ array[j + 1];
//                }
//            }
//        }
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }

}
