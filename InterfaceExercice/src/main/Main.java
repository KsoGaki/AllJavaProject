package main;

import java.io.IOException;
import java.util.List;

import objects.FileLister;
import objects.ILister;
import objects.MemLister;
import process.ListerFactory;

public class Main {
	
	public static ILister iLister;

	public static List<String> list;
	
	public static void main(String[] args) {
		try {
			iLister = ListerFactory.newInstance();
			if(iLister instanceof MemLister) {
				System.out.println("MemLister");
			}
			else if(iLister instanceof FileLister) {
				System.out.println("FileLister");
			}
			System.out.println();
			list = iLister.list();
			for (String string : list) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		finally {
			
		}
	}
}
