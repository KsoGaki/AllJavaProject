package main;

public class AAA extends AA{
	
	public String concat(String s1, String s2) {
		return s1 + s2;
	}
	
	public String concat(String s1, int i1) {
		return s1 + i1;
	}
	
	AAA() {
		System.out.println("AAA");
	}
}
