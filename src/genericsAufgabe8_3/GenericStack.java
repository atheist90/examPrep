package genericsAufgabe8_3;

public class GenericStack <T> {
    private T object;
    private Knoten aktuellElem;

    public GenericStack(){
        this.aktuellElem = new Knoten();
    }
    public void push(T object){
        Knoten knoten = new Knoten();
        knoten.setVorElem(aktuellElem);
        knoten.setObject(object);
        aktuellElem = knoten;
    }

    public T pop(){
        T object = (T) aktuellElem.getObject();
        aktuellElem = aktuellElem.getVorElem();
        return object;
    }

}
