package com.java.object05;

import org.junit.Test;

/**
 * @ClassName TriangleUtil
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TriangleUtil {

    public static double getArea(double a, double b, double c) {
        double d = (a + b + c) / 2;
        return Math.sqrt(d * (d - a) * (d - b) * (d - c));
    }

    public static double getArea2(double a, double high) {
        return (a * high) / 2;
    }

    @Test
    public void test() {
        double area = getArea(3.0, 5.0, 4.0);
        System.out.println("area = " + area);
        double area2 = getArea2(3.0, 4.0);
        System.out.println("area2 = " + area2);
    }
}
