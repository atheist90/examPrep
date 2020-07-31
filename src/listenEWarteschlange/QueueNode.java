package listenEWarteschlange;


public class QueueNode {

    public int	number;
    public QueueNode	next;

    public QueueNode(int number, QueueNode next){
        this.number	= number;
        this.next	= next;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public QueueNode getNext(){
        return next;
    }

    public void setNext(QueueNode next){
        this.next = next;
    }

}
