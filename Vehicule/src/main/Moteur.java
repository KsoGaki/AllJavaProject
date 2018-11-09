package main;

public class Moteur {
	private boolean isOn = false;
	
	public void allumer() {
		if(isOn) {
			isOn = false;
		}
		else {
			isOn = true;
		}
	}

	public boolean isOn() {
		return isOn;
	}
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}
