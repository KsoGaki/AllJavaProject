package main;

public class Main {
	public static void main(String[] args) {
		MyFactory object = new MyFactory();
		object.newInstance().compute();
	}

}
