package fr.afpa.main;

import fr.afpa.interfaces.IBidule;

public class MachinTwo implements IBidule {

	@Override
	public void display() {
		System.out.print("MachinTwo: ");
		Singleton.getInstance().display();
	}

	@Override
	public int getValue() {
		return Singleton.getInstance().getValue();
	}

	@Override
	public void setValue(int i) {
		Singleton.getInstance().setValue(i);
	}

}
