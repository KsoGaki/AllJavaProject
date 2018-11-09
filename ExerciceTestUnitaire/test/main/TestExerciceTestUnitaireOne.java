package main;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireOne extends TestCase {

	public void testPurge() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Sa�d");
		exerciceTestUnitaireOne.purge();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"");

		exerciceTestUnitaireOne.setMyString(null);
		exerciceTestUnitaireOne.purge();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"");
	}

	public void testAppend() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Sa�d");
		exerciceTestUnitaireOne.append(" Oubram");
		assertEquals(exerciceTestUnitaireOne.getMyString(),"Sa�d Oubram");

		exerciceTestUnitaireOne.setMyString("Sa�d");
		try {
			exerciceTestUnitaireOne.append(null);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	public void testDecrement() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Sa�d");
		exerciceTestUnitaireOne.decrement();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"Sa�");

		exerciceTestUnitaireOne.setMyString("");
		try {
			exerciceTestUnitaireOne.decrement();
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

}
