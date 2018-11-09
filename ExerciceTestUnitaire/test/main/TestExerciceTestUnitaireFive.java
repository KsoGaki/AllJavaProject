package main;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireFive extends TestCase {

	ExerciceTestUnitaireFive exerciceTestUnitaireFive = null;
	List<String> listString = null;
	int nbString = 0;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		exerciceTestUnitaireFive = new ExerciceTestUnitaireFive();
		listString = new ArrayList<>();
		listString.add("AAA");
		listString.add("BBB");
		listString.add("CCC");
		exerciceTestUnitaireFive.getListString().add("BBB");
		exerciceTestUnitaireFive.getListString().add("EEE");
		nbString = 2;
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		listString.clear();
		exerciceTestUnitaireFive.getListString().clear();
	}

	public void testAppendList() {
		exerciceTestUnitaireFive.appendList(listString);
		assertEquals(exerciceTestUnitaireFive.getListString().size(), nbString + 3);
		assertTrue(exerciceTestUnitaireFive.getListString().contains("AAA"));
	}

	public void testAppendListOnlyIfNotPresent() {
		exerciceTestUnitaireFive.appendListOnlyIfNotPresent(listString);
		assertEquals(exerciceTestUnitaireFive.getListString().size(), nbString + 2);
	}

	public void testRemovefromList() {
		try {
			exerciceTestUnitaireFive.removefromList(listString);
		} catch (Exception e) {
			assertNotNull(e);
		}
		assertEquals(exerciceTestUnitaireFive.getListString().size(), 1);
	}
}
