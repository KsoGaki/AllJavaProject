package fr.afpa.main;

import java.io.IOException;

import fr.afpa.objects.Address;
import fr.afpa.objects.FileManager;
import fr.afpa.objects.Person;

public class MainOne {
	
	public static FileManager fileManager;

	public static void main(String[] args) {		
		try {
			
			String filePath = "file/file";
			fileManager = new FileManager(filePath);
			new Person().setIdStatic(fileManager.init());

			Address adressOne = new Address("142 Rue de said", 34000, "France");	
			Address adressTwo = new Address("12 Rue de saiDoux", 34160, "France");
			Address adressThree = new Address("666 Rue de saiDiable", 34666, "France");	
			
			Person personOne = new Person("Said", "Oubram", 23, adressOne);		
			Person personTwo = new Person("SaiDoux", "PasRapeux", 52, adressTwo);	
			Person personThree = new Person("SaiDiable", "PasGentil", 666, adressThree);
			
			System.out.println(personOne.toString());
			System.out.println();
			System.out.println(personTwo.toString());
			System.out.println();
			System.out.println(personThree.toString());
			
			fileManager.saveData(personOne);
			fileManager.saveData(personTwo);
			fileManager.saveData(personThree);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileManager.getRandomAccessFile().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
