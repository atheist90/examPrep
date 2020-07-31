package testingRekursion;

public class Node {
    private int number;
    private Node nextLeft, nextRight;

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getNextLeft() {
        return nextLeft;
    }

    public void setNextLeft(Node nextLeft) {
        this.nextLeft = nextLeft;
    }

    public Node getNextRight() {
        return nextRight;
    }

    public void setNextRight(Node nextRight) {
        this.nextRight = nextRight;
    }
}
