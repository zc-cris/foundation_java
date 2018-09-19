package queue;

import org.junit.Test;

/**
 * test MyQueue
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkedQueueTest {
    @Test
    public void test() {
        LinkedQueue<Integer> myQueue = new LinkedQueue<>();
        myQueue.enqueue(12);
        myQueue.enqueue(10);
        System.out.println("myQueue = " + myQueue);
        Integer front = myQueue.getFront();
        System.out.println("front = " + front);
        System.out.println("myQueue = " + myQueue);
        Integer dequeue = myQueue.dequeue();
        System.out.println("dequeue = " + dequeue);
        System.out.println("myQueue = " + myQueue);

    }
}
