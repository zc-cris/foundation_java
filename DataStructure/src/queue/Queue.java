package queue;

/**
 * definite the interface of Queue
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused"})
public interface Queue<E> {
    /**
     * into the queue
     *
     * @param e the element to be added
     */
    void enqueue(E e);

    /**
     * remove the first add element of the queue
     *
     * @return the first add element
     */
    @SuppressWarnings("SpellCheckingInspection")
    E dequeue();

    /**
     * look the first add element
     *
     * @return the first add element
     */
    E getFront();

    /**
     * get the size of element in the queue
     *
     * @return the size of elements
     */
    int getSize();

    /**
     * judge whether the queue is empty
     *
     * @return if the queue is empty, return true
     */
    boolean isEmpty();
}
