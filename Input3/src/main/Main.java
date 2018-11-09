package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {


	public static FileReader fileRead;
	
	public static BufferedReader fileBufferRead;
	
	public static String display = "";

	public static void main(String[] args) throws Exception {

		try {
			String pathFileRead = "./file/alire";
			fileRead = new FileReader(pathFileRead);
			fileBufferRead = new BufferedReader(fileRead);
			String toAdd = " ";
			while(toAdd != null) {
				toAdd = fileBufferRead.readLine();
				if(toAdd != null) {
					display += toAdd + "\n";
				}
			}
			System.out.println(display);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		finally {
			try {
				fileRead.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
