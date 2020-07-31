package genericsAufgabe8_2;
// Generischer Datentyp als "Ueber-Typ" fuer die Instanzen vom Typ des Klassenparameters
public class GenericTyp2 <T> {

    public T t;

    public GenericTyp2(T t) {
        this.t = t;
    }

    public T getT(){return t;}

    public String getTTyp() {
        return t.getClass().getName();
    }

}
