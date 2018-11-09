package main;

public class Plug {
	private boolean isPlugOn = true;
	public boolean unPlug() {
		System.out.println("Le capuchon est retiré");
		return isPlugOn = false;
	}
	public boolean setPlug() {
		System.out.println("Le capuchon est remis");
		return isPlugOn = true;
	}
	public boolean isPlugOn() {
		return isPlugOn;
	}
	public void setPlugOn(boolean isPlugOn) {
		this.isPlugOn = isPlugOn;
	}
}
