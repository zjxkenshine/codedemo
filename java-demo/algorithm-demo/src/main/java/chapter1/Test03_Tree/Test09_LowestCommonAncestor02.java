package chapter1.Test03_Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 20:43
 * @description：最低公共节点2.0
 * @modified By：
 * @version: $
 */
public class Test09_LowestCommonAncestor02 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // o1和o2一定属于head为头的树
    // 返回o1和o2的最低公共祖先
    public static Node lca(Node head,Node o1,Node o2){
        // 获取所有节点的父节点
        HashMap<Node,Node> fatherMap = new HashMap<>();
        fatherMap.put(head,head);
        process(head,fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        set1.add(o1);
        // 节点1
        Node cur = o1;
        while(cur != fatherMap.get(cur)){
            // o1节点往上
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        // 添加head
        set1.add(head);
        // 节点2往上遍历，遇到Set中的节点则为公共节点
        Node cur2 = o2;
        while(!set1.contains(cur2)){
            cur2=fatherMap.get(cur2);
        }
        return cur2;
    }

    public static void process(Node head, HashMap<Node,Node> fatherMap){
        if(head==null){
            return;
        }

        // 设置父节点
        fatherMap.put(head.left,head);
        fatherMap.put(head.right,head);

        process(head.left,fatherMap);
        process(head.right,fatherMap);
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        printTree(head);
        System.out.println("===============");

        Node o1 = head.left.right;
        Node o2 = head.right.left;

        System.out.println("o1 : " + o1.value);
        System.out.println("o2 : " + o2.value);
        System.out.println("ancestor : " + lca(head, o1, o2).value);
        System.out.println("===============");

    }

}
