package chapter1.Test04_Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 14:28
 * @description：宽度(广度)优先遍历
 * @modified By：
 * @version: $
 */
public class Test01_BFS {

    // 深度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        // 用于遍历的队列
        Queue<Node> queue = new LinkedList<>();
        // 是否已经访问过的节点
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            // 每一个节点的后继节点
            for (Node next : cur.nexts) {
                // 没有访问过的节点
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
