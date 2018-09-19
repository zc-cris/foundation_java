package stack;

import array.MyArray;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class MyArrayStack<E> implements Stack<E> {

    private MyArray<E> myArray;


    public MyArrayStack(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    public MyArrayStack() {
        myArray = new MyArray<>();
    }

    @Override
    public void push(E e) {
        myArray.addLast(e);
    }

    @Override
    public E pop() {
        return myArray.removeLast();
    }

    @Override
    public E peek() {
        return myArray.getLast();
    }

    @Override
    public int getSize() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size = %d, capacity = %d \n[", myArray.size(), myArray.length()));
        for (int i = 0; i < myArray.size(); i++) {
            if (i != myArray.size() - 1) {
                sb.append(myArray.get(i) + ",");
            } else {
                sb.append(myArray.get(i));
            }
        }
        sb.append("] TOP");
        return sb.toString();
    }
}
