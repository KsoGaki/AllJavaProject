package main;

import java.util.ArrayList;
import java.util.List;

public class ExerciceTestUnitaireFive {

	private List<String> listString = new ArrayList<>();

	public void appendList(List<String> list) {
		for (String string : list) {
			if(string == null) {
				try {
					throw new Exception("appendList Error NULL");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				listString.add(string);
			}
		}

	}

	public void appendListOnlyIfNotPresent(List<String> list) {
		for (String string : list) {
			if(string == null) {
				try {
					throw new Exception("appendListOnlyIfNotPresent Error NULL");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				if(!listString.contains(string)) {
					listString.add(string);
				}
			}
		}
	}

	public void removefromList(List<String> list) {
		for (String string : list) {
			if(string == null) {
				try {
					throw new Exception("removefromList Error NULL");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				if(listString.contains(string)) {
					listString.remove(string);
				}
				else {
					try {
						throw new Exception("removefromList Error NOT INCLUDE");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public List<String> getListString() {
		return listString;
	}

	public void setListString(List<String> listString) {
		this.listString = listString;
	}
	
	public ExerciceTestUnitaireFive() {}

}
