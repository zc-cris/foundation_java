package com.java.study03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Test1
 * @Description 使用原子包里的类完成自增的原子性操作
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test1 {

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + integer.incrementAndGet());
        new Thread(() -> System.out.println(Thread.currentThread().getName() + integer.incrementAndGet())
        ).start();

        new Thread(() ->
                System.out.println(Thread.currentThread().getName() + integer.incrementAndGet())
        ).start();
    }
}
