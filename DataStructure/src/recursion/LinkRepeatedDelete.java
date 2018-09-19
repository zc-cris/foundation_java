package recursion;


/**
 * 两种方式解决 leetcode 上的删除链表中所有的指定元素
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkRepeatedDelete {

    /**
     * 定义一个节点内部类
     */
    private static class LinkNode {
        private LinkNode next;
        private int i;

        public LinkNode(int x) {
            i = x;
        }
    }

    /**
     * 第一种方式删除链表的所有指定元素（不引入虚拟头节点）
     *
     * @param head 头节点
     * @param num  指定要删除的元素
     * @return 删除完所有指定元素的链表的头节点
     */
    public static LinkNode solution1(LinkNode head, int num) {
        // 首先判断头节点是否就是要删除的元素
        while (head != null && head.i == num) {
            LinkNode node = head;
            head = head.next;
            node.next = null;
        }
        // 如果链表全部元素都是num，就会出现这种删光了的情况
        if (head == null) {
            return null;
        }
        // 此时head已经不需要再判断了，直接从第二个元素开始判断
        LinkNode prev = head;
        while (prev.next != null) {
            if (prev.next.i == num) {
                LinkNode node = prev.next;
                prev.next = node.next;
                node.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 第二种方式删除链表中的所有指定重复元素（借助虚拟头节点）
     *
     * @param head 链表的原始头节点
     * @param num  指定删除的元素
     * @return 删除完所有指定元素的链表的头节点（即虚拟头节点的下一个节点）
     */
    public static LinkNode solution2(LinkNode head, int num) {
        if (head == null) {
            return null;
        }
        LinkNode dummyNode = new LinkNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        while (head.next != null) {
            if (head.next.i == num) {
                LinkNode node = head.next;
                head.next = node.next;
                node.next = null;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 通过一个Node 节点创建一串链表
        LinkNode head = new LinkNode(1);
        LinkNode finalHead = head;
        for (int i = 0; i < 10; i++) {
            head.next = new LinkNode(i);
            head = head.next;
        }
//        finalHead = solution1(finalHead, 1);
        finalHead = solution2(finalHead, 1);
        String traversal = traversal(finalHead);
        System.out.println("traversal = " + traversal);

    }

    /**
     * 通过一个头节点对这个节点后的所有元素进行遍历
     *
     * @param head 传入的头节点
     * @return 所有节点的数据
     */
    public static String traversal(LinkNode head) {
        if (head == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (head != null) {
            stringBuilder.append(head.i + " ");
            head = head.next;
        }
        return stringBuilder.toString().trim() + "]";
    }
}
