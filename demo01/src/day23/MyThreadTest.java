package day23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class MyThreadTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 这里即使提交多次任务，也只有一个线程执行？？？？？
        executorService.submit(shop::sale);
        Shop shop1 = new Shop();
        executorService.submit(shop1::sale);
//        executorService.submit(shop::sale);
//        executorService.submit(shop::sale);
        executorService.shutdown();

//        new Thread(shop::sale, "1号线程").start();
//        new Thread(shop::sale, "2号线程").start();
//        new Thread(shop::sale, "3号线程").start();

    }
}

class Shop {
    private int products = 100;
    private Lock lock = new ReentrantLock();

    public void sale() {
        while (products > 0) {
            try {
                lock.lock();
                if (products > 0) {
                    System.out.println(Thread.currentThread().getName() + ":  " + products--);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
