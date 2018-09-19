package com.java.learn01;

/**
 * @ClassName Test11
 * @Description 数学公式计算
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test11 {
    public static void main(String[] args) {
        getResult(1,-2,1);
    }

    public static void getResult(double a, double b, double c) {
        double x;
        double v = Math.pow(b, 2) - 4 * a * c;
        if (a != 0) {
            if (v > 0) {
                x = (-b + Math.sqrt(v)) / 2 * a;
                System.out.println("x = " + x);
                double y = (-b - Math.sqrt(v)) / 2 * a;
                System.out.println("y = " + y);
            } else if (v == 0) {
                x = -(b / 2 * a);
                System.out.println("x = " + x);
            } else {
                System.out.println("无解");
            }
        } else if (a == 0 && b != 0) {
            x = -(c / b);
            System.out.println("x = " + x);
        }

    }
}
