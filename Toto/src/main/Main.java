package main;

public class Main {

	public static void main(String[] args) {
		Toto<String> one = new Toto<>("Babla");
		Toto<Integer> two = new Toto<>(5);
		Toto<Person> three = new Toto<Person>(new Person("Bla","blabla",5));
		
	}

}
