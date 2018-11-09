package main;


public class Main {

	public static Class<?> klass;

	public static Class<?> klassBis;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			klass = Class.forName("packone.Person");
			klassBis = Class.forName("packtwo.Person");
			packone.Person person =  (packone.Person) klass.newInstance();
			packtwo.Person personBis = (packtwo.Person) klassBis.newInstance();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
