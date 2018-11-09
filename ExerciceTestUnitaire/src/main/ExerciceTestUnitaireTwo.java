package main;

import java.util.Random;

public class ExerciceTestUnitaireTwo {

	public double abs(double doubleToAbs) {
		return Math.abs(doubleToAbs);
	}

	public double sqrt(int intToSqrt) {
		return Math.sqrt(intToSqrt);
	}

	public int min(int firstInt, int secondInt) {
		return Math.min(firstInt, secondInt);
	}

	public double random(int intToRandom) {
		if(intToRandom < 1) {
			try {
				throw new Exception("must be positive");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Random r = new Random();
		int result = r.nextInt(intToRandom-0) + 0;
		return result;
	}

}