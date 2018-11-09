package main;

public class Main {
		
	public static void main(String[] args) throws Exception {
		File file = new File("/home/file.txt");
		try {
			file.open();
			file.read();	
		} catch (OpenException e) {
			e.printStackTrace();
		} catch (ReadException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (CloseException e2) {
				e2.printStackTrace();
			}
		}
	}
}