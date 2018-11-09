package main;

import junit.framework.TestCase;

public class TestExerciceTestUnitaireOne extends TestCase {

	public void testPurge() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Saïd");
		exerciceTestUnitaireOne.purge();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"");

		exerciceTestUnitaireOne.setMyString(null);
		exerciceTestUnitaireOne.purge();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"");
	}

	public void testAppend() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Saïd");
		exerciceTestUnitaireOne.append(" Oubram");
		assertEquals(exerciceTestUnitaireOne.getMyString(),"Saïd Oubram");

		exerciceTestUnitaireOne.setMyString("Saïd");
		try {
			exerciceTestUnitaireOne.append(null);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	public void testDecrement() {
		ExerciceTestUnitaireOne exerciceTestUnitaireOne = new ExerciceTestUnitaireOne();

		exerciceTestUnitaireOne.setMyString("Saïd");
		exerciceTestUnitaireOne.decrement();
		assertEquals(exerciceTestUnitaireOne.getMyString(),"Saï");

		exerciceTestUnitaireOne.setMyString("");
		try {
			exerciceTestUnitaireOne.decrement();
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

}
