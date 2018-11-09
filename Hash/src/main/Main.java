package main;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int x = 0;
		Map<String,Integer> map = new HashMap<>();
		while(map.get("odd") == null || map.get("even") == null) {
			x = (int)(Math.random()*10);
			if(x % 2 == 0) {
				map.put("even",x);
			}
			else {
				map.put("odd",x);
			}
		}
		System.out.println("Chiffre odd : " + map.get("odd") + "\nChiffre even : " + map.get("even"));
	}
}
