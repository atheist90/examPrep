package testingTrainAndCoach;

public class Train {

    private Coach firstCoach = null;
    private Coach lastCoach = null;

    public void append(Coach c) {
        if (c == null) return;
        if (firstCoach == null) firstCoach = lastCoach = c;
        else {
            Coach coach = firstCoach;
            while (coach.getNext() != null) {
                coach = coach.getNext();
            }
            coach.setNext(c);
            lastCoach = c;
        }
    }

    public void remove() {
        if (firstCoach == null) return;
        if (firstCoach.getNext() == null) {
            lastCoach = firstCoach = null;
        }
        else {
            lastCoach = firstCoach;
            while (lastCoach.getNext().getNext() != null) {
                lastCoach = lastCoach.getNext();
            }
            lastCoach.setNext(null);
        }
    }

    public int countPassengers() {
        return (firstCoach == null ? 0 : countPassengers(firstCoach));
    }
    private int countPassengers(Coach coach) {
        return (coach == null ? 0 : coach.getPassengers() + countPassengers(coach.getNext()));
    }

    public Train split(int n) {
        if(n < 1 || n > size() || firstCoach == null) return null;
        Coach coach = firstCoach;
        for (int i = 1; i <= n; i++) {
            coach = coach.getNext();
        }
        Coach temp = coach.getNext();
        coach.setNext(null);
        Train train = new Train();
        train.firstCoach = temp;
        return train;
    }

    public boolean checkAvailability(int [] passengers) {
        if (firstCoach == null || passengers == null || size() < passengers.length+1) return false;
        Coach coach = firstCoach;
        for (int i = 0; i < passengers.length ; i++) {
            if(coach.getPassengers() + passengers[i] > 50 || passengers [i] < 0) return false;
            coach = coach.getNext();
        }
        return true;
    }

    public int size() {
        return (firstCoach == null ? 0 : size(firstCoach));
    }
    private int size(Coach coach) {
        return (coach == null ? 0 : 1 + size(coach.getNext()));
    }



    public static void main(String[] args) {
        Train train = new Train();
        train.firstCoach = new Coach(1);

        Coach c1 = new Coach(10);
        Coach c2 = new Coach(8);
        Coach c3 = new Coach(12);
        Coach c4 = new Coach(6);
        Coach c5 = new Coach(8);
        Coach c6 = new Coach(10);

        train.append(c1);
        train.append(c2);
        train.append(c3);
        train.append(c4);
        train.append(c5);
        train.append(c6);
        System.out.println("Erwartete Ausgabe: 55");
        System.out.println("Deine ausgabe: " + train.countPassengers());
        // Splitten wir den Zug
        train.split(2);
        System.out.println("Erwartete Ausgabe: 19");
        System.out.println("Deine ausgabe: " + train.countPassengers());
    }
}
