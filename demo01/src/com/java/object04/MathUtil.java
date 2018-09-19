package com.java.object04;


import lombok.extern.java.Log;

import java.util.logging.Logger;

/**
 * @ClassName MathUtil
 * @Description 计算两个数的最大值和求平方
 * @Author zc-cris
 * @Version 1.0
 **/
@Log
public class MathUtil {

    public static Integer getMax(int a, int b) {
        return a >= b ? a : b;
    }

    public static Integer pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer max = getMax(10, 4);
        System.out.println("max = " + max);

        Integer pow = pow(2, 4);
        System.out.println("pow = " + pow);
    }


}
