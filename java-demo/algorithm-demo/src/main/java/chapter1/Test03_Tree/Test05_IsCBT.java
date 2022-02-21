package chapter1.Test03_Tree;

import java.util.LinkedList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 17:51
 * @description：是否完全二叉树判断
 * @modified By：
 * @version: $
 */
public class Test05_IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 是否完全二叉树
     * 1. 任意一个节点，有右无左，false
     * 2. 1不违规的情况下，遇到第一个左右子节点不全的节点，后续节点都为叶节点
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        // 队列
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过子节点不全的节点(只有左子节点)
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                    // 条件二： 后续节点都为叶子节点
                    (leaf && (l != null || r != null))
                    ||
                    // 条件一： 有右子节点没有左子节点
                    (l == null && r != null)) {
                return false;
            }
            // 左孩子不为空
            if (l != null) {
                // 添加左孩子
                queue.add(l);
            }
            // 右子节点不为空
            if (r != null) {
                // 添加右子节点
                queue.add(r);
            } else {
                // 右=空
                leaf = true;
            }
        }
        return true;
    }
}
