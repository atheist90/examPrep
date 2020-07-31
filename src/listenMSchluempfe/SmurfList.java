package listenMSchluempfe;

public class SmurfList {

	public static final int SMURF_MAXIMAL_SIZE = 20;
	public static final int SMURF_MINIMAL_SIZE = 8;

	public SmurfNode head;

	public SmurfList(){
		head = null;
	}

	public SmurfNode getHead(){
		return head;
	}

	/*
	 * BEGINN des zu bearbeitenden Codes
	 */

	// Aufgabe1
	public void addSmurf(Smurf smurf){
		if (smurf.getSize() < SMURF_MINIMAL_SIZE || smurf.getSize() > SMURF_MAXIMAL_SIZE)
			return;
		// 1. if there is no list exists.
		if (head == null) {
			head = new SmurfNode(smurf, null);
			return;
		}
		SmurfNode prev= null, current = head;
		// 2. If smurf size is smaller than head, than add it bevor head.
		if (smurf.getSize() < head.smurf.getSize()) {
			SmurfNode newSmurf = new SmurfNode(smurf, head);
			head = newSmurf;
			return;
		}
		// 3. If smurf
		if(containsSmurf(smurf)) return;
		while (current != null && current.smurf.getSize() < smurf.getSize()) {
			prev = current;
			current = current.getNext();
		}
		//System.out.println(prev.getSmurf().name);
		prev.setNext(new SmurfNode(smurf, current));
	}

	// Aufgabe 2
	public boolean containsSmurf(Smurf smurf){
		if (head == null || smurf == null) return false;
		SmurfNode node = head;
		while (node != null) {
			if (node.getSmurf().getName().equals(smurf.getName()) && node.getSmurf().getSize() == smurf.getSize())
				return  true;
			else node = node.getNext();
		}
		return false;
	}

	// Aufgabe 3
	public int smurfPosition(Smurf smurf){
		if (head == null || smurf == null || !containsSmurf(smurf)) return -1;
		SmurfNode node = head;
		int i = 1;
		while (node != null) {
			if(node.getSmurf().getSize() == smurf.getSize() && node.getSmurf().getName().equals(smurf.getName()))
				return i;
			node = node.getNext();
			i++;
		}
		return -1;
	}

	// Aufgabe 4
	public int smurfPosition(String name){
		if (head == null) return -1;
		SmurfNode node = head;
		int i = 1;
		while (node != null) {
			if (name.compareTo(node.getSmurf().getName()) == 0) {
				return i;
			}
			node = node.getNext();
			i++;
		}

		return -1;
	}

	// Aufgabe 5
	public void downsizeSmurfs(int cm){
		if (head == null) return;
		SmurfNode current = head;
		SmurfList list = new SmurfList();
		while (current != null) {
			list.addSmurf(new Smurf(current.getSmurf().getName(), current.getSmurf().getSize() - cm));
			current = current.getNext();
		}
		head = list.head;
	}

	// Aufgabe 6
	public void stretchSmurfs(int cm){
		if (head == null) return;
		SmurfNode current = head;
		SmurfList list = new SmurfList();
		while (current != null) {
			list.addSmurf(new Smurf(current.getSmurf().getName(), current.getSmurf().getSize() + cm));
			current = current.getNext();
		}
		head = list.head;
	}

	/*
	 * ENDE des zu bearbeitenden Codes
	 */


	// Mit dieser Methode koennen Sie die Namen aller Schluempfe in einer
	// Schlumpfliste ausgeben lassen. Sie soll eine Hilfestellung sein um ihre
	// Tests in der "public static void main" zu erleichtern.
	// Den Inhalt einer Schlumpfliste "liste" koennen Sie mit dem Befehl
	//
	//                printSchlumpfListe(liste);
	//
	// auf der Konsole ausgeben lassen.
	public static void printSmurfList(SmurfList slist){
		SmurfNode iterator = slist.getHead();
		while (iterator != null){
			if (iterator.smurf != null){
				System.out.print(iterator.getSmurf().getName() + ", ");
			} else {
				System.out.print("NULL, ");
			}
			iterator = iterator.getNext();
		}
		System.out.println();
	}

	/*
	 * Hier kommt ihr Testcode hin
	 */
	public static void main(String[] args) {
		// Smurfen erstellen
		Smurf murad = new Smurf("murad", 10);
		Smurf emmy = new Smurf("emmy", 8);
		Smurf ravil = new Smurf("ravil", 12);
		Smurf robert = new Smurf("roberto", 17);
		Smurf sukablat = new Smurf("sukablyat", 18);
		Smurf xxxl = new Smurf("echtgros", 25);
		Smurf xs = new Smurf("kleiner", 4);

		// SmurfNode machen
		SmurfList oneList = new SmurfList();
		oneList.addSmurf(murad);
		System.out.println("---- добавили первого смурфика (murad)----");
		printSmurfList(oneList);
		System.out.println();


		oneList.addSmurf(murad);
		System.out.println("---- добавили второго смурфика (murad)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(emmy);
		System.out.println("---- добавили третьего смурфика (emmy)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(murad);
		System.out.println("---- добавили четвертого смурфика (murad)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(robert);
		System.out.println("---- добавили пятого смурфика (robert)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(ravil);
		System.out.println("---- добавили шестого смурфика (ravil)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(sukablat);
		System.out.println("---- добавили седьмого смурфика (sukablat)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(xxxl);
		System.out.println("---- добавили восьмого смурфика (xxxl)----");
		printSmurfList(oneList);
		System.out.println();

		oneList.addSmurf(xs);
		System.out.println("---- добавили девятого смурфика (xs)----");
		printSmurfList(oneList);
		System.out.println();

		System.out.println("---- есть ли в списке смурфик по имени murad?");
		System.out.println(" Верный ответ должен быть: TRUE");
		System.out.println(" Ваш ответ: " + oneList.containsSmurf(murad));
		System.out.println();

		System.out.println("---- какая позиция у смурфика murad?");
		System.out.println(" Верный ответ должен быть: 2");
		System.out.println(" Ваш ответ: " + oneList.smurfPosition(murad));
		System.out.println();

		System.out.println("---- какая позиция у смурфика emmy?");
		System.out.println(" Верный ответ должен быть: 1");
		System.out.println(" Ваш ответ: " + oneList.smurfPosition("emmy"));
		System.out.println();
		printSmurfList(oneList);

		System.out.println();
		System.out.println("---- попробуем уменьшить размер смурфиков на 1 ----");
		oneList.stretchSmurfs(3);
		printSmurfList(oneList);
		System.out.println();
	}
}