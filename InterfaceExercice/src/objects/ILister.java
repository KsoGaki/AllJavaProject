package objects;

import java.io.IOException;
import java.util.List;

public interface ILister {
	public List<String> list() throws IOException;
	
	public void display();
}
