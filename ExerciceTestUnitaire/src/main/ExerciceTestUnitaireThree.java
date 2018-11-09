package main;

import java.util.ArrayList;
import java.util.List;

public class ExerciceTestUnitaireThree {

	public List<Integer> count(int nbValue) {
		if(nbValue < 0) {
			return null;
		}
		List<Integer> listInteger = new ArrayList<>();
		for (int i = 0; i <= nbValue; i++) {
			listInteger.add(i);
		}
		return listInteger;
	}
	
	public String cast(int intToString) {
		return intToString + "";
	}
	
	public int uncast(String stringToInt) {
		return Integer.parseInt(stringToInt);
	}
	
}
