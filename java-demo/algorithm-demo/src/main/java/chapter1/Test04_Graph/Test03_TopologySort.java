package chapter1.Test04_Graph;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 16:08
 * @description：拓扑排序
 * @modified By：
 * @version: $
 */
public class Test03_TopologySort {
    // 有向图且无环
    public static List<Node> sortedTopology(Graph graph) {
        // key为节点，Integer为入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 0入度队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 所有节点入度
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                // 0入度节点
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序结果，依次加入Result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 当前节点每一个后继节点入度减1
            for (Node next : cur.nexts) {
                // 入度减少一个
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
