package rekursionMRekursionMitListen2;

import java.text.*;

public class Kiosk {

	private static final String LIST = "|START|";
	public Item head;
	

//	-------------------- Aufgabe 1 --------------------

	public int getSize() {
		if (head == null) return 0;
		return getSizeRekurs(head);
	}
	
	private int getSizeRekurs(Item item) {
		// Hier beginnt der zu bearbeitende Bereich
		if (item == null) return 0;
		else return 1 + getSizeRekurs(item.getNext());
		// Hier endet der zu bearbeitende Bereich
	}
	
	
//	-------------------- Aufgabe 2 --------------------
	
	public void add(Item newItem) {
		// Hier beginnt der zu bearbeitende Bereich (optional)
		if (head == null) {
			head = newItem;
			return;
		}
		// Hier endet der zu bearbeitende Bereich (optional)
		addRekurs(head, newItem);
	}
	
	private void addRekurs(Item item, Item newItem) {
		// Hier beginnt der zu bearbeitende Bereich
		if (item.getNext() == null) {
			item.setNext(newItem);
			return;
		}
		else addRekurs(item.getNext(), newItem);
		// Hier endet der zu bearbeitende Bereich
	}
	
	
//	-------------------- Aufgabe 3 --------------------
	
	public double getPrice(String name) {
		if (head == null || name == null) return 0;
		return getPriceRekurs(head, name);
	}
	
	private double getPriceRekurs(Item item, String name) {
		// Hier beginnt der zu bearbeitende Bereich
		if (item == null) return 0;
		else if (item.getName().equals(name)) return item.getPrice();
		else return getPriceRekurs(item.getNext(), name);
		// Hier endet der zu bearbeitende Bereich
	}
//	-------------------- Printmethode --------------------
	
	@Override
	public String toString() {

		StringBuilder str = new StringBuilder(LIST);
		DecimalFormat f = new DecimalFormat("#0.00");

		Item pointer = head;
		while (pointer != null) {
			str.append("---> ");
			str.append(pointer.getName());
			str.append(" (" + f.format(pointer.getPrice()) + ") ");
			pointer = pointer.getNext();
		}

		str.append("---> null");

		return str.toString();
	}
	
}
