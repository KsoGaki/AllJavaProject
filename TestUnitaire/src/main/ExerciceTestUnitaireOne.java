package main;

public class ExerciceTestUnitaireOne {

	private String myString;

	public void purge() {
		myString = "";
	}

	public void append(String string) {
		myString = myString.concat(string);
	}

	public void decrement() {
		myString = myString.substring(0, myString.length()-1); 
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public ExerciceTestUnitaireOne() {
		super();
	}

}
