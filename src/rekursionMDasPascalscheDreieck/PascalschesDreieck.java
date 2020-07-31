package rekursionMDasPascalscheDreieck;

public class PascalschesDreieck {
    /*
     * Hier ist die main Methode.
     * Es sind schon ein paar Testfaelle vorgegeben, aber natuerlich
     * kannst du auch eigene Testfälle schreiben.
     */
    public static void main(String[] args) {
        System.out.println("In der Spitze des Dreiecks ist: " + pascal(0,0));
        System.out.println("An Stelle (2,1) steht die Zahl: " + pascal(2,1) + " (2 waere richtig)");
        System.out.println("An Stelle (3,2) steht die Zahl: " + pascal(3,2) + " (3 waere richtig)");
        System.out.println("An Stelle (4,1) steht die Zahl: " + pascal(4,1) + " (4 waere richtig)");
        System.out.println("An Stelle (4,2) steht die Zahl: " + pascal(4,2) + " (6 waere richtig)");
        System.out.println("An Stelle (5,2) steht die Zahl: " + pascal(5,2) + " (10 waere richtig)");
        System.out.println("An Stelle (6,2) steht die Zahl: " + pascal(6,2) + " (15 waere richtig)");
        System.out.println("An Stelle (6,3) steht die Zahl: " + pascal(6,3) + " (20 waere richtig)");
    }

    //Aufgabe 1
    public static int pascal(int n, int k) {
        if (k == 0 || k == n) return 1;
        else return pascal(n-1, k-1) + pascal(n-1, k);
    }
}