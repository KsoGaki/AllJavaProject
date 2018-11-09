package main;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MyFileManager {

	private File file;

	private void load(String pathFile) {
		file = new File(pathFile);
	}

	public List<String> list() {
		RandomAccessFile randomAccessFile = null;
		List<String> listString = new ArrayList<>();
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			String line = "";
			while(line != null) {
				line = randomAccessFile.readLine();
				if(line != null) {
					listString.add(line);
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				randomAccessFile.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return listString;
	}

	public long size() {
		long nbLine = 0;
		List<String> listString = this.list();
		for (String string : listString) {
			nbLine += string.length();
		}
		return nbLine;
	}

	public void append(String line) {
		RandomAccessFile randomAccessFile = null;
		try {
			if(line == null) {
				throw new Exception("LINE IS NULL");
			}
			else {
				randomAccessFile = new RandomAccessFile(file, "rw");
				randomAccessFile.seek(file.length());
				line = line + "\r";
				randomAccessFile.write(line.getBytes());
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				randomAccessFile.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void remove(String line) {
		RandomAccessFile randomAccessFile = null;	
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.seek(file.length());
			List<String> listString = this.list();
			if(listString.contains(line)) {
				while(listString.contains(line)) {
					listString.remove(line);
				}
				randomAccessFile.setLength(0);
				for (String string : listString) {
					randomAccessFile.write(string.getBytes());
				}
			}
			else {
				throw new Exception("ERROR REMOVE");
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				randomAccessFile.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public MyFileManager(String pathFile) {
		super();
		load(pathFile);
	}

	public MyFileManager() {
		super();
	}

}
