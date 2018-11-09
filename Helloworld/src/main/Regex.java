package main;
import java.util.Scanner;

public class Regex {


	public static int timeContain(String a, String b) {
		int time = 0;
		boolean isContain = false;
		for(int i = 0; i < a.length(); i++) {
			isContain = false;
			if(a.charAt(i) == b.charAt(0)) {
				for(int y = 0; y < b.length() ; y++ ) {
					if(a.charAt(i+y) == b.charAt(y)) {
						isContain = true;
					}
					else {
						isContain = false;
					}
				}	
			}
			if(isContain == true) {
				time++;
			}
		}
		return time;
	}

	public static boolean isContain(String a, String b) {
		boolean isContain = false;
		for(int i = 0; i < a.length(); i++) {
			isContain = false;
			if(a.charAt(i) == b.charAt(0)) {
				for(int y = 0; y < b.length() ; y++ ) {
					if(a.charAt(i+y) == b.charAt(y)) {
						isContain = true;
					}
					else {
						isContain = false;
					}
				}	
			}
			if(isContain) {
				return isContain;
			}
		}
		return false;
	}
	
	public static String [] removeSpace(String [] a) {
		String stock;
		int newstring = a.length;
		if(a[0].equals("")) {
			newstring--;
		}
		if(a[a.length-1].equals("")) {
			newstring--;
		}
		String [] newTable;
		if(a.length != newstring) {
			newTable = new String[newstring];
			int incre =0;
			for(int i = 0; i < a.length; i++) {
				if(!a[i].equals("")) {
					newTable[incre] = a[i] ;
					incre++;
				}
			}
		}
		else {
			newTable = a;
		}
		for(int i = 0; i < newTable.length; i++) {
			stock = "";
			for(int y = 0; y < newTable[i].length(); y++) {
				if(newTable[i].charAt(y) == ' ') {

				}
				else {
					stock += newTable[i].charAt(y);
				}
			}
			newTable[i] = stock;
		}
		return newTable;
	}

	public static String [] getSplit(String a, String b) {
		boolean isContain = false;
		int x = 0;
		int [] resultat = new int[timeContain(a,b)];
		String [] send = new String [resultat.length + 1];
		for(int i = 0; i < a.length(); i++) {
			isContain = false;
			if(a.charAt(i) == b.charAt(0)) {
				for(int y = 0; y < b.length() ; y++ ) {
					if(a.charAt(i+y) == b.charAt(y)) {
						isContain = true;
					}
					else {
						isContain = false;
					}
				}	
			}
			if(isContain == true) {
				resultat[x] = i;
				x++;
			}
		}
		for(int i = 0; i < send.length; i++) {
			if (i == 0 && resultat[i] != 0) {
				send[i] = a.substring( 0 ,resultat[i]);
			}
			else if(i == 0 && resultat[i] == 0) {
				send[i] = "";
			}
			else if(i == resultat.length) {
				send[i] = a.substring(resultat[i-1] + b.length(), a.length());
			}
			else {
				send[i] = a.substring(resultat[i-1] + b.length(), resultat[i] );
			}
		}
		return send;
	}


	public static void getRegex(String a, String b) {
		int t = 0;
		int which = 0;
		for(int i = 0; i < b.length(); i ++) {
			if(b.charAt(i) == '\\' && b.charAt(i+1) == 's' && b.charAt(i+2) == '+') {
				which = 1;
				break;
			}
		}
		switch(which) {

		case 1:
			String [] splited = removeSpace(getSplit(b, "\\s+"));
			boolean test = false;
			for(int i = 0; i < splited.length; i++) {
				if(isContain(a, splited[i])) {
					test = true;
				}
				else {
					test = false;
				}
			}
			if(test) {
				System.out.print("les mots sont présents dans la liste");
			}
			else {
				System.out.print("les mots ne sont pas présents dans la liste");
			}
			break;

		default: 
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == b.charAt(t)) {
					if(t == b .length() - 1) {
						System.out.print("Il y a une correspondance exacte avec " + b);
						break;
					}
					else {
						t++;
					}
				}
				else {
					t = 0;
				}
			}
			break;

		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Entrez une phrase : ");
		String phrase = scanner.nextLine();
		System.out.print("Entrez un test : ");
		String test = scanner.nextLine();
		getRegex(phrase, test);
		scanner.close();

	}
}
