package link;

import org.junit.Test;
import queue.LoopQueue;
import queue.Queue;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * compare the efficiency of link queue complement by linkList and loop queue complement by loop array
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ComplextAnalysisWithQueueTest2 {

    @Test
    public void test() {

//         time = 0.85582768
        double time = getTime(new LoopQueue<>(), 10000000);
        System.out.println("time = " + time);
//        time1 = 3.714454912
        double time1 = getTime(new LinkQueue<>(), 10000000);
        System.out.println("time1 = " + time1);
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
}