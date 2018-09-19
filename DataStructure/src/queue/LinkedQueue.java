package queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * the implementation class of Queue by using link
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class LinkedQueue<E> implements Queue<E> {

    /**
     * record the count of elements
     **/
    private int size;
    /**
     * the first Node in the queue
     **/
    private Node first;

    @Override
    public void enqueue(E e) {
        if (e == null) {
            throw new NullPointerException("e can't be null");
        }
        Node node = new Node(e, null);
        if (first == null) {
            first = node;
        } else {
            first.next = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (first == null) {
            return null;
        } else {
            E e = first.e;
            first = first.next;
            size--;
            return e;
        }
    }

    @Override
    public E getFront() {
        return first == null ? null : first.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("count=%d,\n", size)).append("[");
        if (size > 0) {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    sb.append(node.e + ",");
                    node = node.next;
                } else {
                    sb.append(node.e);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    private class Node {
        private E e;
        private Node next;
    }
}
