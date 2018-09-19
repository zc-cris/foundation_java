package com.java.study03;

/**
 * @ClassName Test5
 * @Description 插入排序：从第二个元素开始后的每个元素和前面已经排好序的元素依次比较，效率比选择和冒泡效率更高
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test5 {
    public static void main(String[] args) {
        int[] arr = {13, 4, 65, 0, 45, 34, 4};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                    // 这步很重要
                    i = j;
                }
            }
        }
        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }
}
