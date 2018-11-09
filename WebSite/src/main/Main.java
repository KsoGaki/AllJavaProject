package main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String urlString = "http://www.montpellier.fr/";
			URL url = new URL(urlString);
			String html= "";
			URLConnection urlConnection = url.openConnection();
			InputStream inputStream = url.openStream();
			int nbRead = 0;
			byte[] byteTab = new byte[1];
			while(nbRead != -1 ) {
				nbRead = inputStream.read(byteTab);
				if(nbRead != -1) {
					html = new String(byteTab, "UTF-8"); 
					System.out.print(html);
				}
			}

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
