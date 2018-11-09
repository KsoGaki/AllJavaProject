package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	@SuppressWarnings("unused")
	private static String readFile(FileReader fileTest) throws IOException {
		String content = "";
		int nbRead = 0; 
		char[] tab = new char[1024];
		while(nbRead != -1) {
			nbRead = fileTest.read(tab);
			if(nbRead != -1) {
				content += new String(tab, 0 , nbRead);
			}
		}
		return content;
	}

	public static FileReader fileRead;

	public static FileWriter fileCreate;

	public static String copyFile;

	public static void main(String[] args) {

		try {
			String pathFileRead = "./file/alire";
			fileRead = new FileReader(pathFileRead);
			copyFile = readFile(fileRead);
			System.out.println(copyFile);
			
		}
		catch(IOException e) {
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
		try {
			String pathFileCreate = "./file/create";
			fileCreate = new FileWriter(pathFileCreate);
			copyFile = copyFile.toUpperCase();
			char[] b = copyFile.toCharArray();
			fileCreate.write(b);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		finally {
			try {
				fileCreate.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
