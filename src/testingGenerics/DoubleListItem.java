package testingGenerics;

public class DoubleListItem <list> {

    private list value;
    private DoubleListItem<list> next;

    public DoubleListItem(list value) {
        this.value = value;
    }

    public list getValue() {
        return value;
    }

    public void setValue(list value) {
        this.value = value;
    }

    public DoubleListItem<list> getNext() {
        return next;
    }

    public void setNext(DoubleListItem<list> next) {
        this.next = next;
    }
}
