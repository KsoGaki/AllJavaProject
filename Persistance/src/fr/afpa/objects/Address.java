package fr.afpa.objects;

import java.io.IOException;
import java.util.Scanner;

import fr.afpa.interfaces.IDisplay;

public class Address implements IDisplay{
	
	private static Scanner scanner = new Scanner(System.in);

	private String address;
	private int postalCode;
	private String country;

	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public IDisplay getSplitData(String data) throws IOException {
		String[] dataTab = data.split(",");
		Address address = new Address(
				dataTab[4].split(":")[1],
				Integer.parseInt(dataTab[5].split(":")[1]),
				dataTab[6].split(":")[1]
				);
		return address;
	}	
	
	@Override
	public String updateFromId(int id, String line) throws IOException {
		System.out.print("New value (Address): ");
		String address = scanner.next();
		System.out.print("New value (PostalCode): ");
		String postalCode = scanner.next();
		System.out.print("New value (Country): ");
		String country = scanner.next();
		String stringTab[] = line.split(",");
		stringTab[4] = stringTab[4].split(":")[1] = address;
		stringTab[5] = stringTab[5].split(":")[1] = postalCode;
		stringTab[6] = stringTab[6].split(":")[1] = country;
		line = String.join(",", stringTab);
		return line;
	}

	@Override
	public String toString() {
		return "Adress: " + address + 
				"\nPostal Code: " + postalCode + 
				"\nCountry: " + country;
	}

	public String toStringLinear() {
		return "Adress:" + address + ",Postal Code:" + postalCode + ",Country:" + country;
	}	

	public Address(String address, int postalCode, String country) {
		super();
		this.address = address;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Address() {}
}
