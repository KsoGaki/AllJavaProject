package main;

public class Somme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int somme = 0;
		for(int i=0;i <= 100;i++) {
			somme += i;
		}
		System.out.println("Le resultat de la boucle for est " + somme);
		int a = 0;
		int b = 0;
		while(a <= 1000) {
			b += a;
			a++;
		}
		System.out.println("Le resultat de la boucle while est " + b);
	}

}
