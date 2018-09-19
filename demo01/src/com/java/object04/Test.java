package com.java.object04;

import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {

    }

    @org.junit.Test
    public void test() {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("age", 12);
                put("weight", 178);
                put("height", 173);
            }
        };
        map.forEach((key, value) -> System.out.println("key=" + key + ";value=" + value));
    }

    @org.junit.Test
    public void test2() {
        List<Integer> list = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(8);
            }
        };
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("max = " + max);
    }

    @org.junit.Test
    public void test01() {
        int a = 0;
        int b = 0;
        for (; a < 10; a++) {
            for (; b < 10; b++) {
                if (a + b == 6) {
                    System.out.println("b = " + b);
                    System.out.println("a = " + a);
                }
            }
        }
    }
}
