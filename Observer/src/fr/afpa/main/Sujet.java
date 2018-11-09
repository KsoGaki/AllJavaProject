package fr.afpa.main;

import java.util.ArrayList;
import java.util.List;

import fr.afpa.interfaces.IObserver;
import fr.afpa.interfaces.ISujet;

public class Sujet implements ISujet {

	private int temperatureWeather = 12;

	private int humidityWeather = 25;

	private List<IObserver> listObserver = new ArrayList<>();

	public void updateWeather(int temperatureWeather,int humidityWeather) {
		this.temperatureWeather = temperatureWeather;
		this.humidityWeather = humidityWeather;
		notifyObservers();
	}

	@Override
	public void addObserver(IObserver iObservateur) {
		listObserver.add(iObservateur);

	}

	@Override
	public void removeObserver(IObserver iObservateur) {
		listObserver.remove(iObservateur);

	}

	@Override
	public void notifyObservers() {
		for (IObserver iObserver : listObserver) {
			iObserver.displayWeather(temperatureWeather, humidityWeather);
		}

	}

}
