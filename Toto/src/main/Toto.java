package main;

public class Toto<T> {
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Toto(T value) {
		super();
		this.value = null;
	}
	
}
