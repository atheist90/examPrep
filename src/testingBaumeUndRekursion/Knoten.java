package testingBaumeUndRekursion;

public class Knoten {
    public int zahl;
    Knoten links, rechts;

    public Knoten(int zahl) {
        this.zahl = zahl;
        this.links = links;
        this.rechts = rechts;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    public Knoten getLinks() {
        return links;
    }

    public void setLinks(Knoten links) {
        this.links = links;
    }

    public Knoten getRechts() {
        return rechts;
    }

    public void setRechts(Knoten rechts) {
        this.rechts = rechts;
    }
}
