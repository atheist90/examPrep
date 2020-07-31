package rekursionSBinaryBaumMitIntegern;

import java.util.Stack;
public class BinaryTree {

	BinaryTreeNode top;

	public BinaryTree() {
		top = null;
	}

	/*
	 * BEGINN des zu implementierenden Bereichs
	 */

	// Aufgabe 1
	public void insert(int number) {
		if (top == null) {
			top = new BinaryTreeNode(number);
			return;
		}
		else insert(number, top);
	}

	private void insert(int number, BinaryTreeNode node) {
		if (number < node.getNumber()) {
			if (node.getSmaller() != null) insert(number, node.getSmaller());
			else node.setSmaller(new BinaryTreeNode(number));
		}
		else if (number > node.getNumber()) {
			if (node.getLarger() != null) insert(number, node.getLarger());
			else node.setLarger(new BinaryTreeNode(number));
		}
		else return;
	}
	// Aufgabe 2
	public int maxDepth() {
		if (top == null) return 0;
		else return maxDepth(top);
	}

	private int maxDepth(BinaryTreeNode node) {
		if (node == null) return 0;
		else return 1 + Math.max(maxDepth(node.getSmaller()), maxDepth(node.getLarger()));
	}

	// Aufgabe 3
	public int sumOfElements() {
		if (top == null) return 0;
		else return sumOfElements(top);
	}

	private int sumOfElements(BinaryTreeNode node) {
		if (node == null) return 0;
		else return node.getNumber() + sumOfElements(node.getSmaller()) + sumOfElements(node.getSmaller());
	}

	// Aufgabe 4
	public void deleteNumber(int number) {
		if (top == null) return;
		else if (top.getNumber() == number) {
			if (top.getLarger() == null && top.getSmaller() == null) {
				top = null;
				return;
			}
			else if (top.getSmaller() == null) {
				top = top.getLarger();
				return;
			}
			else if (top.getLarger() == null) {
				top = top.getSmaller();
				return;
			}
		}
		else deleteNodeByNumber(number, top);
	}

	private BinaryTreeNode deleteNumber(int number, BinaryTreeNode node) {
		if (node == null) return null;
		if (number < node.getNumber()) {
			node.setSmaller(deleteNumber(number, node.getSmaller()));
		}
		else if (number > node.getNumber()) {
			node.setLarger(deleteNumber(number, node.getLarger()));
		}
		else {
			// if there are no children
			if (node.getSmaller() == null && node.getLarger() == null) return null;
			// if there is only right child
			else if (node.getSmaller() == null) node.getLarger();
			// if there is only left child
			else if (node.getLarger() == null) node.getSmaller();
			//if both of them exists
			else {
				BinaryTreeNode tempNode = getMinNode(node.getLarger());
				node = tempNode;
				deleteNumber(tempNode.getNumber(), node.getLarger());
			}
		}
		return node;
	}

	private BinaryTreeNode getMinNode(BinaryTreeNode node) {
		if (node.getSmaller() == null) return node;
		else return getMinNode(node.getSmaller());
	}

	private void deleteNodeByNumber(int number, BinaryTreeNode node) {
		// поиск листка дерева
		if (node == null) return;
		else if (node.getSmaller() != null && number < node.getNumber() && node.getSmaller().getNumber() == number) {
			BinaryTreeNode temp = node;
			node = node.getSmaller();
			if (node.getSmaller() == null && node.getLarger() == null) {
				temp.setSmaller(null);
				return;
			}
			else if (node.getLarger() != null){
				temp.setSmaller(getMinNode(node.getLarger()));
				deleteNodeByNumber(getMinNode(node.getLarger()).getNumber(), node.getLarger());
				return;
			}
			else {
				temp.setSmaller(node.getSmaller());
				deleteNodeByNumber(node.getSmaller().getNumber(), node.getSmaller());
				return;
			}
		}
		else if (node.getLarger() != null && number > node.getNumber() && node.getLarger().getNumber() == number) {
			BinaryTreeNode temp = node;
			node = node.getLarger();
			if (node.getSmaller() == null && node.getLarger() == null) {
				temp.setSmaller(null);
				return;
			}
			else if (node.getLarger() != null){
				temp.setLarger(getMinNode(node.getLarger()));
				deleteNodeByNumber(getMinNode(node.getLarger()).getNumber(), node.getLarger());
				return;
			}
			else {
				temp.setLarger(node.getSmaller());
				deleteNodeByNumber(node.getSmaller().getNumber(), node.getSmaller());
				return;
			}
		}
		else if (node.getSmaller() != null && number < node.getNumber()) deleteNodeByNumber(number, node.getSmaller());
		else if (node.getLarger() != null && number > node.getNumber()) deleteNodeByNumber(number, node.getLarger());
		else return;
	}

	// Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
	private void printTree() {
		printNode(0, top, "top");
	}

	// Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
	// verwendet Rekursion
	private void printNode(int depth, BinaryTreeNode currentNode, String position) {
		if (currentNode != null) {
			printNode(depth + 1, currentNode.getLarger(), "right");
			String indentation = "";
			for (int i = 0; i < depth; i++) {
				indentation += "         ";
			}
			System.out.println(indentation + "- " + position + ":" + depth + ": " + currentNode.getNumber());
			printNode(depth + 1, currentNode.getSmaller(), "left");
		}
	}


	/*
	 * ENDE des zu implementierenden Bereichs
	 */

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.top = new BinaryTreeNode(11);
		tree.insert(5);
		tree.insert(15);
		tree.insert(1);
		tree.insert(7);
		tree.insert(13);
		tree.insert(20);
		tree.insert(6);
		tree.insert(8);

		tree.printTree();

		tree.deleteNumber(11);
		System.out.println("After deleting node <<left1:5>>");
		System.out.println();
		tree.printTree();
	}

}
