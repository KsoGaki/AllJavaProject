package main;

public class Frein {
	private boolean isOn = true;
	public void enclencher() {
		if(isOn) {
			isOn = false;	
		}
		else {
			isOn = false;
		}
	}
	public boolean isOn() {
		return isOn;
	}
}
