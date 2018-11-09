package main;
import java.util.Scanner;

public class Square {
	
	public static void getSquareRoot(int x, int y, double i, double result) {
		if(y >= 0) {
			if(getSquare(result) <= x && getSquare(result + Math.pow(0.1,i)) > x) {
				i++;
				y--;
			}
			result += Math.pow(0.1,i);
			getSquareRoot(x,y,i,result);
		}
		else {
			System.out.printf("Le resultat est %."+ ((int)i-1) +"f", result);
		}
	}
	public static double getSquare(double x) {
		return x*x;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez un nombre à mettre à la racine carrée ");
		int nombre = scanner.nextInt();
		System.out.print("Entrez un nombre pour  ");
		int prec = scanner.nextInt();
		getSquareRoot(nombre, prec, 0, 0);
		scanner.close();
	}

}
