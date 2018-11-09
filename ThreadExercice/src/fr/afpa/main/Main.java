package fr.afpa.main;

import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
//		myThread.start();
		Timer timer = new Timer();
		timer.schedule(myThread, 0, 1000);
	}

}
