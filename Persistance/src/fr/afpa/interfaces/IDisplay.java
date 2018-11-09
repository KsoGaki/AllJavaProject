package fr.afpa.interfaces;

import java.io.IOException;

public interface IDisplay {
	
	public IDisplay getSplitData(String data) throws IOException;
	
	public String updateFromId(int id, String line) throws IOException;

}
