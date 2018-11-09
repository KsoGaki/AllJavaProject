package main;

public class File {

	private String path;	
	
	
	public void open() throws OpenException{
		throw new OpenException("ERROR OpenException");
	}
	
	public void read() throws ReadException{
		throw new ReadException("ERROR ReadException");
	}
	
	public void close() throws CloseException{
		throw new CloseException("ERROR CloseException");
	}
	
	public void write() throws WriteException{
		throw new WriteException("ERROR WriteException");	
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public File(String path) {
		super();
		this.path = path;
	}
	

}
