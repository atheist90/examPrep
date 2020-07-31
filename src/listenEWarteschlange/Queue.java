package listenEWarteschlange;

public class Queue {
    QueueNode first;
    QueueNode last;

    public void Warteschlange(){
        first	= null;
        last	= null;
    }
    /*
     * BEGINN des zu bearbeitenden Codes
     */
    // Aufgabe 1
    public void push(int number){
        if (last == null) {
            last = new QueueNode(number, null);
            return;
        }
        QueueNode node = last;
        while (node.getNext() != null) node = node.getNext();
        node.setNext(new QueueNode(number, null));
    }
    // Aufgabe 2
    public int pop(){
        if (last == null) return Integer.MIN_VALUE;
        QueueNode tmp = last;
        last = last.getNext();
        return tmp.getNumber();
    }
    // Aufgabe 3
    public int length(){
        if (last == null) return 0;
        return length(last);
    }
    private int length(QueueNode node) {
        if (node == null) return 0;
        return 1 + length(node.getNext());
    }
    // Aufgabe 4
    public int sum(){
        if (last == null) return Integer.MIN_VALUE;
        int sum = 0;
        QueueNode node = last;
        while (node != null) {
            sum += node.getNumber();
            node = node.getNext();
        }
        return sum;
    }
    /*
     * ENDE des zu bearbeitenden Codes
     */
    /*
     * Testen Sie hier Ihre Implementierung.
     */
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(4);		// Inhalt der Warteschlange: (4)
        queue.push(17);		// Inhalt der Warteschlange: (4, 17)
        queue.pop();		// ...                       (17)
        queue.push(33);		// 							 (17, 33)
        queue.push(-13);	//							 (17, 33, -13)
        queue.pop();		//							 (33, -13)
        System.out.println("Erwartete Länge der Warteschlange: 2");
        System.out.println("Tatsächliche Länge:               " + queue.length());
        System.out.println();
        System.out.println("Erwartete Summe über der Warteschlange: 20");
        System.out.println("Tatsächliche Summe:                     " + queue.sum());
    }
}
