package listenMListeMitStrings;
public class StringListElement
{
	//Der Inhalt in diesem Element
	private String string;
	//Das naechste Element
	private StringListElement next;
	//Das vorherige Element
	private StringListElement prev;
	
	//Getter und Setter Methoden
	public String getString()
	{
		return string;
	}
	
	public void setString(String string)
	{
		this.string = string;
	}
	
	public StringListElement getNext()
	{
		return next;
	}
	
	public void setNext(StringListElement next)
	{
		this.next = next;
	}
	
	public StringListElement getPrev()
	{
		return prev;
	}
	
	public void setPrev(StringListElement prev)
	{
		this.prev = prev;
	}
	
	public String toString()
	{
		return string;
	}
}