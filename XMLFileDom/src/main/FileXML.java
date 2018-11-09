package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXML {

	private static File file;

	private static List<Person> personList = new ArrayList<>();

	//Get Document Builder
	private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder builder;
	//Build Document
	private static Document document;

	public void read() throws ParserConfigurationException, SAXException, IOException {
		builder = factory.newDocumentBuilder();
		document = builder.parse(file);
		document.getDocumentElement().normalize();

		//Get all employees
		NodeList nList = document.getElementsByTagName("staff");

		for(int i = 0; i < nList.getLength(); i++)	{
			Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)  {
				Element element = (Element) node;
				personList.add(new Person( //Create a new Person
						Integer.parseInt(element.getAttribute("id")),
						element.getElementsByTagName("firstname").item(0).getTextContent(),
						element.getElementsByTagName("lastname").item(0).getTextContent(),
						element.getElementsByTagName("nickname").item(0).getTextContent(),
						Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent())
						));
			}
		}
	}

	public void displayPerson() {
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}

	FileXML(String filePath) {
		file = new File(filePath);
	}
}
