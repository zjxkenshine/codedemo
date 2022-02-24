package chapter1.Test05_TrieAndGreedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/24 16:08
 * @description：
 * @modified By：
 * @version: $
 * 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数m
 * 含义：
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：
 * 你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：
 * 你最后获得的最大钱数
 *
 * 思路：
 * - 小根堆按花费从小到大排，将花费<=现有资金的弹出到大根堆
 *
 */
public class Test06_IPO {
    public static class Node {
        // 利润
        public int p;
        // 花费
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    // 花费小根堆
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    // 利润大根堆
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        // 花费小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        // 利润大根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
