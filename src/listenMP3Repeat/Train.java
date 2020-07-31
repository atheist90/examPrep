package listenMP3Repeat;

public class Train {

    // Kann fuer die Ausgabe verwendet werden
    private static final String LOCOMOTIVE = "<___|o|";

    private Waggon head;

    public int getSize() {
        if (head == null) return 0;
        else {
            int i = 0;
            Waggon waggon = head;
            while (waggon != null) {
                i++;
                waggon = waggon.getNext();
            }
            return i;
        }

    }


    public int getPassengerCount() {
        return (head == null) ? 0 : getPassengerCount(head);
    }
    private int getPassengerCount(Waggon waggon) {
        return (waggon == null) ? 0 : waggon.getPassengers() + getPassengerCount(waggon.getNext());
    }

    public int getCapacity() {
        return (head == null) ? 0 : getCapacity(head);
    }
    private int getCapacity(Waggon waggon) {
        return (waggon == null) ? 0 : waggon.getCapacity() + getCapacity(waggon.getNext());
    }

    public void appendWaggon(Waggon waggon) {
        if (head == null) head = waggon;
        else {
            Waggon w = head;
            while (w.getNext() != null) {
                w = w.getNext();
            }
            w.setNext(waggon);
        }
    }

    public void boardPassengers(int numberOfPassengers) {
        int freeplaces = 0;
        if (head == null) return;
        Waggon waggon = head;
        while (waggon != null) {
            freeplaces = waggon.getCapacity() - waggon.getPassengers();
            if (numberOfPassengers - freeplaces < 0) {
                waggon.setPassengers(numberOfPassengers);
                return;
            }
            else {
                waggon.setPassengers(waggon.getCapacity());
                numberOfPassengers = numberOfPassengers - freeplaces;
                waggon = waggon.getNext();
            }

        }
    }

    public Train uncoupleWaggons(int index) {
        if (index < 0 || index > getSize() || head == null) return null;
        Train train = new Train();
        Waggon waggon = head;
        int i = 0;
        while (waggon != null && i < index) {
            waggon = waggon.getNext();
            i++;
        }
        train.head = waggon;
        return train;
    }

    public void insertWaggon(Waggon waggon, int index) {
        // если поезда нет.
        if (head == null) {
            head = waggon;
            return;
        }
        // если добавляем вначало поезда
        if (index == 0) {
            waggon.setNext(head);
            head = waggon;
        }
        // если добавляем в самый конец, когда индекс больше длины поезда
        if (index >= getSize()) {
            Waggon w = head;
            while (w.getNext() != null) {
                w = w.getNext();
            }
            w.setNext(waggon);
            return;
        }
        Waggon w = head;
        int i = 0;
        while (w.getNext() != null && i < index){
            w = w.getNext();
            i++;
        }
        waggon.setNext(w.getNext());
        w.setNext(waggon);

    }

    public void turnOver() {
    }

    public void removeWaggon(Waggon waggon) {
        if (head == null) return;
        // удаление первого элемента.
        if (waggon == head && head.getNext() != null) {
            head = head.getNext();
            return;
        }
        if (waggon == head && head.getNext() == null) {
            head = null;
            return;
        }
        // удаляю остальные
        Waggon w = head;
        while (w.getNext() != null && waggon != w.getNext()) {
            w = w.getNext();
        }
        if (w.getNext() == waggon) {
            w.setNext(null);
            return;
        }

    }

    public Waggon getWaggonAt(int index) {
        if (head == null || index >= getSize() || index < 0) return null;
        Waggon w = head;
        int i = 0;
        while (w != null && i < index) {
            w = w.getNext();
            i++;
        }
        return w;
    }

    @Override
    public String toString() {
        if (getSize() == 0) {
            return LOCOMOTIVE;
        }

        StringBuilder str = new StringBuilder(LOCOMOTIVE);

        Waggon pointer = head;
        while (pointer != null) {
            str.append(" <---> ");
            str.append(pointer.getName());
            pointer = pointer.getNext();
        }

        return str.toString();
    }

    public Waggon getHead() {
        return head;
    }

}

