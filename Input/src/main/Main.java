package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	@SuppressWarnings("unused")
	private static String readFile(FileInputStream fileTest) throws IOException {
		String content = "";
		int nbRead = 0; 
		byte[] tab = new byte[1024];
		while(nbRead != -1) {
			nbRead = fileTest.read(tab);
			if(nbRead != -1) {
				content += new String(tab, 0 , nbRead);
			}
		}
		return content;
	}

	public static FileInputStream fileRead;

	public static FileOutputStream fileCreate;

	public static String copyFile;

	public static void main(String[] args) {

		try {
			String pathFileRead = "./file/alire";
			fileRead = new FileInputStream(pathFileRead);
			copyFile = readFile(fileRead);
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
			fileCreate = new FileOutputStream(pathFileCreate);
			copyFile = copyFile.toUpperCase();
			byte[] b = copyFile.getBytes();
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
