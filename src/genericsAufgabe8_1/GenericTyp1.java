package genericsAufgabe8_1;
// Generische Datentyp als Behaelter fuer die Instanzen vom Typ des Klassenparameters
public class GenericTyp1 <T> {
    public T object;

    public GenericTyp1() {
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getObjectTyp(){
        return object.getClass().getName();
    }
    public static void main(String[] args) {
        GenericTyp1 <Integer> typInteger = new GenericTyp1();
        typInteger.setObject(12);
        System.out.println(typInteger.getObjectTyp());

    }
}
