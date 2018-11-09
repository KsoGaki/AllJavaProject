package business.entitie;

import java.util.List;

public class Person {

	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private List<Animal> listAnimal;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<Animal> getListAnimal() {
		return listAnimal;
	}
	public void setListAnimal(List<Animal> listAnimal) {
		this.listAnimal = listAnimal;
	}
	
	@Override
	public String toString() {
		return "id: " + id 
			 + "\nfirstName: " + firstName 
			 + "\nlastName: " + lastName 
			 + "\nage: " + age
			 + "\nlistAnimal: " + listAnimal.toString();
	}
	
	public Person() {}
	
	public Person(long id, String firstName, String lastName, int age, List<Animal> listAnimal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.listAnimal = listAnimal;
	}
}
