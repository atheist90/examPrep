package listenMErweiterteFunktionen;


public class Element {

    private Element next;
    private int value;
    private String name;

    public Element(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void increaseByOne() {
        value++;
    }

}
