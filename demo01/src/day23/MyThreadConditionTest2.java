package day23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁是多线程共享的，及一个线程持有lock锁，其他线程无法执行需要lock锁的方法
 * condition.await();  // 会释放lock锁
 * 多线程模板：
 * 1. 抢票型:多个线程对一个资源执行修改操作
 * 2. 多个线程执行同一个没有返回值的任务（例如循环操作等）
 * 3. 多个线程执行不同的有返回值任务并最终将子结果汇总
 * 4. 消费者和生产者：对同一个共享资源执行不同的修改操作（线程同步和通讯）
 *
 * @author zc-cris
 * @version 1.0
 **/
public class MyThreadConditionTest2 {
    public static void main(String[] args) {
        Shopper1 shopper1 = new Shopper1();

 /*       new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper1.sub();
            }
        }, "减线程1").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper1.sub();
            }
        }, "减线程2").start();*/
        new Thread(shopper1::add, "加线程1").start();
        new Thread(shopper1::add, "加线程2").start();
//        new Thread(shopper1::sub, "减线程1").start();
//        new Thread(shopper1::sub, "减线程2").start();

    }
}

class Shopper1 {
    private int products;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() {

        while (products < 100) {
            lock.lock();
            System.out.println("dead lock");
            if (products < 100) {
                System.out.println(Thread.currentThread().getName() + "products = " + (++products));
            }
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        while (products != 100) {
            try {
                condition.await();  // 释放lock锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (products > 0) {
            lock.lock();
            if (products > 0) {
                System.out.println(Thread.currentThread().getName() + "products = " + (--products));
            }
            System.out.println("products = " + products);
            lock.unlock();
        }
        System.out.println("减线程结束");
    }
}
