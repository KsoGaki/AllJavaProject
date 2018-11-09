package main;

import java.util.ArrayList;
import java.util.List;

public class ClassList {

	public List<String> CreateList(int nombreDeString) {

		if(nombreDeString < 0 ) {
			return null;
		}

		List<String> listString = new ArrayList<>();
		for(int i = 0; i < nombreDeString; i++) {
			listString.add("Autre chose");
		}

		return listString;
	}

	public List<String> CreateList(int nombreDeString, String prefix) {

		if(nombreDeString < 0) {
			return null;
		}

		if(prefix == null || prefix.length() < 1) {
			List<String> listString = new ArrayList<>();
			for(int i = 0; i < nombreDeString; i++) {
				listString.add("Autre chose");
			}
			return listString;
		}

		List<String> listString = new ArrayList<>();
		for(int i = 0; i < nombreDeString; i++) {
			listString.add(prefix + "Autre chose");
		}
		return listString;
	}

}
