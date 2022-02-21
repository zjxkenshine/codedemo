package chapter1.Test03_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 18:26
 * @description：判断是否是满二叉树
 * @modified By：
 * @version: $
 * <p>
 * 递归套路
 */
public class Test06_IsFBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }
        Info data = f(head);
        // 是否是2^n-1
        return data.nodes == (1 << data.height - 1);
    }

    // 返回高度和节点个数
    public static class Info {
        public int height;
        public int nodes;

        public Info(int h, int n) {
            height = h;
            nodes = n;
        }
    }

    public static Info f(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        // 左子树信息
        Info leftInfo = f(x.left);
        // 右子树信息
        Info rightInfo = f(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }

}
