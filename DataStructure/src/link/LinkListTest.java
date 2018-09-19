package link;

import org.junit.Test;

/**
 * 测试链表
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkListTest {
    @Test
    public void test1() {
        LinkList<Integer> list = new LinkList<>();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addLast(3);
//        list.addLast(4);
        list.insert(0, 5);
        list.insert(1, 6);
        list.addLast(7);
        list.addLast(null);
//        Integer integer = list.get(2);
//        System.out.println("integer = " + integer);
//        System.out.println("list.getFirst() = " + list.getFirst());
//        System.out.println("list.getLast() = " + list.getLast());
        list.set(1, 12);
        System.out.println("list.contains(null) = " + list.contains(null));
        System.out.println("list.contains(8) = " + list.contains(8));

        System.out.println("list = " + list);
        System.out.println("list.getDetails() = " + list.getDetails());
    }

    @Test
    public void testDelete() {
        LinkList<Integer> list = new LinkList<>();
        list.addFirst(12);
        list.addFirst(11);
        list.addFirst(10);
        list.addLast(null);
//        Integer delete = list.delete(1);
//        Integer delete = list.delete(Integer.valueOf(10));
        Integer delete = list.delete(null);
        System.out.println("delete = " + delete);
        System.out.println("list.getDetails() = " + list.getDetails());
        System.out.println("list = " + list);
    }
}
