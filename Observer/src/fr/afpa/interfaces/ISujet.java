package fr.afpa.interfaces;

public interface ISujet {
	
	public void addObserver(IObserver iObserver);
	
	public void removeObserver(IObserver iObserver);
	
	public void notifyObservers();
	
	
}
