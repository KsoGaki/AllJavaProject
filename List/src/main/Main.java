package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static void displayList(List<Double> l) {
		int z = 0;
		for(Double s: l) {
			z++;
			System.out.println("n°" + z + " " + s);
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		List<Double> l = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			l.add(Math.random()*10);
		}
		displayList(l);
		Collections.sort(l);
		for(int i = l.size() - 1 ; i >= 0; i--) {
			if(l.get(i)%2 < 1) {
				l.remove(i);
			}
		}
		displayList(l);
	}


}

