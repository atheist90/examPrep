package listenSAufgabeFuerFortgeschrittene;

public class ListsHard {

    // Fuehre diese main-Methode aus, um die Methoden deiner List Klasse zu ueberpruefen.
    public static void main (String[] args) {
        List list = new List();

        System.out.println("---------- Erstellen der Liste ----------");
        System.out.println(String.format("Neue Liste mit %d Elementen:", list.getSize()));
        System.out.println(list.toString());
        System.out.println("");

        Element element1 = new Element(27 ,"Stefan");
        Element element2 = new Element(21 , "Anna");
        Element element3 = new Element(18 , "Paul");
        Element element4 = new Element(31 , "Max");
        Element element5 = new Element(20 , "Lisa");
        Element element6 = new Element(25 , "Maxim");
        Element element7 = new Element(23 , "Marie");
        Element element8 = new Element(29 , "Isabelle");
        Element element9 = new Element(32 , "Valentin");
        Element element10 = new Element(23 , "Sabine");

        list.addElement(element1);
        list.addElement(element2);
        list.addElement(element3);
        list.addElement(element4);
        list.addElement(element5);
        list.addElement(element6);
        list.addElement(element7);
        list.addElement(element8);
        list.addElement(element9);
        list.addElement(element10);
        System.out.println("List is: ");
        System.out.println(list.toString());
        System.out.println();

        Element new1 = new Element(1,"Berlin");
        Element new2 = new Element(2,"Rheinberg");
        Element new3 = new Element(3,"Essen");
        Element new4 = new Element(4,"Weimar");
        Element new5 = new Element(5,"Bonn");

        List newList = new List();

        newList.addElement(new1);
        newList.addElement(new2);
        newList.addElement(new3);
        newList.addElement(new4);
        newList.addElement(new5);
        System.out.println("newList is: ");
        System.out.println(newList.toString());
        System.out.println();

        System.out.println("---------- Einfuegen der Elemente in die Liste ----------");
        System.out.println(String.format("Die Liste hat nun %d Elemente:", list.getSize()));
        System.out.println(list.toString());
        System.out.println("");

        list.addList(newList);
        System.out.println("========== added list ===========");
        System.out.println("After adding newList to List: ");
        System.out.println(list.toString());
        System.out.println();
        System.out.println("==================================");
        System.out.println();
        System.out.println("========= testing geting position by number =======");
        System.out.println("Under position 4 is Max(31). Your result is: " + list.getElement(4).toString());
        System.out.println();
        System.out.println("==================================");
        System.out.println();
        System.out.println("====== we move Anna(21) to Max(31), and Max(31) to Anna(21)");
        System.out.println("list BEFORE moving looking like: ");
        System.out.println(list.toString());
        System.out.println();
        list.moveElement(2,4);
        System.out.println("list AFTER moving looking like: ");
        System.out.println(list.toString());
        System.out.println();
        System.out.println("====================================");
        System.out.println();
        System.out.println("======== here we will test filter function ============");
        System.out.println("list BEFORE we FILTER looks like: ");
        System.out.println(list.toString());
        System.out.println();
        list.filterElements(21);
        System.out.println("list AFTER we filter looks like: (here we delete all values = 21");
        System.out.println(list.toString());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("---------- Anhaengen einer neuen Liste ----------");
        System.out.println(String.format("Die Liste hat nun %d Elemente:", list.getSize()));
        System.out.println(list.toString());
        System.out.println("");

        list.moveElement(14, 15);

        System.out.println("---------- Verschieben eines Elementes ----------");
        System.out.println(String.format("Die Liste hat nun %d Elemente:", list.getSize()));
        System.out.println(list.toString());
        System.out.println("");

        list.filterElements(25);

        System.out.println("---------- Rausfiltern der Elemente ----------");
        System.out.println(String.format("Die Liste hat nun %d Elemente:", list.getSize()));
        System.out.println(list.toString());
        System.out.println("");
    }
}