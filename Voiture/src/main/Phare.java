package main;

public class Phare {
	
	private boolean isOn = false;
	public void allumage() {
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
