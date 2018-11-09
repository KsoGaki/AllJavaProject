package fr.afpa.beans;

import fr.afpa.annotation.Bean;
import fr.afpa.annotation.Wired;

@Bean
public class Person {
	
	public String string = "";
	
	@Wired(value = Address.class)
	private Address address;
	
	public Person() {}
}
