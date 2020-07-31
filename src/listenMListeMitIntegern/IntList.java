package listenMListeMitIntegern;

public class IntList {

    // Das erste Element der Liste.
    private IntListElement first;

    /*
     * BEGINN des zu bearbeitenden Codes
     */

    // Aufgabe 1
    public void append(int number) {
        IntListElement element = new IntListElement();
        element.setNumber(number);
        if (first == null) first = element;
        else {
            IntListElement current = first;
            if (number < current.getNumber()){
                first = element;
                element.setNext(current);
                return;
            }
            while (current.getNext() != null && current.getNext().getNumber() < number) {
                current = current.getNext();
            }
            IntListElement next = current.getNext();
            current.setNext(element);
            element.setNext(next);
        }
    }

    // Aufgabe 2
    public int size() {
        if (first == null) return 0;
        else {
            int sum = 0;
            IntListElement element = first;
            while (element != null) {
                sum++;
                element = element.getNext();
            }
            return sum;
        }
    }

    // Aufgabe 3
    public int get(int index) {
        if (index < 0 || index >= size()) return 0;
        IntListElement element = first;
        int counter = 0;
        while (element != null && counter < index) {
            element = element.getNext();
            counter++;
        }
        return element.getNumber();
    }

    // Aufgabe 4
    public void reverse() {
        if (first == null) return;
        IntListElement prev = null, current = first, next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        first = prev;

    }

    /*
     * ENDE des zu bearbeitenden Codes
     */

    public static void main(String[] args) {
        IntList l = new IntList();
        l.append(10);
        l.append(20);
        l.append(42);
        l.append(-10);
        l.append(30);
        System.out.println("So sieht die Liste aus: " + l);
        System.out.println("Das Element an Index 0: " + l.get(0));
        System.out.println("Das Element an Index -10 (Gibt es nicht, sollte also 0 sein): " + l.get(-10));
        System.out.println("Das Element an Index 100 (Gibt es nicht, sollte also 0 sein): " + l.get(100));
        System.out.println("Das Element an Index 2: " + l.get(2));
        System.out.println("Die Liste hat " + l.size() + " Elemente.");
        l.reverse();
        System.out.println("Liste wurde gedreht");
        System.out.println("Nun sieht die Liste so aus: " + l);
    }

    public String toString() {
        String liste = "first --> ";
        IntListElement element = first;
        while (element != null) {
            liste = liste + element.getNumber();
            liste = liste + " --> ";
            element = element.getNext();
        }
        liste = liste + "null";
        return liste;
    }
}