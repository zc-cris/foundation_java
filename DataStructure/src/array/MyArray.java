package array;

/**
 * 手写动态数组
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"ManualArrayCopy", "unused", "unchecked"})
public class MyArray<E> {

    private E[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArray() {
        this(DEFAULT_CAPACITY);
    }

    public MyArray(int capacity) {
        array = (E[]) new Object[capacity];
    }


    /**
     * remove all element equals the object
     *
     * @param t the object to be equals every element in the array
     * @return if remove all successfully, return true
     */
    public boolean removeAllElement(E t) {
        int[] numbers = indexOfAll(t);
        int length = numbers.length;
        if (length > 0) {
            for (int anInt : numbers) {
                removeElement(t);
            }
            return true;
        }
        return false;
    }


    /**
     * remove element by object
     *
     * @param t judge the element equals object
     * @return if remove successfully, return true
     */
    public boolean removeElement(E t) {
        int i = indexOf(t);
        if (i != -1) {
            remove(i);
            return true;
        }
        return false;
    }

    /**
     * remove the last element
     *
     * @return if remove successfully, return the element have been removed
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * remove the first element
     *
     * @return if remove successfully, return the element have been removed
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * remove element by index
     *
     * @param index the index to remove element
     * @return if remove successfully, return the element have been removed
     */
    public E remove(int index) {
        checkIndex(index, index >= size, "index is illegal when remove");
        E t = array[index];
        if (index == size - 1) {
            array[index] = null;
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return t;
    }

    /**
     * get all index of element
     *
     * @param e the element to be equals
     * @return if object don't exits,return new empty array,else return the new array fill in all index of same element
     */
    public int[] indexOfAll(E e) {
        if (e == null) {
            throw new NullPointerException("object can not be null when get the index of element");
        }
        int[] counts = new int[size];
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(e)) {
                counts[count++] = i;
            }
        }
        if (count != 0) {
            int[] newCounts = new int[count];
            for (int i = 0; i < count; i++) {
                newCounts[i] = counts[i];
            }
            return newCounts;
        } else {
            return new int[0];
        }

    }

    /**
     * get the index of element
     *
     * @param e the element to get it's index
     * @return the index, if element don't exists,return -1
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * judge inner array contains the element
     *
     * @param e the element to be equals
     * @return if contains return true
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    /**
     * replace the first index of elements
     *
     * @param e the new element to replace
     * @return if replace successfully, return true
     */
    public boolean setFirst(E e) {
        return set(0, e);
    }

    /**
     * replace the last index of elements
     *
     * @param e the new element to replace
     * @return if replace successfully, return true
     */
    public boolean setLast(E e) {
        return set(size - 1, e);
    }


    /**
     * update the element by index
     *
     * @param index the index to update element
     * @param e     the new element to replace the old element
     * @return if replace successfully, return true
     */
    public boolean set(int index, E e) {
        checkIndex(index, index > size, "index is illegal when update element by index");
        if (e == null) {
            throw new NullPointerException("the element to be replace can not be null");
        }
        array[index] = e;
        return true;
    }


    /**
     * get the element by index
     *
     * @param index the index to get the element
     * @return the element of the index
     */
    public E get(int index) {
        checkIndex(index, index >= size, "index is illegal when get element by index");
        return array[index];
    }

    /**
     * get the first element of inner array
     *
     * @return the first element
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * get the last element of inner array
     *
     * @return the last element
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * check the index
     *
     * @param index the index to be checked
     * @param b     the index >= size or the index > size
     * @param s     the error message
     */
    private void checkIndex(int index, boolean b, String s) {
        if (index < 0 || b) {
            throw new IndexOutOfBoundsException(s);
        }
    }

    /**
     * use String.format method to format String
     *
     * @return the formatted String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size = %d, capacity = %d\n", size, array.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * add the element to the first index of array
     *
     * @param e the element to be added
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * add the element by index
     *
     * @param index the index to be insert
     * @param e     the element to be insert
     */
    public void add(int index, E e) {
        if (e == null) {
            throw new NullPointerException("the element to be added can not be null");
        }
        checkIndex(index, index > size, "index is illegal when add element");
        if (size >= array.length) {
            resize(array.length * 2);
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
    }

    /**
     * add element to the last index of elements
     *
     * @param e the element to be added
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * ensure the capacity of the inner array,if the count of elements == the length of the inner array,
     * the length of inner array should be double of the old length
     */
    private void resize(int length) {
        E[] objects = (E[]) new Object[length];
        for (int i = 0; i < size; i++) {
            objects[i] = array[i];
        }
        array = objects;
    }

    /**
     * judge the array is empty
     *
     * @return if the array is empty,return true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get the length of inner array
     *
     * @return the length of inner array
     */
    public int length() {
        return array.length;
    }

    /**
     * get the real count of elements
     *
     * @return the count of elements
     */
    public int size() {
        return size;
    }

    /**
     * get the copy of array full in elements
     *
     * @return the copy of array of all elements
     */
    public E[] toArray() {
        E[] objects = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = array[i];
        }
        return objects;
    }


}
