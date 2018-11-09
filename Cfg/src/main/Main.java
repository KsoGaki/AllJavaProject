package main;

import java.io.IOException;

public class Main {

	public static FileCFG fileCFG;
	
	public static void main(String[] args) {
		try {
			String filePath = "file/file.cfg";
			fileCFG = new FileCFG(filePath);
			fileCFG.read();
			System.out.println(fileCFG.toString());
		}
		catch(IOException e) {

		}
	}
}
