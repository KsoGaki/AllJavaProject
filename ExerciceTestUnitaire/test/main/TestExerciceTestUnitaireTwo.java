package main;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireTwo extends TestCase {

	ExerciceTestUnitaireTwo exerciceTestUnitaireTwo = new ExerciceTestUnitaireTwo();

	public void testAbs() {
		double doubleToAbs = - 1;
		doubleToAbs = exerciceTestUnitaireTwo.abs(doubleToAbs);
		assertEquals(doubleToAbs, 1.0);

		doubleToAbs = 2;
		doubleToAbs = exerciceTestUnitaireTwo.abs(doubleToAbs);
		assertEquals(doubleToAbs, 2.0);
	}

	public void testSqrt() {
		int intToSqrt = 9;
		double returnDouble;
		returnDouble = exerciceTestUnitaireTwo.sqrt(intToSqrt);
		assertEquals(returnDouble, 3.0);

		intToSqrt = - 9;
		returnDouble = exerciceTestUnitaireTwo.sqrt(intToSqrt);
		assertTrue(Double.isNaN(returnDouble));
	}

	public void testMin() {
		int intReturn;
		int intToMinFirst = 5;
		int intToMinSecond = 8;
		intReturn = exerciceTestUnitaireTwo.min(intToMinFirst,intToMinSecond);
		assertEquals(intReturn, 5);

		intToMinFirst = 8;
		intToMinSecond = 5;
		intReturn = exerciceTestUnitaireTwo.min(intToMinFirst,intToMinSecond);
		assertEquals(intReturn, 5);

	}

	public void testRandom() {
		double intReturn;
		int intToRandom = 5;
		boolean isOkay = false;
		intReturn = exerciceTestUnitaireTwo.random(intToRandom);
		if(0 < intReturn && intReturn < intToRandom) {
			isOkay = true;
		}
		assertTrue(isOkay);

		intToRandom = -1;
		try {
			intReturn = exerciceTestUnitaireTwo.random(intToRandom);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

}
