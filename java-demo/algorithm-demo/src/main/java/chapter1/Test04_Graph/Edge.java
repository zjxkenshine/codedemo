package chapter1.Test04_Graph;

/**
 * 有向边
 * 无向边两个边拼在一起
 */
public class Edge {
	public int weight;
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
