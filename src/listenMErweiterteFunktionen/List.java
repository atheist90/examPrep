package listenMErweiterteFunktionen;

public class List {
    private static final String START_LABEL = "|START|";
    public Element head;

    // Aufgabe 1
    public void addElement(Element newElement, int position) {
        if (position < 1 || position > size()+1 || head == null) return;
        if (position == 1) {
            newElement.setNext(head);
            head = newElement;
            return;
        }
        Element current = head;

        if (position == size()+1) {
            for (int i = 1; i < position-1; i++) {
                current = current.getNext();
            }
            newElement.setNext(current.getNext());
            current.setNext(newElement);
            return;
        }

        for (int i = 1; i < position-1; i++) {
            current = current.getNext();
        }
        newElement.setNext(current.getNext());
        current.setNext(newElement);

    }
    public int size() {
        if (head == null) return 0;
        else return size (head);
    }
    private int size (Element element) {
        if (element == null) return 0;
        else return 1 + size(element.getNext());
    }

    // Aufgabe 2
    public int getPosition(Element wanted) {
        Element element = head;
        int count = 1;
        while (element != null) {
            if ((element.getName().equals(wanted.getName()) && (element.getValue() == wanted.getValue()))) return count;
            element = element.getNext();
            count++;
        }
        return 0;
    }

    // Aufgabe 3
    public String getName(int position) {
        if (head == null || position < 0 || position > size()) return null;
        Element current = head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        return current.getName();
    }

    // Aufgabe 4
    public void deleteElement() {
        if (head == null) return;
        if (size() == 1) {
            head = null;
            return;
        }
        Element element = head;
        for (int i = 1; i < size()-1; i++) {
            element = element.getNext();
        }
        element.setNext(null);
    }

    // ------------- HILFSMETHODEN ---------------

    // Methode zum Ausgeben der Anzahl der Elemente in der Liste.
    public int getSize() {
        int count = 0;
        Element pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.getNext();
        }
        return count;
    }

    // Methode zum Einfuegen eines neuen Elementes am Ende der Liste.
    public void addElement(Element newElement) {
        if (head == null) {
            head = newElement;
        } else {
            Element pointer = this.head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(newElement);
        }
    }

    // Methode, die die komplette Liste löscht.
    public void clearList() {
        head = null;
    }

    // Methode, die zur Darstellung der Liste dient.
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(START_LABEL);
        Element pointer = head;
        while (pointer != null) {
            str.append("---> ");
            str.append(pointer.getName());
            pointer = pointer.getNext();
        }

        str.append("---> null");
        return str.toString();
    }
}