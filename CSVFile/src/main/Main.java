package main;

import java.io.IOException;

public class Main {
	
	public static FileCSV fileCSV;

	public static void main(String[] args) {
		try {
			String filePath = "file/csv.txt";
			String separator = ",";
			boolean hasTitle = true;
			fileCSV = new FileCSV(filePath, separator, hasTitle);
			fileCSV.readTitle();
			fileCSV.readData();
			fileCSV.displayTitle();
			System.out.println();
			fileCSV.displayData();
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			
		}
	}

}
