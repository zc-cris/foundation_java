package recursion;


/**
 * 两种方式解决 leetcode 上的删除链表中所有的指定元素
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LinkRepeatedRecursionDelete {

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
     * 使用递归完成删除链表中的指定重复元素
     *
     * @param head 头节点
     * @param x    指定要删除的元素
     * @return
     */
    private static LinkNode recursion1(LinkNode head, int x) {
        if (head == null) {
            return null;
        }
        head.next = recursion1(head.next, x);
        return head.i == x ? head.next : head;
    }


    public static void main(String[] args) {
        // 通过一个Node 节点创建一串链表
        LinkNode head = new LinkNode(1);
        LinkNode originalHead = head;
        for (int i = 0; i < 5; i++) {
            head.next = new LinkNode(i);
            head = head.next;
        }
        originalHead = recursion1(originalHead, 1);
        String traversal = traversal(originalHead);
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
