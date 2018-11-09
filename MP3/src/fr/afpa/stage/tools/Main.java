package fr.afpa.stage.tools;

import java.io.IOException;
import java.util.Scanner;

import fr.afpa.stage.tools.Mp3Manager;

public class Main {

	public static Mp3Manager file; 

	public static Scanner scanner = new Scanner(System.in);

	public static final String os = System.getProperty("os.name");

	public static void main(String[] args) {
		try {
			String filePath = "file/muzik.mp3";
			file = new Mp3Manager(filePath);
			String choice = "";
			boolean isContinue = true;
			String newTag = "";
			while(isContinue) {
				System.out.println(
								"0 - Arrêter "
								+ "\n1 - Nouveau Titre (Actuellement : " + file.getTitle().trim() +")"
								+ "\n2 - Nouvelle Artist (Actuellement : " + file.getArtist().trim() +")"
								+ "\n3 - Nouveau Titre Album (Actuellement : " + file.getAlbum().trim() +")"
								+ "\n4 - Nouvelle Année (Actuellement : " + file.getYear().trim() +")"
								+ "\n5 - Nouveau Commentaire (Actuellement : " + file.getComment().trim() +")"
								+ "\n6 - Nouveau Genre (Actuellement : " + file.getGenre().trim() +")"
								+ "\n7 - Afficher les TAGs");
				choice = scanner.next();
				switch(choice) {


				case "1":
					System.out.print("Entrez votre nouveau Titre (Longeur Max : 30) : ");
					newTag = scanner.next();
					file.setTitle(newTag);
					break;

				case "2":
					System.out.print("Entrez votre nouveau d'Artist (Longeur Max : 30) : ");
					newTag = scanner.next();
					file.setArtist(newTag);
					break;

				case "3":
					System.out.print("Entrez votre nouveau nom d'Album (Longeur Max : 30) : ");
					newTag = scanner.next();
					file.setAlbum(newTag);
					break;

				case "4":
					System.out.print("Entrez votre nouvelle Année (Longeur Max : 4) : ");
					newTag = scanner.next();
					file.setYear(newTag);
					break;

				case "5":
					System.out.print("Entrez votre nouveau Commentaire (Longeur Max : 30) : ");
					newTag = scanner.next();
					file.setComment(newTag);
					break;

				case "6":
					System.out.print("Entrez votre nouveau Genre (Longeur Max : 1) : ");
					newTag = scanner.next();
					file.setGenre(newTag);
					break;

				case "7":

					break;

				case "0":
					System.out.println("ByeBye");
					isContinue = false;
					break;
				default : 
					break;
				}

				if (os.contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
				}
				else {
					Runtime.getRuntime().exec("clear");
				}
				file.write();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();		
		} 
		finally {
			try {
				Mp3Manager.getRandomAccessFile().close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}