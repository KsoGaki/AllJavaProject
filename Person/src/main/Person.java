package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private String fname;
	private String lname;
	private int age = 10;


	public void growUp() {
		age++;
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

	public int getId() {
		return id;
	}

	public Person(int id,String fname, String lname, int age) {
		super();
		this.id = count.incrementAndGet(); 
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
}
