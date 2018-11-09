package fr.afpa.beans;

import fr.afpa.annotation.Bean;
import fr.afpa.annotation.Wired;

@Bean
public class Address {

	@Wired(value = Country.class)
	Country country;
	
	public Address() {
		
	}
}
