package main;

public class Main {
	public static void main(String[] args) throws Exception {
		Machine machine = new Machine();
		try {
			machine.config();
		}
		catch(MachineConfigException e) {
			e.printStackTrace();
		}
	}

}
