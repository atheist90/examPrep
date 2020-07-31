package genericsAufgabe8_3;

public class Knoten <T>{
    private Knoten vorElem;
    private T object;

    public Knoten getVorElem() {
        return vorElem;
    }

    public void setVorElem(Knoten vorElem) {
        this.vorElem = vorElem;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
