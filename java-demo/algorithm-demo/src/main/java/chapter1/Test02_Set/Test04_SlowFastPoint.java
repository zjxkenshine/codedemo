package chapter1.Test02_Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/19 14:29
 * @description：快慢指针联系
 * @modified By：
 * @version: $
 *
 *  1 2 3 2 1
 *      ↑
 *      a
 *  1 2 3 3 2 1
 *      ↑
 *      b
 * 单向链表，快指针结束，慢指针处在中间位置
 */
public class Test04_SlowFastPoint {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 1 2 3 2 1
    public static Node generateNodeList(){
        // 头结点
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        return head;
    }

    // 1 2 3 3 2 1
    public static Node generateNodeList2(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        return head;
    }

    public static void main(String[] args) {
        //Node head = generateNodeList();
        Node head = generateNodeList2();

        // 慢指针
        Node slow = head;
        // 快指针
        Node fast = head;
        // 不是最后一个节点
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast多走一步，slow会停在第一个3处  1 2 3 3 2 1
        if(fast.next!=null){
            fast = fast.next;
        }
        System.out.println(fast.value);
        System.out.println(slow.value);
    }
}
