package fr.afpa.main;

public class ReadThread extends Thread{
	
	private MultiThread multiThread;
	
	public void run() {
		try {
			multiThread.readThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	public ReadThread(MultiThread multiThread) {
		super();
		this.multiThread = multiThread;
	}

}
