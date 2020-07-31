package testingRekursionDeleteNode;

import java.util.Stack;

public class Tree {
    static Tree tree;
    Node root;

    // 1. Inserting a node;

    public void insert(int number) {
        if (root == null) {
            root = new Node(number);
            return;
        }
        else insert(number, root);
    }

    private void insert(int number, Node node) {
        if (number < node.getNumber()) {
            if (node.getLeft() != null) insert(number, node.getLeft());
            else node.setLeft(new Node(number));
        }
        else if (number > node.getNumber()) {
            if (node.getRight() != null) insert(number, node.getRight());
            else node.setRight(new Node(number));
        }
        else return;
    }

    // 2. Amount of elements in BST
    public int size(){
        if (root == null) return 0;
        else return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return 1 + size(node.getLeft()) + size(node.getRight());
    }

    // 3. Maximum depth of BST
    public int maxDepth(){
        if (root == null) return 0;
        else return maxDepth(root);
    }

    private int maxDepth(Node node){
        if (node == null) return 0;
        else return 1 + Math.max( maxDepth(node.getLeft()) , maxDepth(node.getRight()) );
    }

    // 4. Delete the node from BST
    public void delete(int number) {
        if (root == null) return;
        else delete(root, number);
    }

    private Node delete(Node node, int number) {
        if (node == null) return null;
        if (number < node.getNumber())
            node.setLeft(delete(node.getLeft(), number));
        else if (number > node.getNumber())
            node.setRight(delete(node.getRight(), number));
        else {
            // node with no leaf
            if(node.getLeft() == null && node.getRight() == null) {
                System.out.println("Deleting: " + node.getNumber());
                return null;
            }
            // node with one node (no left node)
            else if (node.getLeft() == null) {
                System.out.println("Deleting: " + node.getNumber());
                return node.getLeft();
            }
            // node with one node (no right node)
            else if (node.getRight() == null) {
                System.out.println("Deleting: " + node.getNumber());
                return node.getRight();
            }
            // node with two nodes
            else {
                // search for a min number in right sub tree
                Integer minValue = minValue(node.getRight());
                node.setNumber(minValue);
                node.setRight(delete(node.getRight(), minValue));
                System.out.println("Deleting: " + number);
            }
        }
        return node;
    }

    private Integer minValue(Node node) {
        if (node.getLeft() != null) return minValue(node.getLeft());
        else return node.getNumber();
    }


    // 5. Sum of left and right nodes and save the result in root, if left OR right node is NULL, save 1 in root node

    public void sumOfChildren() {
        if (root == null) return;
        else sumOfChildren(root);
    }

    private void sumOfChildren(Node node) {
        if (node == null) return;
        else if (node.getRight() == null || node.getLeft() == null) {
            node.setNumber(1);
            if (node.getLeft() != null) sumOfChildren(node.getLeft());
            else sumOfChildren(node.getRight());
        }
        else {
            node.setNumber(node.getLeft().getNumber() + node.getRight().getNumber());
            sumOfChildren(node.getLeft());
            sumOfChildren(node.getRight());
        }
    }

    // 6. Self multiplication (if node number = 2, after have to be 2*2 =4
    public void selfMultiplication(){
        if (root == null) return;
        else selfMultiplication(root);

    }

    private void selfMultiplication(Node node) {
        if (node == null) return;
        if (node.getRight() != null && node.getLeft() != null) {
            node.setNumber(node.getNumber() * node.getLeft().getNumber() * node.getRight().getNumber());
        }
        if (node.getLeft() != null) selfMultiplication(node.getLeft());
        if (node.getRight() != null) selfMultiplication(node.getRight());
    }

    // 7. Record all numbers to array (InOrder)
    public int [] intoArray() {
        if (root == null) return null;
        else {
            int [] array = new int [size()];
            return intoArray(root, array);
        }
    }

    private int [] intoArray(Node node, int [] array) {
        // Saving index in letztes element of array.
        if(array[array.length-1] == array.length-1){
            array[array[array.length-1]] = node.getNumber();
        }
        else {
            array[array[array.length-1]] = node.getNumber();
            array[array.length-1]++;
        }
        if (node.getLeft() != null) array = intoArray(node.getLeft(), array);
        if (node.getRight() != null) array = intoArray(node.getRight(), array);

        return array;

        // array =
    }

