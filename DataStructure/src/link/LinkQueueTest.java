package link;

import org.junit.Test;

/**
 * test queue implemented by linkList
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkQueueTest {
    @Test
    public void test1() {
        LinkQueue<Integer> list = new LinkQueue<>();
        for (int i = 0; i < 10; i++) {
            list.enqueue(i);
            System.out.println("list = " + list);
            if (i % 3 == 2) {
                list.dequeue();
                System.out.println("list = " + list);
            }
        }

    }
}
