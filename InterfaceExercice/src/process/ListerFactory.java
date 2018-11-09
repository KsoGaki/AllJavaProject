package process;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import objects.ILister;

public class ListerFactory {
	
	public static FileInputStream fileInputStream;
	
	public static Properties properties = new Properties();
	
	public static Class<?> classFactory;
	
	public static ILister newInstance() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String filePath = "file/file.cfg";
		fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);
		String pathPackage = "";
		pathPackage = properties.getProperty("pathPackage");
		classFactory = Class.forName(pathPackage);
		return (ILister) classFactory.newInstance();
	}
}
