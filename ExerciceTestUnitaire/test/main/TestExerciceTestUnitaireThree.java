package main;

import java.util.List;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireThree extends TestCase {

	public void testCount() {
		ExerciceTestUnitaireThree exerciceTestUnitaireThree = new ExerciceTestUnitaireThree();

		int nbValue = 5;
		List<Integer> listInteger = exerciceTestUnitaireThree.count(nbValue);
		assertEquals(listInteger.size(), nbValue + 1 );
		
		nbValue = -1;
		listInteger = exerciceTestUnitaireThree.count(nbValue);
		assertNull(listInteger);
		
		nbValue = 0;
		listInteger = exerciceTestUnitaireThree.count(nbValue);
		assertEquals(listInteger.size(), nbValue + 1 );
	}
	
	public void testCast() {
		ExerciceTestUnitaireThree exerciceTestUnitaireThree = new ExerciceTestUnitaireThree();
		
		int intToString = 3;
		String result = exerciceTestUnitaireThree.cast(intToString);
		assertEquals(result, 3 + "");
	}
	
	public void testUncast() {
		ExerciceTestUnitaireThree exerciceTestUnitaireThree = new ExerciceTestUnitaireThree();
		
		String stringToInt = "3";
		int result = exerciceTestUnitaireThree.uncast(stringToInt);
		assertEquals(result, 3);
		
		stringToInt = "p";
		try {
			result = exerciceTestUnitaireThree.uncast(stringToInt);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
}
