package stack;

import org.junit.Test;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ArrayStackTest {
    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>();
//        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }
        System.out.println("stack = " + stack);
        Integer peek = stack.peek();
        System.out.println("peek = " + peek);
        System.out.println("stack = " + stack);
        Integer pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack = " + stack);
        stack.push(110);
        System.out.println("stack = " + stack);
        for (int i = 0; i < 7; i++) {
            stack.pop();
        }
        System.out.println("stack = " + stack);
        stack.push(123);
        stack.push(321);
        stack.push(321);
        stack.push(321);
        stack.push(321);
        stack.push(321);
        stack.pop();
        stack.pop();
        System.out.println("stack = " + stack);

//        System.out.println("stack.getSize() = " + stack.getSize());
//        System.out.println("stack.isEmpty() = " + stack.isEmpty());
    }

    @Test
    public void test2() {
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        System.out.println("stack = " + stack);
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.push(123);
        System.out.println("stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack = " + stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("stack = " + stack);
        stack.push(123);
        System.out.println("stack = " + stack);
    }
}
