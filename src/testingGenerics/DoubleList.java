package testingGenerics;

public class DoubleList <list> {

    private DoubleListItem<list> head;



    public void add(list value) {
        if (head == null) {
            head = new DoubleListItem<list>(value);

        }
        else {
            DoubleListItem<list> pointer = head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(new DoubleListItem(value));
        }
    }

    public static void main(String[] args) {
        DoubleList <Double> e = new DoubleList<>();
        e.add(11.0);
        e.add(3.0);
        e.add(5.0);
        e.add(7.0);
        e.add(0.5);
        e.add(10.2);


    }
}
