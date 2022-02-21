package chapter1.Test03_Tree;

import java.util.LinkedList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 9:34
 * @description：二叉搜索树判断
 * @modified By：
 * @version: $
 * <p>
 * 中序遍历有序，则为二叉搜索树
 */
public class Test04_IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 判断是否是二叉搜索树
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> inOrderList = new LinkedList<>();
        process(head, inOrderList);
        int pre = Integer.MIN_VALUE;
        // 判断nodeList是否从小到大升序
        for (Node cur : inOrderList) {
            if (pre >= cur.value) {
                return false;
            }
            pre = cur.value;
        }
        return true;
    }

    public static void process(Node node, LinkedList<Node> inOrderList) {
        if (node == null) {
            return;
        }
        process(node.left, inOrderList);
        inOrderList.add(node);
        process(node.right, inOrderList);
    }

    public static int preValue = Integer.MIN_VALUE;


    // 是否搜索二叉树 方式二
    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST) {
            // 左树不是搜索二叉树 则不是搜索二叉树
            return false;
        }
        if (head.value < preValue) {
            // 不是搜索二叉树
            return false;
        } else {
            preValue = head.value;
        }
        // 右子树
        return checkBST(head.right);
    }

    // 判断是否二叉搜索树，方式三 递归套路
    // 返回值
    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma) {
            // 是否二叉搜索树
            isBST = is;
            // 最小值
            min = mi;
            // 最大值
            max = ma;
        }
    }

    // 递归处理
    public static ReturnData process(Node x){
        if (x == null){
            return null;
        }
        // 左子树给的信息
        ReturnData leftData = process(x.left);
        // 右子树给的信息
        ReturnData rightData = process(x.right);

        // 处理递归返回的值
        int min = x.value;
        int max = x.value;
        // 左子树信息
        if(leftData!=null){
            min = Math.min(min,leftData.min);
            max = Math.min(max,leftData.max);
        }
        // 右子树信息
        if(rightData!=null){
            min = Math.min(min,rightData.min);
            max = Math.min(max,rightData.max);
        }
//        boolean isBST=true;
//        // 左边信息不为空，左边不是二叉搜索树 或 left.max<x.value
//        if(leftData!=null&&(!leftData.isBST||leftData.max>=x.value)){
//            isBST=false;
//        }
//        // 右树不为空且右树不是二叉搜索树 或  x.value>right.min
//        if(rightData!=null&&(!rightData.isBST||x.value>=rightData.min)){
//            isBST=false;
//        }

        // 第二种写法
        boolean isBST = false;
        if (
                (leftData == null || (leftData.isBST && leftData.max < x.value))
                &&
               (rightData == null || (rightData.isBST && rightData.min > x.value))
        ) {
            isBST=true;
        }
        return new ReturnData(isBST,min,max);
    }

}
