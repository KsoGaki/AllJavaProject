package objects;

import java.util.ArrayList;
import java.util.List;

public class MemLister implements ILister {

	@Override
	public List<String> list() {
		List<String> listString = new ArrayList<>(); 
		listString.add("Et quoniam inedia gravi adflictabantur, locum");
		listString.add("Nec vox accusatoris ulla licet subditicii in his");
		listString.add("Fieri, inquam, Triari, nullo pacto potest, ut non");
		listString.add("Nam sole orto magnitudine angusti gurgitis sed");
		listString.add("Per hoc minui studium suum existimans Paulus, ut");
		return listString;
	}

	@Override
	public void display() {
		System.out.println("MemLister");
	}

}
