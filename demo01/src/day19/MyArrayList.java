package day19;

import java.util.Arrays;

/**
 * imitate the ArrayList
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class MyArrayList {
    /**
     * the inner array
     **/
    private Object[] array;

    /**
     * the count of all elements
     **/
    private int total;

    /**
     * the original init length of inner array
     **/
    private static final int ORIGINAL_LENGTH = 10;

    public MyArrayList() {
        this(ORIGINAL_LENGTH);
    }

    public MyArrayList(int length) {
        array = new Object[length];
    }

    /**
     * replace the element in the index
     *
     * @param index  the index to replace the element
     * @param object replace the element
     */
    public void set(int index, Object object) {
        checkIndex(index);
        array[index] = object;
    }

    /**
     * check the object is null
     *
     * @param object the element to be checked
     * @return the result of the check (true/false)
     */
    private boolean checkNull(Object object) {
        return object == null;
    }

    /**
     * remove the first element equals the object
     *
     * @param object the element to be removed from inner array
     * @throws NoSuchFieldException if no element equals the object
     */
    public void remove(Object object) throws NoSuchFieldException {
        int index = indexOf(object);
        if (index != -1) {
            System.arraycopy(array, index + 1, array, index, total - index - 1);
            array[--total] = null;
        } else {
            throw new NoSuchFieldException("没有这个" + object);

        }

    }

    /**
     * remove the element according the index
     *
     * @param index the index to remove the element
     */
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, total - index - 1);
        array[--total] = null;
    }

    /**
     * get the index of element
     *
     * @param object the element of the array
     * @return the index of the element in array
     */
    public int indexOf(Object object) {
        if (checkNull(object)) {
            for (int i = 0; i < total; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < total; i++) {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * get the element according the index
     *
     * @param index the index to get the element
     * @return the element in the index
     */
    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * check the index meet the requirement
     *
     * @param index the index to be checked
     */
    private void checkIndex(int index) {
        if (index < 0 || index > total) {
            throw new ArrayIndexOutOfBoundsException("index 异常");
        }
    }

    /**
     * check the inner array contains the object
     *
     * @param obj the object to be checked
     * @return if inner array contains the object, return true,or the false
     */
    public boolean contains(Object obj) {
        if (checkNull(obj)) {
            for (int i = 0; i < total; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < total; i++) {
                if (obj.equals(array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * insert object
     *
     * @param index  the index of object to be inserted
     * @param object the object to be inserted
     */
    public void insert(int index, Object object) {
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, total - index);
        array[index] = object;
        total++;
    }

    /**
     * add element
     *
     * @param object the element need to add
     */
    public void add(Object object) {
        ensureCapacity();
        array[total++] = object;
    }

    /**
     * ensure the enough capacity of array
     */
    private void ensureCapacity() {
        if (total >= array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
    }

    /**
     * get the copy of inner array with all elements
     *
     * @return the copy of inner array
     */
    public Object[] toArray() {
        return Arrays.copyOf(array, total);
    }

    /**
     * judge the inner array is empty
     *
     * @return if the inner array is empty(no element in),return true
     */
    public boolean isEmpty() {
        return total == 0;
    }


    /**
     * get the count of element in inner array
     *
     * @return the count of element
     */
    public int size() {
        return total;
    }

    /**
     * get the length of inner array
     *
     * @return the length of inner array
     */
    public int capacity() {
        return array.length;
    }

}
