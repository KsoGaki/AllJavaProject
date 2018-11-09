package fr.afpa.main;

public class Main {

	public static void main(String[] args) {
		Sujet sujet = new Sujet();
		ObserverOne observerOne = new ObserverOne(sujet);
		ObserverTwo observerTwo = new ObserverTwo(sujet);
		sujet.notifyObservers();
		sujet.updateWeather(10,20);
	}

}
