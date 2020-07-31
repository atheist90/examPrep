package testingExamEx.listsEx;

public class Element {
    private Payload value;
    private Element next;

    public Element (Payload value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Payload getValue(){
        return this.value;
    }
}
