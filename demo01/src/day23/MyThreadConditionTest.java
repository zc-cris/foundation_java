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
 * 4. 消费者和生产者：对同一个共享资源执行不同的修改操作（线程安全和通讯）
 *
 * @author zc-cris
 * @version 1.0
 **/
public class MyThreadConditionTest {
    public static void main(String[] args) {
        Shopper shopper = new Shopper();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper.sub();
            }
        }, "减线程1").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper.sub();
            }
        }, "减线程2").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper.add();

            }
        }, "加线程1").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shopper.add();
            }
        }, "加线程2").start();

    }
}

class Shopper {
    private int products;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (products != 0) {
                condition.await();
            }
            for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "products = " + (++products));
        }
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void sub() {
        lock.lock();
        try {
            while (products == 0) {
                condition.await();  // 释放lock锁
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "products-- = " + (products--));
            }
            condition.signalAll();//这里singal 的其他线程会立即执行吗？不会，因为lock锁没有释放
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
