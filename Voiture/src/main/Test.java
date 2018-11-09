package main;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Voiture v = new Voiture();
		boolean isContinue = true;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		while(isContinue) {
			System.out.println("Qu'est ce que vous voulez faire ?");
			System.out.println("1 - Allumer/Eteindre le moteur");
			System.out.println("2 - Relacher/Enclencher le frein à main");
			System.out.println("3 - Accélere/Décélere la vitesse de la voiture");
			System.out.println("3 - Activer/Désactiver les phares");
			System.out.println("9 - Exit");
			System.out.println("");		
			System.out.println("########################################");
			System.out.println("#                                      #");
			System.out.println("#         Etat de la voiture           #");
			System.out.println("#                                      #");
			System.out.println("#     Frein : " + v.getFreinOn() + "    Moteur : " + v.getMotorOn() +"      #");
			System.out.println("#            Phares : " + v.getPhareOn() +  "              #");
			System.out.println("#           Voiture : " + v.getAvance() + "           #");
			System.out.println("#                                      #");
			System.out.println("########################################");
			System.out.println("");		
			System.out.print("Entrée : ");
			choice = scanner.nextInt();
			System.out.println("");
			switch(choice) {

			case 1:
				v.demarre();
				break;

			case 2:
				v.frein();
				break;

			case 3:
				v.avance();
				break;	
				
			case 4:
				v.phare();
				break;

			case 9:
				isContinue = false;
				break;

			default:
				System.out.println("Entrez une valeur adéquat");
				break;
			}
			System.out.println("");
		}
		scanner.close();
	}
}


