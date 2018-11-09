package main;

import java.io.File;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireFour extends TestCase {

	String filePath = "file/file.txt";
	ExerciceTestUnitaireFour exerciceTestUnitaireFour = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		exerciceTestUnitaireFour = new ExerciceTestUnitaireFour();
	}

	public void testWriteFile() {
		exerciceTestUnitaireFour.writeFile(filePath, "AAA");
		exerciceTestUnitaireFour.writeFile(filePath, "BBB");
		exerciceTestUnitaireFour.writeFile(filePath, "CCC");
		assertEquals(new File(filePath).length(), 9);
		
		try {
			exerciceTestUnitaireFour.writeFile(filePath, null);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	public void testReadFile() {
		assertEquals(exerciceTestUnitaireFour.readFile(filePath).length(), 9);
		assertEquals(exerciceTestUnitaireFour.readFile(filePath), "AAABBBCCC");
	}

	public void testRemoveFile() {
		exerciceTestUnitaireFour.removeFile(filePath);
		assertEquals(new File(filePath).length(), 0);
	}

}
