package main;

public class MyFactory {
	Iterface object;
	public  Iterface newInstance() {
		if(Math.random() < 0.5) {
			object = new First();
		}
		else {
			object = new Second();
		}
		return object;
	}
}
