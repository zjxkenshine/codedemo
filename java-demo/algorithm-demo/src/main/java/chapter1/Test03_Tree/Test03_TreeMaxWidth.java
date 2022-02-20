package chapter1.Test03_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 14:30
 * @description：二叉树最大宽度
 * @modified By：
 * @version: $
 */
public class Test03_TreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 宽度优先遍历
    public static void WidthTraversal(Node head){
        if(head==null){
            return;
        }
        // 队列 先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            // 先输出，后放左放右
            System.out.println(cur.value);
            // 先放左,先拿左
            if(cur.left !=null){
                queue.add(cur.left);
            }
            // 后放右，后拿右
            if(cur.right !=null){
                queue.add(cur.right);
            }
        }
    }


    // 获取最大宽度 方式1 使用map
    public static int getMaxWidth(Node head){
        if(head==null){
            return 0;
        }
        // 队列 先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        //当前层
        int curLevel = 1;
        // 当前层节点数
        int curLevelNodes = 0;
        // 最大宽度
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            // 当前节点级别
            int curNodeLevel = levelMap.get(cur);
            // 节点层是当前层
            if(curLevel == curNodeLevel){
                // 当前层节点++
                curLevelNodes++;
            } else {
                // 记录最大宽度
                max = Math.max(max,curLevelNodes);
                // 当前层+1
                curLevel++;
                // 重置层节点数
                curLevelNodes = 1;
            }

            // 先输出，后放左放右
            System.out.println(cur.value);
            // 先放左,先拿左
            if(cur.left !=null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            // 后放右，后拿右
            if(cur.right !=null){
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return max;
    }

    /**
     * 获取最大宽度 方式二
     * 四个变量：
     * Node curEnd: 当前行最后一个节点
     * Node nextEnd: 下一行最后一个节点
     * int curLevelNode: 当前行节点数
     * int max: 最大宽度
     */
    // 宽度优先遍历
    public static int getMaxWidth2(Node head){
        if(head==null){
            return 0;
        }
        // 队列 先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        int max = Integer.MIN_VALUE;
        // 当前节点数
        int curLevelNodes = 0;
        // 当前层最后一个节点
        Node curEnd = head;
        // 下一层最后一个节点
        Node nextEnd = null;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            curLevelNodes++;
            // 先输出，后放左放右
            System.out.println(cur.value);
            // 先放左
            if(cur.left !=null){
                nextEnd = cur.left;
                queue.add(cur.left);
            }
            // 后放右
            if(cur.right !=null){
                nextEnd = cur.right;
                queue.add(cur.right);
            }
            // 当前节点是最后一个节点
            if(curEnd==cur){
                max = Math.max(curLevelNodes,max);
                curLevelNodes=0;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return max;
    }



//    // 获取最大宽度
//    public static int getMaxWidth(Node head) {
//        if (head == null) {
//            return 0;
//        }
//        // 最大宽度
//        int maxWidth = 0;
//        // 当前宽度
//        int curWidth = 0;
//        // 当前层
//        int curLevel = 1;
//        // 记录节点和层数
//        HashMap<Node, Integer> levelMap = new HashMap<>();
//        levelMap.put(head, 1);
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(head);
//        Node node = null;
//        Node left = null;
//        Node right = null;
//        while (!queue.isEmpty()) {
//            node = queue.poll();
//            left = node.left;
//            right = node.right;
//            if (left != null) {
//                levelMap.put(left, levelMap.get(node) + 1);
//                queue.add(left);
//            }
//            if (right != null) {
//                levelMap.put(right, levelMap.get(node) + 1);
//                queue.add(right);
//            }
//            if (levelMap.get(node) > curLevel) {
//                curWidth = 0;
//                curLevel = levelMap.get(node);
//            } else {
//                curWidth++;
//            }
//            maxWidth = Math.max(maxWidth, curWidth);
//        }
//        return maxWidth;
//    }

    public static void main(String[] args) {

    }
}
