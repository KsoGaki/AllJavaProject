package main;

public class Person {
	private String fname;
	private String lname;
	private int age;

	public Person toClone(Person original) {
		Person clone = new Person(
				original.getFname(),
				original.getLname(),
				original.getAge());
		return clone;
	}
	
	public String toString() {
		return "Prénom: " + fname + "\nNom: " + lname + "\nAge: " + age + "";
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Person(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}


}
