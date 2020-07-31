package listenMSchluempfe;

public class SmurfNode {

	public Smurf smurf;
	public SmurfNode next;

	public SmurfNode(Smurf schlumpf, SmurfNode next){
		this.smurf	= schlumpf;
		this.next	= next;
	}
	
	public Smurf getSmurf(){
		return smurf;
	}
	
	public void setSmurf(Smurf smurf){
		this.smurf = smurf;
	}
	
	public SmurfNode getNext(){
		return next;
	}
	
	public void setNext(SmurfNode next){
		this.next = next;
	}
	
}
