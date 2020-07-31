package testingAufgabe_3_1;

public class Knoten {
    int Zahl;
    Knoten links, rechts;

    public Knoten(int zahl) {
        Zahl = zahl;
    }

    public int getZahl() {
        return Zahl;
    }

    public void setZahl(int zahl) {
        Zahl = zahl;
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
