package main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static FileXML fileXML;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String filePath = "file/test.xml";
			fileXML = new FileXML(filePath);
			fileXML.read();
			fileXML.displayPerson();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

}
