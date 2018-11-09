package main;
import main.Famille;
import main.Person;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static Famille said = new Famille(0,"Said","Oubram",22);


	public static Famille changePerson(Famille person) {
		int id = 0;
		while(true && id != -1) {
			System.out.print("Choisis un ID : ");
			id = scanner.nextInt();
			if(id == said.getId()) {
				return said;
			}
			else {
				for(int i = 0; i < said.getNbenfant(); i++) {
					if(id == said.getEnfants()[i].getId()) {	
						return said.getEnfants()[i];
					}
				}
			}

			System.out.println("ID invalide (-1 pour arrêter)");
		}
		return person;
	}



	public static void main(String[] args) throws IOException, InterruptedException {
		boolean isContinue = true;
		Famille person = said;
		while(isContinue) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("   ###################################################################################################################");
			System.out.println("   #                              Personne Actuel : " + person.getId() + " - " + person.getFname() + " " + person.getLname() + " " + person.getAge() + "ans                                            #");
			System.out.println("   #                                                                                                                 #");
			System.out.print("   #         1 - Changer de personne   ");
			System.out.print("2 - Faire accoucher   ");
			System.out.print("3 - Faire grandir   ");
			System.out.println("4 - Afficher arbre généalogique     #");
			System.out.println("   ###################################################################################################################");
			System.out.print("Votre choix : ");
			String choice  = scanner.next();
			System.out.println("");


			switch(choice) {

			case "1":
				person = changePerson(person);
				break;

			case "2":
				if(person.getAge() > 17 && person.getNbenfant() < 10) {
					System.out.print("Donner un nom a votre enfant ");
					String askName = scanner.next();
					person.giveBirth(askName);
				}
				else {
					System.out.println("Tu ne peux pas avoir d'enfant");
				}
				break;

			case "3":
				person.growUp();
				break;

			case "4": 
				System.out.println("");
				System.out.println("");
				person.getEverything(0,"");
				System.out.println("");
				System.out.println("");
				break;

			default: 

				break;
			}
			System.out.print("Continuer Yes/No ? ");
			if(scanner.next() == "No") {
				isContinue = false;
			}
		}
		scanner.close();
	}
}
