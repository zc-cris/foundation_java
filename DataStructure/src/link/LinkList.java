package link;

import java.util.NoSuchElementException;

/**
 * 虚拟头节点大大简化插入新节点元素的逻辑
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused"})
public class LinkList<E> {

    private int size;
    /**
     * dummy head Node, this node is invisible to outer,it just be simplify insert element logic so that we
     * don't judge visible head node whether exist when insert new node
     **/
    private Node dummyHead;

    /**
     * should initial the dummyHead, our pointer should point the dummyHead at first
     */
    public LinkList() {
        dummyHead = new Node(null, null);
    }

    /**
     * delete element according element itself
     *
     * @param e the element to equals, if null or not, we provide two solutions
     * @return if delete successfully, return the element having been deleted,or throw NoSuchElementException
     */
    public E delete(E e) {
        if (size == 0) {
            throw new NoSuchElementException("delete failed, no such element");
        }
        if (e == null) {
            return deleteNull();
        } else {
            return deleteNotNull(e);
        }
    }

    private E deleteNotNull(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (e.equals(pre.next.e)) {
                Node node = pre.next;
                pre.next = node.next;
                node.next = null;
                --size;
                return node.e;
            }
            pre = pre.next;
        }
        throw new NoSuchElementException("delete failed, no such element");
    }

    private E deleteNull() {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e == null) {
                Node node = pre.next;
                pre.next = node.next;
                node.next = null;
                --size;
                return null;
            }
            pre = pre.next;
        }
        throw new NoSuchElementException("delete failed, no such element");
    }

    /**
     * delete element by index
     *
     * @param index the index to delete element
     * @return if delete successfully,return the element having been deleted
     */
    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed, the index is illegal");
        }
        Node previous = dummyHead;
        int num = 0;
        while (num != index) {
            previous = previous.next;
            ++num;
        }
        Node node = previous.next;
        previous.next = node.next;
        node.next = null;
        --size;
        return node.e;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    /**
     * show all elements more visual
     *
     * @return the formative elements
     */
    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")
    public String getDetails() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        if (cur != null) {
            while (cur.next != null) {
                sb.append(cur.e + "->");
                cur = cur.next;
            }
            sb.append(cur.e + "->null");
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * judge the linkList whether contains the element
     * the element is null or not, we provide two solutions
     *
     * @param e the element to be checked
     * @return if contains, return true
     */
    public boolean contains(E e) {
        Node cur = dummyHead;
        if (e == null) {
            return containsNull(cur);
        } else {
            return containsNotNull(cur, e);
        }
    }

    private boolean containsNotNull(Node cur, E e) {
        while (cur.next != null) {
            cur = cur.next;
            if (e.equals(cur.e)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNull(Node cur) {
        while (cur.next != null) {
            cur = cur.next;
            if (null == cur.e) {
                return true;
            }
        }
        return false;
    }

    /**
     * update the element by the index
     *
     * @param index the element need to be replaced
     * @param e     the new element
     * @return if return true, means replaced successfully
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean set(int index, E e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("get field,index is illegal");
        }
        int num = 0;
        Node cur = dummyHead.next;
        while (num != index) {
            cur = cur.next;
            ++num;
        }
        cur.e = e;
        return true;
    }


    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * get element according by index
     *
     * @param index the index need to get element
     * @return the element in the index
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("get field,index is illegal");
        }
        int num = 0;
        Node cur = dummyHead.next;
        while (num != index) {
            cur = cur.next;
            ++num;
        }
        return cur.e;
    }

    /**
     * insert element according by index, if index is legal,then insert the element
     *
     * @param index illegal index is bigger than size or smaller than 0
     * @param e     the element to be inserted, it allowed to be null
     */
    public void insert(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("insert failed,index is illegal");
        }
        int num = 0;
        Node previous = dummyHead;
        while (num != index) {
            previous = previous.next;
            ++num;
        }
        previous.next = new Node(e, previous.next);
        ++size;
    }

    /**
     * add the element to the last
     *
     * @param e the element to to added
     */
    public void addLast(E e) {
        insert(size, e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("linkList: size = %d \n[", size));
        // 从虚拟节点的下一个head 节点，也就是外界可见的头节点开始遍历
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            sb.append(node.e);
            if (i != size - 1) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * add element to become the first element
     *
     * @param e the element to add to first
     */
    public void addFirst(E e) {
        insert(0, e);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 创建一个内部节点类用于保存数据和持有下一个节点的引用
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

        @Override
        public String toString() {
            return this.e.toString();
        }
    }
}
