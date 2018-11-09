package main;

public class Duo<F,S> {
	private F fvalue;
	private S svalue;
	
	public F getFvalue() {
		return fvalue;
	}
	
	public void setFvalue(F fvalue) {
		this.fvalue = fvalue;
	}
	
	public S getSvalue() {
		return svalue;
	}
	
	public void setSvalue(S svalue) {
		this.svalue = svalue;
	}

	public Duo(F fvalue, S svalue) {
		super();
		this.fvalue = fvalue;
		this.svalue = svalue;
	}
	
	
}
