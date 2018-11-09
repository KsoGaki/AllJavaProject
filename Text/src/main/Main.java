package main;

import java.util.HashMap;
import java.util.Map;

public class Main {

	private static void getMapLetter(String text, Map<String, Integer> letter) {
		String set;
		for(int i = 0; i < text.length(); i++) {
			set = "" + text.charAt(i);
			if(letter.get(set) == null ) {
				letter.put(set, 1);
			}
			else {
				letter.put(set, letter.get(set)  + 1);
			}
		}
	}

	private static void sortRecur(Map<String, Integer> sortMap) {
		int max = 0;
		String maxl = "";
		for (String l : sortMap.keySet()) {
			if( sortMap.get(l) >= max) {
				max = sortMap.get(l);
				maxl = l;
			}
		}
		System.out.println(maxl + " : " + max);
		if(sortMap.size() > 1) {
			sortMap.remove(maxl);
			sortRecur(sortMap);
		}
	}

	private static void displayMap(Map<String, Integer> letter) {
		for (String l : letter.keySet()) {
			System.out.println(l + " : " + letter.get(l));
		}
	}

	public static void main(String[] args) {
		String text = "package main;"+ 
				"public class Saisie {"+
				"public static String getInputString() throws Exception {"+
				"byte[] bs = new byte[255];"+
				"System.in.read(bs);"+
				"return new String(bs).trim();"+
				"}"+
				"public static int getInputInt() throws Exception {"+
				"String s = getInputString();"+
				"return Integer.parseInt(s);"
				+ "}"
				+ "}";
		text = text.toLowerCase();
		Map<String,Integer> letter = new HashMap<>();
		getMapLetter(text, letter);
		displayMap(letter);
		System.out.println();
		System.out.println();
		sortRecur(letter);
	}
}


