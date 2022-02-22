package chapter1.Test04_Graph;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 17:08
 * @description：Kruskal算法实现02 不使用并查集
 * @modified By：
 * @version: $
 */
public class Test05_Kruskal02 {

    public static class MySets{
        public HashMap<Node, List<Node>> setMap;

        public MySets(Collection<Node> nodes){
            for(Node cur:nodes){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }


        // 是否相同集合
        public boolean isSameSet(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        // from集合和to集合合并
        public void union(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);

            for(Node toNode:toSet){
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }

    // 边比较
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }


    public static Set<Edge> kruskalMST(Graph graph) {
        MySets unionFind = new MySets(graph.nodes.values());
        // 堆，按照边的权值从小到大
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }

}
