package com.java.study03;

/**
 * @ClassName Test6
 * @Description java的二分查找法
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test6 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 7, 8, 10, 14};
        int i = find(array, 14, 0, 7);
        System.out.println("i = " + i);

    }

    public static int find(int[] array, int key, int low, int high) {
        if (low > high || key > array[high] || key < array[low]) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (key > array[middle]) {
            return find(array, key, middle + 1, high);
        } else if (key < array[middle]) {
            return find(array, key, low, middle - 1);
        } else {
            return middle;
        }
    }
}
