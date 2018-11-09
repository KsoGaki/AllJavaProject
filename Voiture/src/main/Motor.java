package main;

public class Motor {
	private boolean isStarted = false;
	public void start() {
		if(isStarted) {
			isStarted = false;
		}
		else {
			isStarted = true;
		}
	}

	public boolean isStarted() {
		return isStarted;
	}
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
}
