package main;

public class Majorite {	

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		return new String(bs);
	}
	
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int age = getInputInt();
		if(age >= 18) {
			System.out.println("Vous êtes majeur!");
		}
		else {
			System.out.println("Vous êtes mineur!");
		}
	}

}
