package main;

import java.util.List;

import junit.framework.TestCase;

public class TestClassList extends TestCase{

	public void testCreateClass() {

		int nombreDeString = 5;
		List<String> listString = new ClassList().CreateList(nombreDeString);
		assertEquals(nombreDeString,listString.size());
		
		nombreDeString = - 1;
		listString = new ClassList().CreateList(nombreDeString);
		assertNull(listString);
		
		nombreDeString = 5;
		String prefix = "Saïd";
		listString = new ClassList().CreateList(nombreDeString, prefix); 
		assertEquals(nombreDeString,listString.size());
		
		prefix = null;
		listString = new ClassList().CreateList(nombreDeString, prefix);
		assertNotNull(listString);
		
		assertEquals(listString.get(1), "Autre chose");
	}
	
}
