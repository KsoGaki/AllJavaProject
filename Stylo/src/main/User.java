package main;

public class User {
	private String name;
	public void doWrite(boolean isPlugOn) {
		if(isPlugOn) {
			System.out.println("Tu ne peux pas �crire avec le capuchon");
		}
		else {
			System.out.println("Tu �cris au tableau");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String name) {
		this.name = name;
	}
}
