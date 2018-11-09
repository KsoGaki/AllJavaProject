package objects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileLister implements ILister {
	
	public static FileInputStream fileInputStream;

	public static Properties properties = new Properties();

	@Override
	public List<String> list() throws IOException  {
		String filePath = "file/value.cfg";
		fileInputStream = new FileInputStream(filePath);
		List<String> listString = new ArrayList<>();
		properties.load(fileInputStream);
		listString.add("First Name: " + properties.getProperty("firstName"));
		listString.add("Last Name: " +properties.getProperty("lastName"));
		listString.add("Age: " +properties.getProperty("age"));
		return listString;
	}

	@Override
	public void display() {
		System.out.println("FileLister");
	}

}
