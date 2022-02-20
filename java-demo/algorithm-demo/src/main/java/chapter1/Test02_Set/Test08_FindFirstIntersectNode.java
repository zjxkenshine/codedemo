package chapter1.Test02_Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 10:32
 * @description：找到第一个相交的节点
 * @modified By：
 * @version: $
 * 【题目】给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * 【要求】如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 *
 * 首先解决的问题：
 * 判断一个链表是否有环：
 *          7← 6
 *          ↓  ↑
 * 1->2->3->4->5
 * ↑     ↑
 * s     f
 * 方式一： 额外数据结构Set，指针每走一步就放入Set中，有重复的就取出 额外空间复杂度O（N）
 * 方式二： 有环的情况下，快慢指针，f快指针走两步，s慢指针走一步，s和f必定相遇
 *      - 相遇后s慢指针不动，f快指针回到head节点，接下来s和f每次只走一步，s和f一定会在入环节点相遇
 *
 *
 * 两个链表分别求出入环节点：loop1 loop2
 * 1） loop1==null loop2==null
 * 如果两条链表相交，则必定是Y字,V子或者一字型，最后一个节点内存地址必相同，不可能出现十字型
 * 如果不想交，最后一个节点内存地址不同
 * head1->1->2->3->4->5..->n     链表1 Size=100
 *                         ↑
 * head2->20->21->22->23->24      链表2 Size=80
 * 则：head1指针先走20步，之后再和head2指针一次走一步，最终两个指针会在相交点相遇
 *
 * 2） loop1 和loop2 有一个不为null,一个有环
 * 不可能相交
 *
 * 3) loop1 和loop2 两个入环节点存在
 * 两种相交情况，情况1：入环节点相同，与无环链表相同
 *                 7← 6
 *                 ↓  ↑
 * head1->1->2->3->4->5
 *              ↑
 * head2->1->2->3
 * 情况2： 入环节点不同，loop1往下走，再次遇到自己位置前，可以遇到loop2
 *                 7← 6
 *                 ↓  ↑
 * head1->1->2->3->4->5
 *                    ↑
 * head2->1->2->3->4->5
 *
 */
public class Test08_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 主函数
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 入环节点1
        Node loop1 = getLoopNode(head1);
        // 入环节点2
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    // 找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    // 两个无环链表相交
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 两个有环链表相交 入环节点相同，与无环链表相同
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 情况1
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
