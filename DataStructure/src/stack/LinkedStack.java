package stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 通过链表实现栈的基本功能
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unchecked")
public class LinkedStack<E> implements Stack<E> {

    /**
     * the first Node, meanwhile the newest Node
     **/
    private Node first;
    /**
     * record the count of all Nodes
     **/
    private int size;

    /**
     * add the element to the top of stack
     *
     * @param e element
     */
    @Override
    public void push(E e) {
        if (e == null) {
            throw new NullPointerException("e can't be null");
        }
        Node node = new Node().setE(e);
        if (first == null) {
            first = node;
        } else {
            node.setE(e).setNext(first);
            first = node;
        }
        size++;
    }

    /**
     * remove the top element of stack
     *
     * @return if the top element don't exist,return null
     */
    @Override
    public E pop() {
        if (first == null) {
            return null;
        } else {
            E e = first.e;
            first = first.next;
            size--;
            return e;
        }
    }

    /**
     * look the top element of stack
     *
     * @return if the top element don't exist, return null
     */
    @Override
    public E peek() {
        return first == null ? null : first.getE();
    }

    /**
     * get the count of all Nodes
     *
     * @return the count of all Nodes
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * judge the stack whether is empty
     *
     * @return if stack is empty, return true
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * the inner class to store element and record the next Node
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    private class Node {
        private Node next;
        private E e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size=%d \n", size));
        if (size > 0) {
            sb.append("[");
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    sb.append(first.e + ",");
                    first = first.next;
                } else {
                    sb.append(first.e + "]");
                }
            }
            first = node;
        }
        return sb.toString();

    }
}
