package queue;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * compare the efficiency of normal queue complement by array and loop queue complement by loop array
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ComplextAnalysisWithQueueTest {

    @Test
    public void test() {
        // time = 39.341360139
//        double time = getTime(new MyQueue<>(), 100000);
//        System.out.println("time = " + time);

//         time = 0.022670879
        double time = getTime(new LoopQueue<>(), 100000);
        System.out.println("time = " + time);
    }

    public double getTime(Queue<Integer> queue, int count) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int j = 0; j < count; j++) {
            int i = random.nextInt(Integer.MAX_VALUE);
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public double getTime2(Queue<Integer> queue, int count) {
        Random random = new Random();
        Instant start = Instant.now();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(Integer.MAX_VALUE);
            queue.enqueue(num);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toSeconds();
    }

    @Test
    public void test2() {
        // time2 = 40.0
//        double time2 = getTime2(new MyQueue<>(), 100000);
//        System.out.println("time2 = " + time2);

        // time21 = 0.0
        double time21 = getTime2(new LoopQueue<>(), 100000);
        System.out.println("time21 = " + time21);
    }
}
