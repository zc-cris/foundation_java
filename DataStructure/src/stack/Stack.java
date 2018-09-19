package stack;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public interface Stack<E> {

    /**
     * push element into stack
     *
     * @param e element
     */
    void push(E e);

    /**
     * remove the top element and return it
     *
     * @return the top element of stack
     */
    E pop();

    /**
     * look the top element of stack
     *
     * @return the top element of stack
     */
    E peek();

    /**
     * get the count of elements of stack
     *
     * @return the count of all elements
     */
    int getSize();

    /**
     * judge the stack is empty
     *
     * @return if the stack is empty,return true
     */
    boolean isEmpty();
}
