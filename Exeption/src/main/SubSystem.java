package main;

public class SubSystem {
	public void config() throws SubSystemConfigException {
		throw new SubSystemConfigException("SubSystem Error"); 
	}
}
