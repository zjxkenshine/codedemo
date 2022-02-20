package chapter1.Test03_Tree;

import java.util.Stack;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 12:30
 * @description：二叉树遍历
 * @modified By：
 * @version: $
 *
 * 二叉树 先 中 后序遍历
 * PreTraversal
 * InTraversal
 * PosTraversal
 */
public class Test01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 递归先序遍历 头 左 右
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 递归中序遍历  左 头 右
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 递归实现后续遍历 左 右 头
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        // 左
        posOrderRecur(head.left);
        // 右
        posOrderRecur(head.right);
        // 当前节点
        System.out.print(head.value + " ");
    }

    /** 非递归实现先序遍历
     *  头 左 右
     *
     *  从头节点开始处理：
     *  1. 头压栈 头弹出
     *  2. 右压栈 左压栈
     *  3. 左弹出 右弹出
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            // 头节点压栈
            stack.add(head);
            // 栈不为空
            while (!stack.isEmpty()) {
                // 弹出头节点
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    // 先压右
                    stack.push(head.right);
                }
                if (head.left != null) {
                    // 再压左
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     *  非递归实现中序遍历 流程
     *  左 头 右
     *
     *  一定是从头节点开始处理：
     *  - 头压栈 左压栈
     *  - 左弹出 头弹出
     *  - 右压栈 右弹出
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    // 头压栈
                    stack.push(head);
                    // 移动到左子树 继续压栈
                    head = head.left;
                } else {
                    // 弹出一个节点
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    // 继续压右节点
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归实现后续遍历 方式一
     * 左 右 头
     *
     * 从头节点开始处理：
     * - 头压栈 右压栈 左压栈
     * - 左弹出 右弹出 头弹出
     *
     * s1 栈：头 弹出压s2  左 右
     * s2 收集栈：  头 右 左
     *
     * s2 弹出： 左 右 头
     */
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            // 头压栈
            s1.push(head);
            while (!s1.isEmpty()) {
                // 弹出头
                head = s1.pop();
                // 头压s2栈
                s2.push(head);
                // 左压s1栈
                if (head.left != null) {
                    s1.push(head.left);
                }
                // 右压s1栈
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 非递归实现后续遍历 方式二
     *
     * 将整棵树左子树压入栈中，没有左子树弹出
     * 然后处理右子树，最后处理头节点
     *     1
     *    /\
     *   2  3
     *  /\  /\
     * 4 5 6  7
     *
     * 1 2          4
     * 1 2          5
     * 1            2
     * 1 3          6
     * 1 3          7
     * 1            3
     *              1
     *
     */
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                // peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除
                c = stack.peek();
                // 处理左子树 有左且未被压栈
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                // 处理右子树 有右且未被压栈
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    // 弹出一个值
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }
}
