package fr.afpa.main;

import java.util.TimerTask;

public class MyThread extends TimerTask {
	
	private int x = 0;
	
	public void run() {
		System.out.println("Second: " + x);
		x++;
	}

}
