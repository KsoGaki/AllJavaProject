package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = new User("Blabla");
		Pen pen = new Pen();
		user.doWrite(pen.unPlug());
		user.doWrite(pen.setPlug());
		scanner.close();
	}
}