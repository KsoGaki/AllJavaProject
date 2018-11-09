package fr.afpa.main;

public class MultiThread extends Thread {
	
	private static boolean isFlaged = true;

	public void runMulti() {
		try {
			if(isFlaged) {
				System.out.println("Start the program ");
				start();
				Thread.sleep(11000);
				isFlaged = false;
				currentThread().interrupt();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I'm out");
	}

	public void run() {
		int z = 0;
		int y = 0;
		int x = 0;
		while(isFlaged) {
			try {
				if(isFlaged) {
					System.out.println("Saïd v"+z+"."+y+"."+x);
					if(x < 9) {
						x++;
					}
					else {
						x=0;
						y++;
					}
					if(y >= 9) {
						y=0;
						z++;
					}	
				}
				if(!(x == 0 && y == 0 && z == 0)) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
