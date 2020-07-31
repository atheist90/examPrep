package testingBaumeUndRekursion;

public class Baum {
    Knoten wurzel;


    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    private void printTree() {
        printNode(0, wurzel, "wurzel");
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



    public void m(Knoten k){
        if (k != null) {
            if(k.links != null) System.out.println(k.links.zahl);
            if(k.rechts != null) System.out.println(k.rechts.zahl);
            m(k.links);
            m(k.rechts);
        }
    }


    public static void main(String[] args) {
        Baum baum = new Baum();
        Knoten k12 = new Knoten(12);
        Knoten k23 = new Knoten(23);
        Knoten k25 = new Knoten(25);
        Knoten k18 = new Knoten(18);
        Knoten k14 = new Knoten(14);
        Knoten k16 = new Knoten(16);
        Knoten k27 = new Knoten(27);

        k12.setRechts(k25);
        k12.setLinks(k23);
        k23.setLinks(k18);
        k23.setRechts(k14);
        k14.setRechts(k27);
        k25.setLinks(k16);
        baum.wurzel = k12;
        baum.printTree();

        baum.m(baum.wurzel);

    }

}
