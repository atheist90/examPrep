package rekursionMRekursionInListen1;

public class WordNode {
	
	private WordNode	next;
	private String		word;
	
	
	public WordNode(String word) {
		this.word = word;
	}

	public WordNode getNext() {
		return next;
	}
	
	public void setNext(WordNode next) {
		this.next = next;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
}
