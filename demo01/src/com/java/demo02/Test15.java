package com.java.demo02;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @ClassName Test15
 * @Description 使用Stream API 求数字的最值
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test15 {
    public static void main(String[] args) {
        int[] array = new int[]{12, 23, 43, 10, 93, 90};

        // 排序
        Arrays.sort(array);

        for (int i : array) {
            System.out.println("i = " + i);
        }

        // 求最值
        OptionalInt reduce = Arrays.stream(array).reduce(Integer::max);
        System.out.println("最大值是：" + reduce.getAsInt());

        // 假设第一个元素是最小的，通过比较交换最小值的索引，最后得到最小值的索引
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        System.out.println("最小值的索引是： " + min + "对应的值是：" + array[min]);
    }
}
