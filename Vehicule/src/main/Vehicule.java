package main;

public class Vehicule {
	private Moteur moteur = new Moteur();
	public void start() {
		moteur.allumer();
		if(moteur.isOn()) {
			System.out.println("Le moteur d�mare");
		}
		else {
			System.out.println("Le moteur d�mare pas");
		}
	}
}
