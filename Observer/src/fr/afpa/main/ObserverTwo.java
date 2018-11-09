package fr.afpa.main;

import fr.afpa.interfaces.IObserver;

public class ObserverTwo implements IObserver {
	
	Sujet sujet;
	
	@Override
	public void displayWeather(int temperatureWeather, int humidityWeather) {
		System.out.println("Temperature= " + temperatureWeather + " Humidité= " + humidityWeather);
	}

	public ObserverTwo(Sujet sujet) {
		super();
		this.sujet = sujet;
		sujet.addObserver(this);
	}
}
