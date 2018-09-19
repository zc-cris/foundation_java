package com.java.learn01;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test02 {

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        System.out.println("a+b = " + (a + b));
        System.out.println("a-b = " + (a - b));
        System.out.println("a*b = " + (a * b));
        System.out.println("a/b = " + ((double) a / b));
        String name = "cris";
        int age = 18;
        char sex = '男';
        double weight = 50.23;
        String address = "北京市昌平区青年公寓";
        boolean married = false;
        System.out.println("我的名字是：" + name + "\n" + "年龄是：" + age + "\n" + "体重是：" + weight + "kg\n" + "性别是：" + sex + "\n" + "地址是：" + address + "\n" + "是否已婚：" + married);
    }
}
