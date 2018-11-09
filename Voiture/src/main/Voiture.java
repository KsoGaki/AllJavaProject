package main;

public class Voiture {
	private String color;
	private String avance = "Arret ";
	private Motor motor = new Motor();
	private Frein frein = new Frein();
	private Phare phare = new Phare();
	public void demarre() {
		motor.start();
	}

	public void frein() {
		frein.enclencher();
	}

	public void phare() {
		phare.allumage();
	}
	
	public void avance() {
		if(!frein.isOn() && motor.isStarted()) {
			avance = "Avance";
		}
		else {
			avance = "Arret ";
		}
	}

	public String getColor() {
		return color;
	}
	public String getMotorOn() {
		if (motor.isStarted()) {
			return "On ";
		}
		return "Off";
	}
	public String getFreinOn() {
		if (frein.isOn()) {
			return "On ";
		}
		return "Off";
	}
	
	public String getPhareOn() {
		if (phare.isOn()) {
			return "On ";
		}
		return "Off";
	}
	
	
	public String getAvance() {
		return avance;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
