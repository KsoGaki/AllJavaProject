package fr.afpa.stage.tools;

public enum MyLengths {
	_TAGLENGTH(3),
	_TITLELENGTH(30),
	_ARTISTLENGTH(30),
	_ALBUMLENGTH(30),
	_YEARLENGTH(4),
	_COMMENTLENGTH(30),
	_GENRELENGTH(1);
	
	private int value; 
	
	MyLengths(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
