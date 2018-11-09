package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileCFG {
	
	public static File file;

	public static FileInputStream fileInputStream;
	
	public static FileOutputStream fileOutputStream;
	
	public static Properties properties = new Properties();

	private String fontWeight; 
	private String fontColor; 
	private String fontFamily; 
	private int fontSize; 
	
	public void read() throws IOException {
		fileInputStream = new FileInputStream(file);
		properties.load(fileInputStream);
		fontWeight = properties.getProperty("fontWeight");
		fontColor = properties.getProperty("fontColor");
		fontFamily = properties.getProperty("fontFamily");
		fontSize = Integer.parseInt(properties.getProperty("fontSize"));
	}
	
	public void write() throws IOException {
		fileOutputStream = new FileOutputStream(file);
		properties.load(fileInputStream);	
	}
	
	public String toString() {
		return "Font Weight: " + fontWeight 
			 + "\nFont Color: " + fontColor 
			 + "\nFont Family: " + fontFamily
			 + "\nFont Size: " + fontSize;
	}

	public String getfontWeight() {
		return fontWeight;
	}

	public String getFontColor() {
		return fontColor;
	}

	public String getFontFamily() {
		return fontFamily;
	}
	
	public int getFontSize() {
		return fontSize;
	}

	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}


	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	FileCFG(String filePath) throws IOException {
		file = new File(filePath);
	}
}
