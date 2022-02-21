package chapter1.Test03_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 18:39
 * @description：是否平衡二叉树
 * @modified By：
 * @version: $
 */
public class Test07_IsAVL {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        // 是否平衡二叉树
        public boolean isBalanced;
        // 二叉树高度
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }
    }

    public static ReturnType process(Node x) {
        // 空树也为平衡二叉树
        if (x == null) {
            return new ReturnType(true, 0);
        }
        // 左树高度
        ReturnType leftData = process(x.left);
        // 右树高度
        ReturnType rightData = process(x.right);
        // 左子树与右子树的高度较高的 整个树的高度
        int height = Math.max(leftData.height, rightData.height) + 1;
        // 左子树和右子树都为平衡二叉树，并且高度差小于等于1
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
