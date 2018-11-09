package main;

public class Vehicule {
	private Moteur moteur = new Moteur();
	public void start() {
		moteur.allumer();
		if(moteur.isOn()) {
			System.out.println("Le moteur démare");
		}
		else {
			System.out.println("Le moteur démare pas");
		}
	}
}
