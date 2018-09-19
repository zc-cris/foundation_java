package queue;

/**
 * 循环队列
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unchecked", "unused"})
public class LoopQueue<E> implements Queue<E> {

    /**
     * initial value is 0, record the first element,when remove the first element, first++
     **/
    private int first;
    /**
     * initial value is 0, record the last element,when add element, tail++, when the tail == array.length,
     * add element, tail = 0, continue add element, we should put it to the first index of array(use the space of removed element),
     * then tail+1, till the (tail+1)%array.length = tail
     **/
    private int tail;
    /**
     * record the count of elements
     **/
    private int size;
    /**
     * store the elements
     **/
    private E[] array;

    /**
     * constructor with para
     *
     * @param capacity the initial capacity user want to store element in the queue
     *                 why capacity+1? because the inner array will waste a index to record whether the array is full
     *                 if first == tail, it means the array is empty, if (tail+1)%array.length == first, it means
     *                 the array is full(now the count of elements in array actually is array.length-1)
     */
    public LoopQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (e == null) {
            throw new NullPointerException("the element can not be null when enqueue");
        }
        if (first == (tail + 1) % array.length) {
            resize(getCapacity() * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    /**
     * resize the inner array
     *
     * @param capacity the max count of elements in the array
     */
    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(first + i) % array.length];
        }

        /* the second method to put the all elements of old array into new array
        int index = 0;
        for (int i = first; i != tail; i = (i + 1) % array.length) {
            newArray[index++] = array[i];
        }*/

        array = newArray;
        first = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: capacity=%d, size=%d\nfont [", getCapacity(), size));
        for (int i = first; i != tail; i = (i + 1) % array.length) {
            sb.append(array[i]);
            if (i != tail - 1) {
                sb.append(",");
            }
        }

        ///the second method to traverse the queue
        /*
        for (int i = 0; i < size; i++) {
            sb.append(array[(first + i) % array.length]);
            if (i != size - 1) {
                sb.append(",");
            }
        }*/
        sb.append("] tail");
        return sb.toString();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("can't get the first added element from empty queue");
        }
        E e = array[first];
        array[first] = null;
        first = (first + 1) % array.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("can't get the first added element from empty queue");
        }
        return array[first];
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * when the queue is empty, there is no elements and firts is 0, tail is 0
     *
     * @return if queue is empty, return true
     */
    @Override
    public boolean isEmpty() {
        return first == tail;
    }

    /**
     * get the capacity of inner array
     *
     * @return the length of array -1, because we know the length of array equals real count of elements +1,
     * we need a empty index to avoid the first = tail(because it means the array is empty!)
     */
    public int getCapacity() {
        return array.length - 1;
    }
}
