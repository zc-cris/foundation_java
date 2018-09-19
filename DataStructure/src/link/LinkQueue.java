package link;

import queue.Queue;

/**
 * 引入首尾指针的单向链表(没有虚拟头节点版本)，实现队列
 * 从 head 端删除节点，从 tail 端插入新的节点，因为如果从tail 端删除节点比较麻烦（单向链表的tail 节点无法找到它的上一个节点）
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class LinkQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        ++size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("dequeue failed, the queue is empty");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        if (head == null) {
            tail = null;
        }
        --size;
        return node.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new NullPointerException("failed, now the queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("queue: size=%d\nfront[", size));
        Node node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.e + "->");
            if (i == size - 1) {
                sb.append("null");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 内部类用于存储数据
     */
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public Node(Node next) {
            this(null, next);
        }
    }
}
