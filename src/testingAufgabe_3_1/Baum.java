package testingAufgabe_3_1;

import rekursionSBinaryBaumMitIntegern.BinaryTreeNode;
import testingRekursion.Node;

public class Baum {

    Knoten Wurzel;

    public void insert(int number) {
        if (Wurzel == null) {
           Wurzel = new Knoten(number);
            return;
        }
        else insert(number, Wurzel);
    }

    private void insert(int number, Knoten node) {
        if (number < node.getZahl()) {
            if (node.getLinks() != null) insert(number, node.getLinks());
            else node.setLinks(new Knoten(number));
        }
        else if (number > node.getZahl()) {
            if (node.getRechts() != null) insert(number, node.getRechts());
            else node.setRechts(new Knoten(number));
        }
        else return;
    }

    public static int m(Knoten k, int x) {
        if (k == null) return 0;
        else if (x <= k.Zahl && k.links == null) return k.Zahl;
        else if (x <= k.Zahl && k.links != null) return m(k.links, x);
        else if (x > k.Zahl && k.rechts == null) return k.Zahl;
        else {
            int r = m(k.rechts, x);
            if (x <= r) return k.Zahl;
            else return r;
        }
    }

    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    private void printTree() {
        printNode(0, Wurzel, "root");
    }

    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    // verwendet Rekursion
    private void printNode(int depth, Knoten currentNode, String position) {
        if (currentNode != null) {
            printNode(depth + 1, currentNode.getRechts(), "right");
            String indentation = "";
            for (int i = 0; i < depth; i++) {
                indentation += "         ";
            }
            System.out.println(indentation + "- " + position + ":" + depth + ": " + currentNode.getZahl());
            printNode(depth + 1, currentNode.getLinks(), "left");
        }
    }
    public static void main(String[] args) {
        Baum baum = new Baum();
        baum.insert(15);
        baum.insert(8);
        baum.insert(20);
        baum.insert(5);
        baum.insert(12);
        baum.insert(17);
        baum.insert(24);
        baum.insert(2);
        baum.insert(7);
        baum.insert(14);
        baum.insert(16);
        baum.insert(19);
        System.out.println("Baum seht so aus:");
        baum.printTree();
        System.out.println();
        System.out.println();
        System.out.println(m(baum.Wurzel, 15));
        System.out.println("Bei uns ist 14 ");
        System.out.println();
        System.out.println(m(baum.Wurzel, 16));
        System.out.println("Bei uns ist 20");
        System.out.println();
        System.out.println(m(baum.Wurzel, 19));
        System.out.println("Bei uns ist 17");
    }

}
