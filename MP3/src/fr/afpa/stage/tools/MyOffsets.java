package fr.afpa.stage.tools;

public enum MyOffsets {
	_TAGOFFSET(128),
	_TITLEOFFSET(125),
	_ARTISTOFFSET(95),
	_ALBUMOFFSET(65),
	_YEAROFFSET(35),
	_COMMENTOFFSET(31),
	_GENREOFFSET(1);
	
	private int value;

	public int getValue() {
		return value;
	}

	private MyOffsets(int value) {
		this.value = value;
	}
}
