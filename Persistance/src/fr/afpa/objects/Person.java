package fr.afpa.objects;

import java.io.IOException;
import java.util.Scanner;

import fr.afpa.interfaces.IDisplay;

public class Person implements IDisplay{

	private Scanner scanner = new Scanner(System.in);

	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private int id;
	private int idStatic = 0;

	@Override
	public IDisplay getSplitData(String data) throws IOException {
		String[] dataTab = data.split(",");
		Person person = new Person(
				Integer.parseInt(dataTab[0].split(":")[1]),
				dataTab[1].split(":")[1],
				dataTab[2].split(":")[1],
				Integer.parseInt(dataTab[3].split(":")[1]),
				this.address = new Address(
						dataTab[4].split(":")[1],
						Integer.parseInt(dataTab[5].split(":")[1]),
						dataTab[6].split(":")[1]
						)
				);
		return person;
	}

	@Override
	public String updateFromId(int id, String line) throws IOException {
		System.out.print("New value (FirstName): ");
		String firstNameUpdate = scanner.next();
		System.out.print("New value (LastName): ");
		String lastNameUpdate = scanner.next();
		System.out.print("New value (Age): ");
		String ageUpdate = scanner.next();
		String stringTab[] = line.split(",");
		stringTab[1] = stringTab[1].split(":")[1] = firstNameUpdate;
		stringTab[2] = stringTab[2].split(":")[1] = lastNameUpdate;
		stringTab[3] = stringTab[3].split(":")[1] = ageUpdate;
		line = String.join(",", stringTab);
		System.out.println(line);
		System.out.println(id);
		line = address.updateFromId(id, line);
		return line;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public void setIdStatic(int idStatic) {
		this.idStatic =  idStatic;
	}

	@Override
	public String toString() {
		return "id: " + id + 
				"\nFirst Name: " + firstName + 
				"\nLast Name: " + lastName + 
				"\nAge: " + age + 
				"\n" + address.toString();
	}

	public String toStringLinear() {
		return "id:" + id + ",FirstName:" + firstName + ",LastName:" + lastName + ",Age:" + age + "," + address.toStringLinear() + "\n";
	}

	public Person(String firstName, String lastName, int age, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.id = idStatic;
		this.idStatic++;
	}

	public Person(int id, String firstName, String lastName, int age, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public Person() {}
}
