package queue;

import array.MyArray;

/**
 * the implementation class of Queue by using dynamic array
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused"})
public class MyQueue<E> implements Queue<E> {

    private MyArray<E> array;

    public MyQueue() {
        array = new MyArray<>();
    }

    public MyQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
