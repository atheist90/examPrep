package genericsAufgabe8_4;

public class GenericTypmitWildcard <T> {
    private T object;
    public GenericTypmitWildcard(){

    }

    public void anzeige(GenericTypmitWildcard<?> t){
        System.out.println("Object type: " + t.getObjectTyp());
        System.out.println("Object: " + t.getObject());
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
        GenericTypmitWildcard <Integer> a = new GenericTypmitWildcard<>();
        a.setObject(12);
        a.anzeige(a);
    }
}
