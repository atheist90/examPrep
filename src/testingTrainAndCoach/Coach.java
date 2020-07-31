package testingTrainAndCoach;

public class Coach {

    private Coach next = null;
    private int passengers = 0;

    public Coach(int passengers) {
        this.passengers = passengers;
    }

    public Coach getNext() {
        return next;
    }

    public void setNext(Coach next) {
        this.next = next;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
