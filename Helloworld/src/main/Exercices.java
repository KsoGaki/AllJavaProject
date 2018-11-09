package main;
import java.util.Scanner;

public class Exercices {



	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		return new String(bs);
	}

	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}

	public static double getSquare(double square) throws Exception {
		return square*square;
	}
	public static double getRound(double round, int prec) throws Exception {
		return (double) Math.round(round * Math.pow(10, prec)) / Math.pow(10, prec);
	}

	public static int getMultiple2(int multiple) throws Exception {
		return multiple*2;
	}

	public static int getCarre(int carre) throws Exception {
		return carre*carre;
	}

	public static double getMoyenne(int[] moyenne) throws Exception {
		double result = 0;
		for(int i = 0; i < 5; i++) {
			result += moyenne[i]; 
		}
		return result/5;
	}
	
	public static double getSqaroot(int moyenne) throws Exception {
		
		return 5;
	}

	public static long getFibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return getFibonacci(n-1) + getFibonacci(n-2);
	} 

	public static int[] carreTableau(int[] scarre) throws Exception {
		for(int i = 0; i < 5; i++) {
			scarre[i] = scarre[i] * scarre[i]; 
		}
		return scarre;
	}

	public static int getNbmot(String mot) throws Exception {
		int compteur = mot.length() - mot.replaceAll(" ","").length() + 1;
		return compteur;
	}

	public static int[] getFibo(int fibostop) throws Exception {
		int [] sfibo = new int [fibostop];
		sfibo[0] = 0;
		sfibo[1] = 1;
		System.out.println();
		System.out.print(sfibo[0] + " | " + sfibo[1] + " | ");
		for(int i = 2; i <= fibostop - 1; i ++) {
			sfibo[i] = sfibo[i-1] + sfibo[i-2];
		}
		return sfibo;
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner( System.in );
		System.out.println("########################################");
		System.out.println("#                                                               #");
		System.out.println("#                 Choix de l'exercice                    #");
		System.out.println("#                                                               #");
		System.out.println("########################################");
		System.out.println("");
		System.out.println("1  - Bonjour!");
		System.out.println("2  - Multplication!");
		System.out.println("3  - TVA!");
		System.out.println("4  - Positif ou Negatif!");
		System.out.println("5  - Majuscule!");
		System.out.println("6  - Ordre Alphabétique!");
		System.out.println("7  - Contient!");
		System.out.println("8  - Age!");
		System.out.println("10 - Miles!");
		System.out.println("11 - Continue!");
		System.out.println("12 - Continue! v2");
		System.out.println("13 - Correction!");
		System.out.println("14 - Aléatoire!");
		System.out.println("15 - TableDouble!");
		System.out.println("16 - Damier!");
		System.out.println("17 - SupprimeCara!");
		System.out.println("18 - Multiple2!");
		System.out.println("19 - Carré!");
		System.out.println("20 - Moyenne!");
		System.out.println("20 - Carré!");
		System.out.println("22 - Compte!");
		System.out.println("23 - Fibo!");
		System.out.println("24 - Fibo function!");
		System.out.println("25 - Nombres premiers!");
		System.out.println("26 - Sqroot!");
		int choice = getInputInt();
		for(int i= 0; i < 50 ; i++) {
			System.out.println("");
		}


		switch(choice) {
		case 1:

			System.out.println("Bonjour cher utilisateur, ceci est votre premier programme !");
			break;
		case 2:

			System.out.println("Choisis deux nombres");
			System.out.print("a : ");
			int multi1 = getInputInt();
			System.out.print("b : ");
			int multi2 = getInputInt();
			System.out.println("La multiplication de a et b est :" + multi1*multi2);
			break;
		case 3:

			System.out.print("Prix HT de l'article : ");
			int priceht = getInputInt();
			System.out.print("Nombre d'articles : ");
			int articlenb = getInputInt();
			System.out.print("Taux de TVA : ");
			double tva = getInputInt();
			System.out.print("Le prix totale est : " + (priceht + priceht*(tva/100))*articlenb);
			break;

		case 4:
			System.out.println("Entrez deux nombres");				
			System.out.print("a : ");
			int first = getInputInt();
			System.out.print("b : ");
			int second = getInputInt();
			if((first < 0 && second < 0) || (first > 0 && second > 0)) {
				System.out.print("Le produit sera positif");
			}
			else if(first == 0 || second == 0) {
				System.out.print("Le produit sera nul");
			}
			else {
				System.out.print("Le produit sera négatif");
			}
			break;

		case 5:
			System.out.print("Ecrivez une phrase : ");
			String phrase = getInputString();
			System.out.print(phrase.toUpperCase());
			break;

		case 6:
			System.out.println("Rentrez trois prénoms : ");
			System.out.print("Prénoms n°1: ");
			String fname = scanner.nextLine();
			System.out.print("Prénoms n°2: ");
			String sname = scanner.nextLine();
			System.out.print("Prénoms n°3: ");
			String tname = scanner.nextLine();
			if(fname.compareTo(sname) <= 0 && fname.compareTo(tname) <= 0) {
				System.out.print(fname + ", ");
				if(sname.compareTo(tname) <= 0) {
					System.out.print(sname + ", " + tname);
				}
				else {
					System.out.print(sname + ", " + tname);
				}
			}
			else if(sname.compareTo(fname) <= 0 && sname.compareTo(tname) <= 0) {
				System.out.print(sname + ", ");
				if(fname.compareTo(tname) <= 0) {
					System.out.print(fname + ", " + tname );
				}
				else {
					System.out.print(sname + ", " + tname );
				}
			}
			else {
				System.out.print(tname + ", ");
				if(fname.compareTo(sname) <= 0) {
					System.out.print(fname + ", " + sname );
				}
				else {
					System.out.print(sname + ", " + tname );
				}
			}
			break;

		case 7:
			System.out.println("Entrez deux chaînes de  charactères");
			System.out.print("Première chaîne : ");
			String chaine1 = scanner.nextLine();
			System.out.print("Seconde chaîne : ");
			String chaine2 = scanner.nextLine();
			if(chaine1.contains(chaine2)) {
				System.out.print("Il y a présence d’une sous-chaîne dans l'autre chaîne de caractère");
			}
			else 
				System.out.print("Il y a pas présence d’une sous-chaîne dans l'autre chaîne de caractère");
			break;

		case 8:
			System.out.print("Entrez votre age : ");
			int ageenfant = 0;
			while (ageenfant < 6) {
				ageenfant = getInputInt();
			}
			if(ageenfant >= 6 && ageenfant <= 7) {
				System.out.print("Vous etes agé de " + ageenfant + " ans vous etes donc un Poussin");
			}
			else if(ageenfant >= 8 && ageenfant <= 9) {
				System.out.print("Vous etes agé de " + ageenfant + " ans vous etes donc un Pupille");
			}
			else if(ageenfant >= 10 && ageenfant <= 11) {
				System.out.print("Vous etes agé de " + ageenfant + " ans vous etes donc un Mimine");
			}
			else if(ageenfant >= 12){
				System.out.print("Vous etes agé de " + ageenfant + " ans vous etes donc un Cadet");
			}
			break;

		case 10:
			System.out.print("Entrez une valeur à convertir : ");
			int miles = getInputInt();
			System.out.println();
			System.out.println("Miles       Km/s");
			for(int i = 1; i <= miles; i++) {
				System.out.println(i + "           " + i*1.609);
			}
			break;

		case 11:
			int index = 0;
			char cont = 'o';
			while(cont != 'n' && cont != 'N') {
				System.out.print("Entrez une valeur : ");
				index = getInputInt();
				if(index >= 100 && index <= 1000 ) {
					System.out.println(index);
				}
				else {
					System.out.println("Nah!");
				}
				System.out.print("Voulez-vous continuez ?(o/N) ");
				cont = scanner.nextLine().charAt(0);
			}
			break;
		case 12:
			char cont2 = 'o';
			int index2 = 100;
			do{
				System.out.print("Entrez une valeur : ");
				index2 = getInputInt();
				if(index2 >= 100 && index2 <= 1000 ) {
					System.out.println(index2);
				}
				else {
					System.out.println("Nah!");
				}
				System.out.print("Voulez-vous continuez ?(o/N) ");
				cont2 = scanner.nextLine().charAt(0);
			} while(cont2 != 'n' && cont2 != 'N');
			break;
		case 13:
			int valuea = scanner.nextInt();
			if(valuea != 0) {
				valuea = 10;
				int valueb = 3+2*valuea;
				System.out.println("b="+valueb);
			}
			else {
				valuea = 8;
				int valuec = 3 + valuea;
				System.out.println("c="+valuec);
			}
			System.out.println("a="+valuea);
			break;
		case 14:
			int max = 0;
			int min = 100;
			int intTable[] = new int[20];
			for(int i = 0; i < 20; i++) {
				intTable[i] = (int)(Math.random()*100);
				System.out.print(intTable[i] + " ");
				if(intTable[i] < min) {
					min = intTable[i];
				}
				if(intTable[i] > max) {
					max = intTable[i];
				}
			}
			System.out.println("");
			System.out.println("Le nombre max est " + max + " et le min est " + min );
			int store = 0;
			boolean isorder = false;
			while(isorder == false) {
				isorder = true;
				for(int i = 0; i < 19; i++) {
					if(intTable[i] > intTable[i + 1]) {
						store = intTable[i+1];
						intTable[i + 1] = intTable[i];
						intTable[i] = store;
						isorder = false;
					}
				}
			}
			System.out.print("Dans l'ordre :");
			for(int i = 0; i < 20; i++) {
				System.out.print(intTable[i] + " ");
			}
			break;
		case 15:
			int[][] doubleTable = new int[13][6];
			for(int i = 0; i < 13; i++) {
				System.out.println("");
				for(int x = 0; x < 6; x++) {
					if(i%2 == 0) {
						doubleTable[i][x] = 1;
					}
					else {
						doubleTable[i][x] = 0;
					}
					System.out.print(doubleTable[i][x] +" ");
				}
			}
			break;
		case 16:
			char[][] damier = new char[10][10];
			int pos1 = 0;
			int pos2 = 0;
			int newpos = 0;
			for(int i = 0; i < 10; i++) {
				System.out.println("");
				for(int x = 0; x < 10; x++) {
					if(i == 4 || i == 5) {
						damier[i][x] = '▢';
					}
					else {
						if(i%2 == 0 && x%2 == 0 ) {
							damier[i][x] = '▣';
						}
						else if(i%2 == 1 && x%2 == 1 ) {
							damier[i][x] = '▣';
						}
						else {
							damier[i][x] = '▢';
						}
					}
					System.out.print(damier[i][x] +" ");
				}
			}
			System.out.println("");
			System.out.println("Donnez la position du pion!");
			pos1 = getInputInt();
			pos2 = getInputInt();
			//			while(isContinue == 'o') {
			if(damier[pos1][pos2] == '▣') {
				System.out.println("Donnez la nouvelle position du pion!");
				newpos = getInputInt();
				if(newpos == 0) {
					damier[pos1][pos2] = '▢';
					damier[pos1 - 1][pos2 - 1] = '▣';
				}
				if(newpos == 1) {
					damier[pos1][pos2] = '▢';
					damier[pos1 - 1][pos2 + 1] = '▣';
				}
				if(newpos == 2) {
					damier[pos1][pos2] = '▢';
					damier[pos1 + 1][pos2 - 1] = '▣';
				}
				if(newpos == 3) {
					damier[pos1][pos2] = '▢';
					damier[pos1 + 1][pos2 + 1] = '▣';
				}
			}

			//			}
			for(int i = 0; i < 10; i++) {
				System.out.println("");
				for(int x = 0; x < 10; x++) {
					System.out.print(damier[i][x] + " ");
				}
			}
			break;

		case 17:
			System.out.print("Entrez une phrase : ");
			String phrasesuppr = scanner.nextLine();
			System.out.print("Entrez le rang d'un caractère à supprimer : ");
			int suppr = scanner.nextInt();
			System.out.print(phrasesuppr.substring(0, suppr-1) + "" + phrasesuppr.substring(suppr, phrasesuppr.length()));
			break;

		case 18:
			System.out.print("Entrez une valeur à multiplier par 2 : ");
			System.out.println("Le resultat est " + getMultiple2(scanner.nextInt())); 
			break;

		case 19:
			System.out.print("Entrez une valeur à mettre au carré : ");
			System.out.println("Le resultat est " + getCarre(scanner.nextInt())); 
			break;

		case 20:
			System.out.print("Entrez 5 valeurs pour faire une moyenne : ");
			int []smoyenne = new int [5]; 
			for(int i = 0; i < 5; i++) {
				smoyenne[i] = scanner.nextInt();
			}
			System.out.println("Le resultat est " + getMoyenne(smoyenne)); 
			break;

		case 21:
			System.out.print("Entrez 5 valeurs pour faire une moyenne : ");
			int []carreT = new int [5]; 
			for(int i = 0; i < 5; i++) {
				carreT[i] = scanner.nextInt();
			}
			carreT = carreTableau(carreT);
			for(int i = 0; i < 5; i++) {
				System.out.println("Le resultat est " + carreT[i]);
			}
			break;
		case 22:
			System.out.print("Entrez une phrase : ");
			String nbmot = scanner.nextLine();
			System.out.print("Le nombre de mot est " + getNbmot(nbmot));
			break;

		case 23:
			int fibo0 = 0;
			int fibo1 = 1;
			int stock = 0;
			System.out.print("Entrez le nombre de valeur ");
			int fibomax = scanner.nextInt();
			System.out.println();
			System.out.print(fibo0 + " | " + fibo1 + " | ");
			for(int i = 0; i <= fibomax - 2; i ++) {
				stock = fibo0 + fibo1;
				System.out.print(stock + " | ");
				if(fibo0 < fibo1) {
					fibo0 = stock;
				}
				else {
					fibo1 = stock;
				}
			}
			break;
		case 24:
			System.out.print("Entrez le nombre de valeur ");
			int [] fiboTalbe = getFibo(scanner.nextInt());
			for(int i = 2; i < fiboTalbe.length; i++) {
				System.out.print(fiboTalbe[i] + " | ");

			}
			break;

		case 25:
			System.out.print("Entrez le nombre de valeur ");
			int nbpre = scanner.nextInt();
			int test = 2;
			int premier = 2;
			boolean iprem = false;
			System.out.println("");
			while(nbpre > 0) {
				test = premier;
				while(test > 1 ) {
					if(premier%test == 0 && premier != test) {
						iprem = true;
					}
					test--;
				}
				if(!iprem) {
					nbpre--;
					System.out.print(premier + " | ");
				}
				iprem = false;
				premier++;
			}
			break;
		case 26:
			System.out.print("Entrez une précision ");
			int roundnb = scanner.nextInt();
			int stop = 1;
			System.out.print("Entrez un nombre ");
			double sqroot = scanner.nextInt();
			double sqr1 = 0;
			double sqr2 = 1;
			boolean isFind = false;
			while(!isFind) {
				if(getSquare(sqr1) <= sqroot && getSquare(sqr2) > sqroot) {
					System.out.println("Le nombre est " + sqr1);
					isFind = true;
				}
				else {
					sqr1++;
					sqr2++;
				}
			}
			while(stop <= roundnb) {
				for(double i = sqr1; i < sqr2; i += Math.pow(0.1,stop)) {
					if(getSquare(getRound(i,stop)) <= sqroot && getSquare(getRound(i+Math.pow(0.1,stop),stop)) > sqroot) {
						sqr1 = getRound(i,stop);
						sqr2 = getRound(i+Math.pow(0.1,stop),stop);
						System.out.println("Le nombre est " + sqr1+ " exact = "+Math.sqrt(sqroot));
					}
				}
				stop++;
			}
			break;
		}
		scanner.close();
	}
}
