package main;

public class Person {
	
	private int id;
	private String fName;
	private String lName;
	private String nickname;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id: " + id 
				+ "\nFirst Name: " + fName 
				+ "\nLast Name: " + lName 
				+ "\nNickname: " + nickname 
				+ "\nSalary: " + salary
				+ "\n";
	}
	public Person(int id, String fName, String lName, String nickname, int salary) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.nickname = nickname;
		this.salary = salary;
	}
}
