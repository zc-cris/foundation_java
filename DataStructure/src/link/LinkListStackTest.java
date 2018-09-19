package link;

import org.junit.Test;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkListStackTest {

    @Test
    public void test1(){
        LinkListStack<Integer> stack = new LinkListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println("stack = " + stack);
        }
        stack.pop();
        System.out.println("stack = " + stack);

    }
}
