package fr.afpa.main;

public class Main {

	public static void main(String[] args) {
		MachinOne machinOne = new MachinOne();
		MachinTwo machinTwo = new MachinTwo();
		machinOne.display();
		machinTwo.display();
		machinOne.setValue(10);
		machinTwo.setValue(20);
		System.out.println(machinOne.getValue());
		System.out.println(machinTwo.getValue());
	}

}
