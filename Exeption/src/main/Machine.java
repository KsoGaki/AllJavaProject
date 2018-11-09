package main;

public class Machine {
	
	private SubSystem subSystem = new SubSystem(); 
	
	public void init() throws Exception{
		throw new InitException("Init Error");
	}
	public void process() throws Exception{
		throw new ProcessException("Process Error");
	}
	
	public void config() throws SubSystemConfigException, MachineConfigException{
		try {
			subSystem.config();
		} catch(SubSystemConfigException e) {
			System.out.println("ERROR MachineConfig");
		}
	}
}