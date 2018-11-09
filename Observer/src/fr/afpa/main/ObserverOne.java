package fr.afpa.main;

import fr.afpa.interfaces.IObserver;

public class ObserverOne implements IObserver {
	
	private Sujet sujet;
	
	@Override
	public void displayWeather(int temperatureWeather, int humidityWeather) {
		System.out.println("Temperature: " + temperatureWeather + " Humidité: " + humidityWeather);
	}

	public ObserverOne(Sujet sujet) {
		super();
		sujet.addObserver(this);
		this.sujet = sujet;
	}
}
