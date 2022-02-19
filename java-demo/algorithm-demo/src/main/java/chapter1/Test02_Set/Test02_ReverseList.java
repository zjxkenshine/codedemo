package chapter1.Test02_Set;

/**
 * 【题目】分别实现反转单向链表和反转双向链表的函数
 * 【要求】如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 *
 * 单向链表：
 *  Pre   Node   Next
 * next → next → next
 * 变为：
 * next ← next ← next
 *
 * Node.next.next = Node
 * 再处理Next节点，Pre节点变为当前Node节点
 *
 *
 * 双向链表：
 * Pre   Node   Next
 * next → next → next
 * pre ←  pre  ← pre
 * 变为：
 * pre → pre → pre
 * next ← next ← next
 *
 * Next = Node.next
 * Node.pre = Node.next
 * Node.next = Pre
 * Node = next
 * 再处理Next节点，Pre节点变为当前Node节点
 *
 */
public class Test02_ReverseList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// 反转单链表
	public static Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while (head != null){
			next = head.next;
			// 下一个节点变为前一个节点
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static class DoubleNode {
		public int value;
		public DoubleNode pre;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

	// 反转双向链表
	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;

			// 往下移动
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.pre;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.pre = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.pre = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.pre = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));
	}

}
