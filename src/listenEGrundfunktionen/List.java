package listenEGrundfunktionen;


public class List {

    private static final String START_LABEL = "|START|";
    public Element head;

    // Aufgabe 1
    public void addElement(Element newElement) {
        if(head == null) {
            head = newElement;
            return;
        }
        Element element = head;
        while (element.getNext() != null) {
            element = element.getNext();
        }
        element.setNext(newElement);
    }

    // Aufgabe 2
    public int getSize() {
        if (head == null) return 0;
        return getSize(head);
    }
    private int getSize (Element element) {
        if (element == null) return 0;
        else return 1 + getSize(element.getNext());
    }

    // Aufgabe 3
    public void increase() {
        Element element = head;
        while (element != null) {
            element.setValue(element.getValue() + 1);
            element = element.getNext();
        }
    }

    // Aufgabe 4
    public void deleteElement() {
        head = head.getNext();
    }

    // Methode, die zur Darstellung der Liste dient.
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(START_LABEL);

        Element pointer = head;
        while (pointer != null) {
            str.append("---> ");
            str.append(pointer.getValue());
            pointer = pointer.getNext();
        }

        str.append("---> null");

        return str.toString();
    }
}
