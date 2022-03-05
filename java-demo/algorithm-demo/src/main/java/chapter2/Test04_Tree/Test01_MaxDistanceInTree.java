package chapter2.Test04_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/5 12:30
 * @description：二叉树最大距离
 * @modified By：
 * @version: $
 */
public class Test01_MaxDistanceInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    // 返回的信息
    public static class ReturnType{
        // 最大距离
        public int maxDistance;
        // 高度
        public int h;

        public ReturnType(int m, int h) {
            this.maxDistance = m;;
            this.h = h;
        }
    }

    public static ReturnType process(Node head) {
        if(head == null) {
            return new ReturnType(0,0);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType = process(head.right);
        int includeHeadDistance = leftReturnType.h + 1 + rightReturnType.h;
        int p1 = leftReturnType.maxDistance;
        int p2 = rightReturnType.maxDistance;
        int resultDistance = Math.max(Math.max(p1, p2), includeHeadDistance);
        int hitself  = Math.max(leftReturnType.h, leftReturnType.h) + 1;
        return new ReturnType(resultDistance, hitself);
    }

    public static int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        // 左边最大值
        int lMax = posOrder(head.left, record);
        // 左边最大高度
        int maxfromLeft = record[0];
        // 右边最大值
        int rMax = posOrder(head.right, record);
        // 右边最大高度
        int maxFromRight = record[0];
        // 当前节点参与的最大值
        int curNodeMax = maxfromLeft + maxFromRight + 1;
        record[0] = Math.max(maxfromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistance(head1));

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistance(head2));

    }
}
