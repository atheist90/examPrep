package testingExamEx.listsEx;

import java.lang.reflect.Array;

public class List {

    private Element head;

    public void add(int index, Payload l) {
        Element node = new Element(l);
        if (index == 0) {
            node.setNext(head);
            head = node;
        }
        else {
            Element prev = getElement(index-1);
            if (prev != null) {
                node.setNext(prev.getNext());
                prev.setNext(node);
            }
        }
    }

    public Element getElement(int index){
        if (index >=0) {
            Element node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.getNext();
            }
            return node;
        }
        else {
            return null;
        }
    }

    public boolean isSorted() {
        if (head == null) return true;
        Element node = head;
        while (node != null && node.getNext() != null) {
            if (node.getValue().toString().length() > node.getNext().getValue().toString().length())
                return false;
            node = node.getNext();
        }
        return true;
    }


    public String printList(){
        Element node = head;
        String printed = "| HEAD |";
        while (node != null) {
            printed = printed + " --> " + node.getValue().toString();
            node = node.getNext();
        }
        return printed;
    }

    public void removeUnsorted(){
        if(isSorted() || head == null || head.getNext() == null) return;
        // If the first element.length bigger than the second.
        if (head.getValue().toString().length() > head.getNext().getValue().toString().length()) {
            head.setNext(head.getNext().getNext());
            removeUnsorted();
            return;
        }
        Element node = head, prev = null;
        while (node != null) {
            prev = node;
            node = node.getNext();
            if (prev.getValue().toString().length() > node.getValue().toString().length()) {
                break;
            }
        }
        System.out.println(" NODE content: " + node.getValue().toString());
        System.out.println(" PREV content: " + prev.getValue().toString());
        prev.setNext(node.getNext());
        removeUnsorted();

    }

    public void removeIteratively(){

        if (head == null || isSorted() || head.getNext() == null) return;
        Element node = head;
        while (node.getNext() != null){
            if (node.getValue().toString().length() > node.getNext().getValue().toString().length()){
                node.setNext(node.getNext().getNext());
            }
            else node = node.getNext();
        }
    }

    public void addSorted(Payload [] data) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                Element node = head;
                Element currArr = new Element(data[i]);
                if (node.getValue().toString().length() > data[i].toString().length()){
                    currArr.setNext(node);
                    head = currArr;
                } else {
                    while(node.getNext().getValue().toString().length() < data[i].toString().length()
                    && node.getNext() != null){
                        node = node.getNext();
                    }
                    currArr.setNext(node.getNext());
                    node.setNext(currArr);
                }
            }
        }
    }


    public static void main(String[] args) {
        List list = new List();
        list.add(0, new Payload("aa"));
        list.add(1, new Payload("bbb"));
        list.add(2, new Payload("cccc"));
        list.add(3, new Payload("ddddd"));
        System.out.println(" ----- List выглядит так: -----");
        System.out.println(list.printList());
        Payload [] payloads =  {
            new Payload("a"),
            new Payload("bb"),
            new Payload("c")
        };
        System.out.println(" ----- Добавляем массив со значениями: -----");
        System.out.println("[a], [bb], [c]");
        list.addSorted(payloads);
        System.out.println(" ----- List должен выглядеть так: ------");
        System.out.println(" a -> a -> c -> bb -> bb -> cccc -> ddddd ");
        System.out.println(" ---- мой ответ: --------");
        System.out.println();
        System.out.println(list.printList());
//
//
//
//
//
//
//
//
//
//        System.out.println("после удаления сортировки: ");
//        list.removeIteratively();
//        System.out.println(list.printList());
    }
}
