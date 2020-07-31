package rekursionEEuklidischerAlgorithmus;

public class GroessterGemeinsamerTeiler
{
	/*
	 * Das hier ist die main Methode.
	 * Wie immer kannst du hier deine eigene Methode testen.
	 * Natuerlich darfst du auch eigene Testfaelle schreiben.
	 */
	public static void main(String[] args)
	{
		System.out.println("Der groesste gemeinsame Teiler von 12 und 8 ist: " + gcd(12,8));
		System.out.println("Der groesste gemeinsame Teiler von 10 und 5 ist: " + gcd(10,5));
		System.out.println("Der groesste gemeinsame Teiler von 10 und 15 ist: " + gcd(10,15));
		System.out.println("Der groesste gemeinsame Teiler von 7 und 41 ist: " + gcd(7,41));
	}
	
	// Aufgabe 1
	public static int gcd(int a, int b) {
		if (a%b == 0) return b;
		else return gcd(b, a%b);
	}
}
