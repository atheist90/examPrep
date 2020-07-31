package rekursionMRekursionMitListen2;

import java.text.*;

public class RekursionListsMain {
	
	public static void main(String[] args) {
		
		DecimalFormat f = new DecimalFormat("#0.00");
		Kiosk list = new Kiosk();
		
		Item l1 = new Item("Snickers", 0.79);
		Item l2 = new Item("Kinderriegel", 0.49);
		Item l3 = new Item("Donut", 1.19);
		Item l4 = new Item("Pringles", 2.39);
		Item l5 = new Item("Calippo", 1.49);
		
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		
		System.out.println("Eine Liste wird gebildet...");
		System.out.println("Erwartete Liste: |START|---> Snickers (0,79) ---> Kinderriegel (0,49) "
				+ "---> Donut (1,19) ---> Pringles (2,39) ---> Calippo (1,49) ---> null");
		System.out.println("Ihre Liste:      " + list.toString());
		
		System.out.println("\nDiese Liste ist " + list.getSize() + " Elemente lang. (Erwartet: 5)");
		
		System.out.println("Eine Schachtel Pringles kostet " + f.format(list.getPrice("Pringles")) 
				+ " Euro. (Erwartet: 2,39)");
	}

}
