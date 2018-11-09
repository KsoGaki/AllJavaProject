package main;
import java.io.File;

import junit.framework.TestCase;

public class TestMyFileManager extends TestCase{

	MyFileManager myFileManager = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String pathFile = "file/file.txt";
		new File(pathFile).delete();
		myFileManager = new MyFileManager(pathFile);
	}

	public void testAll() {
		
		String lineToAdd = "Said";
		myFileManager.append(lineToAdd);
		
		assertEquals(myFileManager.size(), 4);
		
		assertEquals(myFileManager.list().get(0), lineToAdd);
		
		myFileManager.remove(lineToAdd);
		assertEquals(myFileManager.size(), 0);
		
		String lineToAddTwo = "Nathan";
		myFileManager.append(lineToAddTwo);
		myFileManager.append(lineToAdd);
		myFileManager.append(lineToAddTwo);
		myFileManager.remove(lineToAddTwo);
		
		assertFalse(myFileManager.list().contains(lineToAddTwo));

		String lineToRemove = "Bob";
		try {
			myFileManager.remove(lineToRemove);
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		String lineToRemoveNull = null;
		try {
			myFileManager.remove(lineToRemoveNull);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
}