package day19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.NoSuchElementException;

/**
 * imitate the LinkedList
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused", "UnusedAssignment"})
public class MyLinkedList {

    private int total;
    private Node head;

    public MyLinkedList() {
    }


    /**
     * remove the element according the object
     *
     * @param object the element to be removed
     */
    public void remove(Object object) {
        if (total == 0) {
            throw new NullPointerException();
        }

        Node node = head;
        if (object == null) {
            removeNull(node);
        } else {
            removeEquals(object, node);
        }
    }

    /**
     * remove the first node where the node's data equals the object(not null)
     *
     * @param object the object to be equals
     * @param node   the node of the MyLinkedList
     */
    private void removeEquals(Object object, Node node) {
        if (object.equals(head.data)) {
            head = node.next;
            total--;
            return;
        }
        while (node.next != null) {
            Node previous = node;
            node = node.next;
            if (object.equals(node.data)) {
                previous.next = node.next;
                total--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * remove the first node where node'data is null
     *
     * @param node the node of the MyLinkedList
     */
    private void removeNull(Node node) {
        if (head.data == null) {
            head = node.next;
            total--;
            return;
        }
        while (node.next != null) {
            Node previous = node;
            node = node.next;
            if (node.data == null) {
                previous.next = node.next;
                total--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * get the node's data according the index
     *
     * @param index the index to get the node
     * @return the node'data
     */
    public Object get(int index) {
        checkIndex(index);
        int num = 0;
        Node node = head;
        // checkIndex method has already consider the condition of head node is null
        while (node.next != null) {
            if (num == index) {
                return node.data;
            } else {
                num++;
                node = node.next;
            }
        }
        return node.data;
    }

    /**
     * add new node
     *
     * @param object the new node'data to be add
     */
    public void add(Object object) {
        if (head == null) {
            head = new Node(object, null);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(object, null);
        }
        total++;
    }

    /**
     * put all node'data in a array
     *
     * @return the array full in all node'data
     */
    public Object[] toArray() {
        if (total == 0) {
            return new Object[0];
        }
        Node node = head;
        Object[] array = new Object[total];
        int num = 0;
        while (node.next != null) {
            array[num++] = node.data;
            node = node.next;
        }
        array[num++] = node.data;
        return array;
    }

    /**
     * get the count of node
     *
     * @return the count of all node
     */
    public int count() {
        return total;
    }

    /**
     * check the index meet the requirement
     *
     * @param index the index to be checked
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= total) {
            throw new ArrayIndexOutOfBoundsException("index 异常");
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    private class Node {
        private Object data;
        private Node next;
    }

}
