package listenMListeMitStrings;
public class StringList {
	// Das erste Element der Liste
	private StringListElement first;

	/*
	 * BEGINN des zu bearbeitenden Codes
	 */

	// Aufgabe 1
	public void append(String string) {
		StringListElement node = new StringListElement();
		node.setString(string);
		if (first == null) first = node;
		else {
			StringListElement element = first;
			while (element.getNext() != null) {
				element = element.getNext();
			}
			element.setNext(node);
		}
	}

	// Aufgabe 2
	public void insert(String string, int index) {
		if (index < 0 || index > size()) {
			System.out.println("Entweder index ist zu klein/groess oder es existiert kein Linkedlist Element");
			return;
		}
		else {
			// 0. Creating a new node with parameter "string"
			StringListElement newElement = new StringListElement();
			newElement.setString(string);
			// 1. inserting to first position
			if (index == 0) {
				newElement.setNext(first);
				first = newElement;
				return;
			}
			// 2. inserting somewhere in middle of the list.
			else if (index > 0 && index < size()) {
				int counter = 1;
				StringListElement current = first;
				while (counter < index) {
					current = current.getNext();
					counter++;
				}
				newElement.setNext(current.getNext());
				current.setNext(newElement);
			}
			// 3. inserting to the end position
			else {
				newElement.setNext(null);
				StringListElement element = first;
				while (element.getNext() != null) element = element.getNext();
				element.setNext(newElement);
			}
		}


	}

	public int size() {
		if (first == null) return 0;
		else return size(first);
	}
	private int size(StringListElement element) {
		if (element == null) return 0;
		return 1 + size(element.getNext());
	}


	// Aufgabe 3
	public String get(int index) {
		if (index < 0 || index > size()) {
			System.out.println("Entweder index ist zu klein/groess oder es existiert kein Linkedlist Element");
			return null;
		}
		StringListElement element = first;
		int counter = 0;
		while (counter < index) {
			counter++;
			element = element.getNext();
		}
		return element.getString();
	}

	// Aufgabe 4
	public void remove(int index) {
		if (index < 0 || index > size() || first == null) return;
		StringListElement currentToRemove = first, prevToRemove = null;
		// 1. Remove first element
		if (index == 0) {
			first = first.getNext();
			return;
		}
		// 2. Remove last element
		if (index == size()-1) {
			for (int i = 0; i<index-1; i++) {
				currentToRemove = currentToRemove.getNext();
			}
			currentToRemove.setNext(null);
			return;
		}
		// 3. Remove middle element
		if (0 < index && index < size()-1) {
			for (int i = 0; i < index; i++) {
				prevToRemove = currentToRemove;
				currentToRemove = currentToRemove.getNext();
			}
			prevToRemove.setNext(currentToRemove.getNext());
			return;
		}
	}

	/*
	 * Ende des zu bearbeitenden Codes
	 */

	public static void main(String[] args) {
		StringList liste = new StringList();
		System.out.println("Append Strings Hallo Welt");
		System.out.println();
		liste.append("Hallo");
		liste.append("Welt");
		liste.append("!");
		System.out.println("Erwartete Ausgabe: first --> \"Hallo\" <--> \"Welt\" <--> \"!\" --> null");
		System.out.println(liste);
		System.out.println();
		System.out.println("Remove 3 times element number 0");
		System.out.println();
		liste.remove(0);
		liste.remove(0);
		liste.remove(0);
		System.out.println("Erwartete Ausgabe: first --> null");
		System.out.println(liste);
		liste.append("ist");
		liste.append("!");
		liste.insert("Dieser", 0);
		liste.insert("falsch", 2);
		liste.insert("Satz", 1);
		System.out.println(
				"Erwartete Ausgabe: first --> \"Dieser\" <--> \"Satz\" <--> \"ist\" <--> \"falsch\" <--> \"!\" --> null");
		System.out.println(liste);
		liste = new StringList();
		liste.insert("Test1", 0);
		liste.insert("Test2", 1);
		System.out.println("Erwartete Ausgabe: first --> \"Test1\" <--> \"Test2\" --> null");
		System.out.println(liste);
		liste.append("Test3");
		liste.append("Test4");
		liste.append("Test5");
		liste.append("Test6");
		System.out.println(
				"Erwartete Ausgabe: first --> \"Test1\" <--> \"Test2\" <--> \"Test3\" <--> \"Test4\" <--> \"Test5\" <--> \"Test6\" --> null");
		System.out.println(liste);
		liste.remove(0);
		System.out.println();
		System.out.println("REMOVED ELEMENT INDEX 0");
		System.out.println();
		System.out.println(
				"Erwartete Ausgabe: first --> \"Test2\" <--> \"Test3\" <--> \"Test4\" <--> \"Test5\" <--> \"Test6\" --> null");
		System.out.println(liste);
		liste.remove(4);
		System.out.println();
		System.out.println("REMOVED ELEMENT INDEX 4");
		System.out.println();
		System.out.println(
				"Erwartete Ausgabe: first --> \"Test2\" <--> \"Test3\" <--> \"Test4\" <--> \"Test5\" --> null");
		System.out.println(liste);
		liste.remove(1);
		System.out.println();
		System.out.println("REMOVED ELEMENT INDEX 1");
		System.out.println();
		System.out.println("Erwartete Ausgabe: first --> \"Test2\" <--> \"Test4\" <--> \"Test5\" --> null");
		System.out.println(liste);
		System.out.println("Erwartete Ausgabe: Test2");
		System.out.println(liste.get(0));
		System.out.println("Erwartete Ausgabe: Test4");
		System.out.println(liste.get(1));
		System.out.println("Erwartete Ausgabe: Test5");
		System.out.println(liste.get(2));
	}

	public String toString() {
		String liste = "first --> ";
		StringListElement element = first;
		while (element != null) {
			liste = liste + "\"";
			liste = liste + element.getString();
			liste = liste + "\"";
			if (element.getNext() != null) {
				liste = liste + " <--> ";
			} else {
				liste = liste + " --> ";
			}
			element = element.getNext();
		}

		liste = liste + "null";

		return liste;
	}
}