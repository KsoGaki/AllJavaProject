package fr.afpa.objects;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.interfaces.IDisplay;

public class FileManager {

	private File file;

	private RandomAccessFile randomAccessFile;

	private IDisplay iDisplay;
	
	private List<IDisplay> listIDisplay = new ArrayList<>();

	public int init() throws IOException {
		String lineRead = "";
		String lastRead = null;
		int lastId = 0;
		while(lineRead != null) {
			lineRead =  randomAccessFile.readLine();
			if(lineRead != null) {
				lastRead = lineRead;
			}
		}
		if(lastRead != null) {
			lastId = Integer.parseInt(lastRead.split(",")[0].split(":")[1]) + 1;
		}
		return lastId;
	}
	
	public void updateData(int id) throws IOException {
		String lineRead = "";
		String goodLine = "";
		int i = 0;
		while(lineRead != null) {
			lineRead =  randomAccessFile.readLine();
			if(lineRead != null) {
				if(Integer.parseInt(lineRead.split(",")[0].split(":")[1]) == id) {
					goodLine = lineRead;
					break;
				}
				i++;
			}
		}
		System.out.println(iDisplay.updateFromId(i, goodLine));
	}

	public void saveData(Person person) throws IOException {
		randomAccessFile.seek(file.length());
		byte[] tabByte = person.toStringLinear().getBytes();
		randomAccessFile.write(tabByte);
	}

	public String readData() throws IOException {
		String dataRead= ""; 
		String lineRead = "";
		while(lineRead != null) {
			lineRead = randomAccessFile.readLine();
			System.out.println(lineRead);
			if(lineRead != null) {
				listIDisplay.add(iDisplay.getSplitData(lineRead));
				lineRead = listIDisplay.get(listIDisplay.size()).toString();
				dataRead += lineRead + "\n";
			}
		}		
		return dataRead;
	}
	
	public List<IDisplay> getListIDisplay() {
		return listIDisplay;
	}

	public File getFile() {
		return file;
	}

	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}


	public FileManager(String filePath, IDisplay iDisplay) throws IOException {
		super();
		this.file = new File(filePath);
		this.randomAccessFile = new RandomAccessFile(file, "rw");
		this.iDisplay = iDisplay;
	}

	public FileManager(String filePath) throws IOException {
		super();
		this.file = new File(filePath);
		this.randomAccessFile = new RandomAccessFile(file, "rw");
	}
}
