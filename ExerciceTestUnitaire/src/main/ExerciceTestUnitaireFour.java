package main;

import java.io.File;
import java.io.RandomAccessFile;

public class ExerciceTestUnitaireFour {

	private File file;

	public void writeFile(String filePath, String value) {		
		if(value != null) {
			RandomAccessFile randomAccessFile = null;
			try {
				file = new File(filePath);
				randomAccessFile = new RandomAccessFile(file, "rw");
				randomAccessFile.seek(file.length());
				randomAccessFile.write(value.getBytes());
			} 
			catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					randomAccessFile.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				throw new Exception("writeFile ERROR");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String readFile(String filePath) {
		RandomAccessFile randomAccessFile = null;
		String listString = "";
		try {
			File file = new File(filePath);
			randomAccessFile = new RandomAccessFile(file, "rw");
			String line = "";
			while(line != null) {
				line = randomAccessFile.readLine();
				if(line != null) {
					listString += line;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				randomAccessFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listString;
	}

	public void removeFile(String filePath) {
		file = new File(filePath);
		file.delete();
	}

}
