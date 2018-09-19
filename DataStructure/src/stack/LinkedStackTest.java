package stack;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack = " + stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);

        
        /*System.out.println("stack.isEmpty() = " + stack.isEmpty());
        System.out.println("stack.getSize() = " + stack.getSize());*/


    }
}
