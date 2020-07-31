package testingRekursion;

public class BinaryTree {
    private Node root;

    public void insert(int number) {
        if (root == null) root = new Node(number);
        else insert(number, root);
    }

    private void insert(int number, Node node) {
        if (node.getNextRight() == null) node.setNextRight(new Node(number));
        else if (node.getNextLeft() == null) node.setNextLeft(new Node(number));
        else {
            if (maxHeight(node.getNextRight()) <= maxHeight(node.getNextLeft()))
                insert(number, node.getNextRight());
            else insert(number, node.getNextLeft());
        }
    }

    private int maxHeight(Node node) {
        if (node == null) return 0;
        return (1 + Math.max(maxHeight(node.getNextLeft()), maxHeight(node.getNextRight())));
    }
    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    private void printTree() {
        printNode(0, root, "root");
    }

    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    // verwendet Rekursion
    private void printNode(int depth, Node currentNode, String position) {
        if (currentNode != null) {
            printNode(depth + 1, currentNode.getNextRight(), "right");
            String indentation = "";
            for (int i = 0; i < depth; i++) {
                indentation += "         ";
            }
            System.out.println(indentation + "- " + position + ":" + depth + ": " + currentNode.getNumber());
            printNode(depth + 1, currentNode.getNextLeft(), "left");
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(12);
        tree.insert(17);
        tree.insert(30);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);

        tree.insert(3);
        tree.insert(9);
        tree.insert(7);
        tree.insert(5);
        tree.printTree();


    }

}
