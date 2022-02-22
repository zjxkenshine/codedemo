package chapter1.Test03_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 10:44
 * @description：求后继节点
 * @modified By：
 * @version: $
 *
 * 后继节点定义：中序遍历下一个
 * 【题目】 现在有一种新的二叉树节点类型如下:
 * public class Node {
 *      public int value;
 *      public Node left;
 *      public Node right;
 *      public Node parent;
 *      public Node(int val) {
 *          value = val;
 *      }
 * }
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己的父节点，头节点的parent指向null。
 * 只给一个在二叉树中的某个节点node，请实现返回node的后继节点的函数。
 * 在二叉树的中序遍历的序列中，
 *    A
 *   / \
 *  B   C
 * /\  /\
 *D  EF  G
 * 中序遍历：D B E A F C G
 * D的后继节点为B，B后继节点为E，以此类推
 *
 * 方式一：直接中序遍历到map中然后找
 * 方式二： 通过树递归方式
 *  情况1： x有右树，x后继为右树上最左节点
 *  情况2: x无右树
 *    - x是否为其父亲的左子节点
 *      - 是：后继节点为父节点
 *      - 否：x变为父节点，继续往上走
 *  情况3: 整棵树最右节点，G，后继为空
 *
 */
public class Test10_SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    // 获取后继节点
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        // 有右树
        if (node.right != null) {
            // 右树上的最左节点
            return getLeftMost(node.right);
        } else {
            // 没有右子树，往上走
            Node parent = node.parent;
            // 是否是父节点的孩子
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 获取最左节点
    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        // 一路往左
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
