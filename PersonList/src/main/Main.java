package main;

public class Main {

	private static void log(String x) {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("Sa�dur","Pire",45);
		Person person2 = new Person("Sa�Dehors","Pire",89);
		Person person3 = new Person("Sa�Diable","Eldemon",22);
		log(person1.toString());
		log(person2.toString());
		log(person3.toString());
		Person clone1 = person1.toClone(person1);
		Person clone2 = person1.toClone(person2);
		Person clone3 = person1.toClone(person3);
		clone1.setFname("Sa�Doux");
		clone2.setFname("Sa�Dans");
		clone3.setFname("Sa�D'ange");
		log(clone1.toString());
		log(clone2.toString());
		log(clone3.toString());
		log(person1.toString());
		log(person2.toString());
		log(person3.toString());
	}

}
