package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

	public static FileInputStream fileInputStream;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA a = new AAA();
		String string1 = "blabla";
		String string2 = "blaba";
		int bla = 2;
		System.out.println(a.concat(string1,string2));
		System.out.println(a.concat(string1,bla));
		Properties p = new Properties();
		try {
			fileInputStream = new FileInputStream("");
			p.load(fileInputStream);
		}
		catch(IOException e) {

		}
		System.out.println(p.getProperty("charSet"));
	}
}
