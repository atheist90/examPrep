package rekursionMRekursionMitListen2;

public class Item {

	private String name;
	private double price;
	private Item next;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
		this.next = null;
	}
	
	public Item getNext() {
		return next;
	}
	
	public void setNext(Item next) {
		this.next = next;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
}
