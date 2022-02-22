package chapter1.Test04_Graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 14:47
 * @description：深度优先遍历
 * @modified By：
 * @version: $
 */
public class Test02_DFS {
    // 深度优先遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        // 栈
        Stack<Node> stack = new Stack<>();
        // 集合
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    // 重新压入当前节点
                    stack.push(cur);
                    // 压入另一个相邻节点
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
