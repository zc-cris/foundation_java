package com.java.object04;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Triangle
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Triangle {

    private Double side1;
    private Double side2;
    private Double side3;

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        boolean triangle1 = triangle.isTriangle(1, 3, 3);
        System.out.println("triangle1 = " + triangle1);

        boolean b = triangle.setLengthOfSides(5, 3, 3);
        System.out.println("b = " + b);
        System.out.println(triangle);

        boolean rightTriangle = triangle.isRightTriangle(triangle.side1, triangle.side2, triangle.side3);
        System.out.println("rightTriangle = " + rightTriangle);

        boolean isoscelesTriangle = triangle.isIsoscelesTriangle(triangle.side1, triangle.side2, triangle.side3);
        System.out.println("isoscelesTriangle = " + isoscelesTriangle);

        Double area = triangle.getArea();
        System.out.println("area = " + area);

        Double perimeter = triangle.getPerimeter();
        System.out.println("perimeter = " + perimeter);

        String info = triangle.getInfo();
        System.out.println("info = " + info);

    }


    public boolean isTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setLengthOfSides(double a, double b, double c) {
        if (isTriangle(a, b, c)) {
            this.setSide1(a).setSide2(b).setSide3(c);
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightTriangle(double a, double b, double c) {
        List<Double> collect = Arrays.asList(a, b, c).stream().sorted(Double::compareTo).collect(Collectors.toList());
        if (Math.pow(collect.get(2), 2) == Math.pow(collect.get(0), 2) + Math.pow(collect.get(1), 2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isIsoscelesTriangle(double a, double b, double c) {
        List<Double> collect = Arrays.asList(a, b, c).stream().sorted(Double::compareTo).collect(Collectors.toList());
        if (a == b || a == c || b == c) {
            return true;
        } else {
            return false;
        }
    }

    public Double getArea() {
        double c = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(c * (c - this.side1) * (c - this.side2) * (c - this.side3));
    }

    public Double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public String getInfo() {
        Double area = this.getArea();
        Double perimeter = this.getPerimeter();
        String type = "";
        if (this.isRightTriangle(this.side1, this.side2, this.side3)) {
            type += "直角三角形";
        }
        if (this.isIsoscelesTriangle(this.side1, this.side2, this.side3)) {
            type += "等腰三角形";
        }
        return "三角形的三边是：" + this.side1 +
                " " + this.side2 + " " + this.side3 + " " + " 它的面积是：" + area + " 它的周长是：" + perimeter + " " + (type.equals("") ? "" : type);
    }
}


