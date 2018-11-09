package main;

import java.util.Set;
import java.util.TreeSet;

public class SetDevice {

	private Set<String> setString = new TreeSet<>();

	public void add(String stringToAdd) {
		if(stringToAdd == null) {
			try {
				throw new Exception("VALUE NULL");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!(setString.contains(stringToAdd))) {

			setString.add(stringToAdd);
		}
		else {
			try {
				throw new Exception("VALUE ALREADY THERE");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Set<String> list() {
		return setString;
	}

	public void remove(String stringToRemove) {
		if(stringToRemove == null) {
			try {
				throw new Exception("VALUE NULL");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(setString.contains(stringToRemove)) {
			setString.remove(stringToRemove);
		}
		else {
			try {
				throw new Exception("VALUE NOT FOUND");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(String oldValue, String newValue){
		if(oldValue == null || newValue == null) {
			try {
				throw new Exception("VALUE NULL");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(setString.contains(oldValue)) {
			if(!(setString.contains(newValue))) {
				setString.remove(oldValue);
				setString.add(newValue);
			}
			else {
				try {
					throw new Exception("VALUE ALREADY THERE");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				throw new Exception("VALUE NOT FOUND");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
