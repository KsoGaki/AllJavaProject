package fr.afpa.main;

public class WriteThread extends Thread {
	
	private MultiThread multiThread;
	
	public void run() {
		try {
			multiThread.writeThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	public WriteThread(MultiThread multiThread) {
		super();
		this.multiThread = multiThread;
	}
}
