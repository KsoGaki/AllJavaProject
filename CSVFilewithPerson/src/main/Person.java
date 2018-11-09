package main;

public class Person {
	
	private String fName; 
	private String lName; 
	private String eMail; 
	private int age;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Prénom: " + fName + ", Nom: " + lName + ", E-Mail: " + eMail + ", Age: " + age;
	}
	public Person(String fName, String lName, String eMail, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.eMail = eMail;
		this.age = age;
	}	
}
