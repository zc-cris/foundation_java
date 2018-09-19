package stack;

import java.util.EmptyStackException;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"ManualArrayCopy", "unused", "unchecked"})
public class ArrayStack<E> implements Stack<E> {

    private E[] arrays;
    private static int size = 10;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.arrays = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (e == null) {
            throw new NullPointerException("the element to be added is null");
        }
        if (size <= 0) {
            extendCapacity(arrays.length * 2);
        }
        arrays[--size] = e;
    }


    /**
     * resize the capacity of the array when the array is full or the capacity waste to much
     *
     * @param capacity the number array need to resize capacity
     */
    private void extendCapacity(int capacity) {
        E[] newArray = (E[]) new Object[capacity];
        for (int i = arrays.length - 1; i >= 0; --i) {
            newArray[arrays.length + i] = arrays[i];
        }
        arrays = newArray;
        size = capacity / 2;
    }

    /**
     * shrink the capacity of array
     *
     * @param capacity the capacity need to be shrink,general a half of previous capacity
     */
    private void shrinkCapacity(int capacity) {
        E[] newArrays = (E[]) new Object[capacity];
        for (int i = arrays.length - 1; i >= size; --i) {
            newArrays[i - capacity] = arrays[i];
        }
        arrays = newArrays;
        size = size - capacity;
    }

    @Override
    public E pop() {
        if (size == arrays.length) {
            throw new EmptyStackException();
        }
        E e = arrays[size];
        arrays[size++] = null;
        if (size == arrays.length - arrays.length / 4 && arrays.length / 2 != 0) {
            shrinkCapacity(arrays.length / 2);
        }
        return e;
    }


    @Override
    public E peek() {
        if (size == arrays.length) {
            throw new EmptyStackException();
        }
        return arrays[size];
    }

    @Override
    public int getSize() {
        return arrays.length - size;
    }

    @Override
    public boolean isEmpty() {
        return size == arrays.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" count = %d, capacity = %d \n", arrays.length - size, arrays.length));
        sb.append("[");
        for (int i = size; i < arrays.length; ++i) {
            if (i != arrays.length - 1) {
                sb.append(arrays[i] + ",");
            } else {
                sb.append(arrays[i] + "]");
            }
        }
        return sb.toString();
    }
}
