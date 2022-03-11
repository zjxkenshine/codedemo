package chapter2.Test07_Tree;

/**
 * BST实现
 */
public class AbstractBinarySearchTree {

	public Node root;

	protected int size;

	protected Node createNode(int value, Node parent, Node left, Node right) {
		return new Node(value, parent, left, right);
	}

	public Node search(int element) {
		Node node = root;
		while (node != null && node.value != null && node.value != element) {
			if (element < node.value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	public Node insert(int element) {
		if (root == null) {
			root = createNode(element, null, null, null);
			size++;
			return root;
		}

		Node insertParentNode = null;
		Node searchTempNode = root;
		while (searchTempNode != null && searchTempNode.value != null) {
			insertParentNode = searchTempNode;
			if (element < searchTempNode.value) {
				searchTempNode = searchTempNode.left;
			} else {
				searchTempNode = searchTempNode.right;
			}
		}

		Node newNode = createNode(element, insertParentNode, null, null);
		if (insertParentNode.value > newNode.value) {
			insertParentNode.left = newNode;
		} else {
			insertParentNode.right = newNode;
		}

		size++;
		return newNode;
	}

	public Node delete(int element) {
		Node deleteNode = search(element);
		if (deleteNode != null) {
			return delete(deleteNode);
		} else {
			return null;
		}
	}

	protected Node delete(Node deleteNode) {
		if (deleteNode != null) {
			Node nodeToReturn = null;
			if (deleteNode != null) {
				if (deleteNode.left == null) {
					nodeToReturn = transplant(deleteNode, deleteNode.right);
				} else if (deleteNode.right == null) {
					nodeToReturn = transplant(deleteNode, deleteNode.left);
				} else {
					Node successorNode = getMinimum(deleteNode.right);
					if (successorNode.parent != deleteNode) {
						transplant(successorNode, successorNode.right);
						successorNode.right = deleteNode.right;
						successorNode.right.parent = successorNode;
					}
					transplant(deleteNode, successorNode);
					successorNode.left = deleteNode.left;
					successorNode.left.parent = successorNode;
					nodeToReturn = successorNode;
				}
				size--;
			}
			return nodeToReturn;
		}
		return null;
	}

	private Node transplant(Node nodeToReplace, Node newNode) {
		if (nodeToReplace.parent == null) {
			this.root = newNode;
		} else if (nodeToReplace == nodeToReplace.parent.left) {
			nodeToReplace.parent.left = newNode;
		} else {
			nodeToReplace.parent.right = newNode;
		}
		if (newNode != null) {
			newNode.parent = nodeToReplace.parent;
		}
		return newNode;
	}

	public boolean contains(int element) {
		return search(element) != null;
	}

	public int getMinimum() {
		return getMinimum(root).value;
	}

	public int getMaximum() {
		return getMaximum(root).value;
	}

	public int getSuccessor(int element) {
		return getSuccessor(search(element)).value;
	}


	public int getSize() {
		return size;
	}


	public void printTreeInOrder() {
		printTreeInOrder(root);
	}


	public void printTreePreOrder() {
		printTreePreOrder(root);
	}


	public void printTreePostOrder() {
		printTreePostOrder(root);
	}

	/*-------------------PRIVATE HELPER METHODS-------------------*/
	private void printTreeInOrder(Node entry) {
		if (entry != null) {
			printTreeInOrder(entry.left);
			if (entry.value != null) {
				System.out.println(entry.value);
			}
			printTreeInOrder(entry.right);
		}
	}

	private void printTreePreOrder(Node entry) {
		if (entry != null) {
			if (entry.value != null) {
				System.out.println(entry.value);
			}
			printTreeInOrder(entry.left);
			printTreeInOrder(entry.right);
		}
	}

	private void printTreePostOrder(Node entry) {
		if (entry != null) {
			printTreeInOrder(entry.left);
			printTreeInOrder(entry.right);
			if (entry.value != null) {
				System.out.println(entry.value);
			}
		}
	}

	protected Node getMinimum(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	protected Node getMaximum(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	protected Node getSuccessor(Node node) {
		// if there is right branch, then successor is leftmost node of that
		// subtree
		if (node.right != null) {
			return getMinimum(node.right);
		} else { // otherwise it is a lowest ancestor whose left child is also
			// ancestor of node
			Node currentNode = node;
			Node parentNode = node.parent;
			while (parentNode != null && currentNode == parentNode.right) {
				// go up until we find parent that currentNode is not in right
				// subtree.
				currentNode = parentNode;
				parentNode = parentNode.parent;
			}
			return parentNode;
		}
	}

	// -------------------------------- TREE PRINTING
	// ------------------------------------

	public void printTree() {
		printSubtree(root);
	}

	public void printSubtree(Node node) {
		if (node.right != null) {
			printTree(node.right, true, "");
		}
		printNodeValue(node);
		if (node.left != null) {
			printTree(node.left, false, "");
		}
	}

	private void printNodeValue(Node node) {
		if (node.value == null) {
			System.out.print("<null>");
		} else {
			System.out.print(node.value.toString());
		}
		System.out.println();
	}

	private void printTree(Node node, boolean isRight, String indent) {
		if (node.right != null) {
			printTree(node.right, true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		printNodeValue(node);
		if (node.left != null) {
			printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
	}

	public static class Node {
		public Node(Integer value, Node parent, Node left, Node right) {
			super();
			this.value = value;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public Integer value;
		public Node parent;
		public Node left;
		public Node right;

		public boolean isLeaf() {
			return left == null && right == null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}
}
