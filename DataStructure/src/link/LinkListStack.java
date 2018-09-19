package link;

import stack.Stack;

/**
 * 基于比较完善的链表实现的 栈
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class LinkListStack<E> implements Stack<E> {

    private LinkList<E> list;

    public LinkListStack() {
        list = new LinkList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.deleteFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stack: top [");
        stringBuilder.append(list.getDetails() + "]");
        return stringBuilder.toString();
    }
}
