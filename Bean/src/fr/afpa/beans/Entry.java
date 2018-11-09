package fr.afpa.beans;

import fr.afpa.annotation.MainEntry;
import fr.afpa.annotation.Wired;

// URL rootUrl = this.getClass().getClassLoader().getResource("");

public class Entry {
	
	@Wired(value = Person.class)
	private static Person person;
	
	@Wired(value = Address.class)
	private static Address address;
	
	@Wired(value = Country.class)
	private static Country country;

	public static void main(String[] args) {
		System.out.println(person.string);
	}

	@MainEntry()
	public static void mainEntry() {

	}

}