    // 8. Amount of nodes with no leafs (iterative)
    public int countIterativeNodesNoLeafs(){
        if (root == null) return 0;
        Stack <Node> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.getLeft() != null) stack.push(node.getLeft());
            if (node.getRight() != null) stack.push(node.getRight());
            if (node.getLeft() == null && node.getRight() == null) count++;
        }

        return count;
    }

    // 9. Amount of nodes with no leafs (rekursive)
    public int countNodesWithNoLeafs(){
        if (root == null) return 0;
        else return countNodesWithNoLeafs(root);
    }

    private int countNodesWithNoLeafs(Node node) {
        if (node == null) return 0;
        else
            return (node.getRight() == null && node.getLeft() == null) ? 1 : (countNodesWithNoLeafs(node.getLeft()) + countNodesWithNoLeafs(node.getRight()));
    }

    // 10. Find a number in tree iterative. If number exist returns true, else false;
    public boolean numberInTree(int number) {
        if (root == null) return false;
        Node node = root;
        while (node != null) {
            if (number < node.getNumber()) node = node.getLeft();
            else if (number > node.getNumber()) node = node.getRight();
            else if (number == node.getNumber()) return true;
            else return false;
        }
        return false;
    }

    // 11. Find a number recursively. If number exist returns true, else false
    public boolean numberExist(int number) {
        if (root == null) return false;
        else return numberExist(number, root);
    }
    private boolean numberExist(int number, Node node) {
        if (node == null) return false;
        if (node.getNumber() == number) return true;
        else return numberExist(number, node.getLeft()) || numberExist(number, node.getRight());
    }

    // 12. Make from BST a balanced BST.
    /*
    We need to divide this exercise into 2 parts.
    First part = we will create an array, and save there everything INORDER.
    Second part = we will split array till array.length = 1;
    Third part = we will ad splitted arrays to BST
    */

    // Делит данный массив на два массива и
    public void splitArray(int [] array) {
        int [] arrayLeft = new int[array.length/2];
        int [] arrayRight = new int [array.length - array.length/2];
        for (int i = 0; i < array.length/2; i++) {
            if (array.length/2 == i) tree.insert(array[i]);
            else arrayLeft[i] = array[i];
        }
        splitArray(arrayLeft);
        for (int i = arrayLeft.length; i < array.length; i++) {
            if (arrayRight.length/2 == i - arrayLeft.length) tree.insert(array[i]);
            else arrayRight[i-arrayLeft.length] = array[i];
        }
        splitArray(arrayRight);

    }



    private Tree getTree(){
        return tree;
    }



    // Printing function
    private void printTree() {
        printNode(0, root, "root");
    }
    private void printNode(int depth, Node currentNode, String position) {
        if (currentNode != null) {
            printNode(depth + 1, currentNode.getRight(), "right");
            String indentation = "";
            for (int i = 0; i < depth; i++) {
                indentation += "         ";
            }
            System.out.println(indentation + "- " + position + ":" + depth + ": " + currentNode.getNumber());
            printNode(depth + 1, currentNode.getLeft(), "left");
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(20);
        tree.insert(7);
        tree.insert(4);
        tree.insert(11);
        tree.insert(12);
        tree.insert(10);
        tree.insert(22);
        tree.insert(18);
        tree.insert(19);
        tree.insert(14);
        tree.printTree();
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Amount of Elements in BST: " + tree.size());
        System.out.println("Amount of Elements without Leafs (iteratively): " + tree.countIterativeNodesNoLeafs());
        System.out.println("Amount of Elements without Leafs (recursively): " + tree.countNodesWithNoLeafs());
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Maximum Depth in BST: " + tree.maxDepth());
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Printing inOrder and save everything to array");
        System.out.println();
        System.out.println(" ======== Here array starts ========");
        int[]treeToArray = tree.intoArray();
        for (int i = 0; i < treeToArray.length; i++) {
            System.out.println(treeToArray[i]);
        }
        System.out.println(" ======== Here array ends ==========");
        System.out.println();
        System.out.println("--------- Find number in tree iterative --------");
        System.out.println("Looking number 18. Must return: true");
        System.out.println("                Your answer is: " + tree.numberInTree(18));
        System.out.println("Looking number 2. Must return: false");
        System.out.println("               Your answer is: " + tree.numberInTree(2));
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("--------- Find number in tree recursively -------");
        System.out.println("Looking number 18. Must return: true");
        System.out.println("                Your answer is: " + tree.numberExist(18));
        System.out.println("Looking number 2. Must return: false");
        System.out.println("               Your answer is: " + tree.numberExist(2));
        System.out.println("------------------------------------------------");

    }
}
