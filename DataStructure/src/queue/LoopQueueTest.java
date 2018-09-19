package queue;

import org.junit.Test;

/**
 * test loopQueue
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LoopQueueTest {
    @Test
    public void test1() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("enqueue = " + queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("dequeue = " + queue);
            }
        }
    }
}
