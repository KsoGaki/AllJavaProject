package fr.afpa.main;

import java.io.IOException;
import java.util.Scanner;

import fr.afpa.interfaces.IDisplay;
import fr.afpa.objects.Address;
import fr.afpa.objects.Person;
import fr.afpa.objects.FileManager;

@SuppressWarnings("unused")
public class MainTwo {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String filePath = "file/file";
			IDisplay iDisplay = new Person();
			FileManager fileManager = new FileManager(filePath, iDisplay);
			System.out.println(fileManager.readData());
			fileManager.updateData(2);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
