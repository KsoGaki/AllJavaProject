package fr.afpa.main;

import java.util.ArrayList;
import java.util.List;

public class MultiThread {

	private int nbRead = 0;
	
	private boolean isWriteOver = false;

	private static List<String> stringList = new ArrayList<>();

	private static char tripleChar ='A' - 1;

	private int writeWaitTime;

	private int readWaitTime;

	public void readThread() throws InterruptedException {
		while(nbRead != stringList.size() || isWriteOver == false) {
			if(stringList.size() > nbRead) {
				Thread.sleep(readWaitTime);
				System.out.println(stringList.get(nbRead));
				nbRead++;
			}
			else {
				System.out.print("");
			}
		}
	}
	
	public void writeThread() throws InterruptedException {
		String charToString = "";
		while(tripleChar != 'Z') {
			tripleChar++;
			charToString = tripleChar + "" + tripleChar + "" + tripleChar;
			stringList.add(charToString);
			Thread.sleep(writeWaitTime);
		}
		isWriteOver = true;
	}

	public void alphaMain() throws InterruptedException {
		WriteThread writeThread = new WriteThread(this);
		writeThread.start();
		ReadThread readThread = new ReadThread(this);
		readThread.start();
	}

	public static List<String> getStringList() {
		return stringList;
	}

	public MultiThread(int writeWaitTime, int readWaitTime) {
		super();
		this.writeWaitTime = writeWaitTime;
		this.readWaitTime = readWaitTime;
	}
}
