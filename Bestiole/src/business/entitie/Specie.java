package business.entitie;

public class Specie {
	
	private long id;
	private String commonName;
	private String latinName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	
	@Override
	public String toString() {
		return "\n\tid: " + id 
			 + "\n\tcommonName: " + commonName 
			 + "\n\tlatinName: " + latinName;
	}
	
	public String toStringBis() {
		return "\n\t\tid: " + id 
			 + "\n\t\tcommonName: " + commonName 
			 + "\n\t\tlatinName: " + latinName;
	}
	
	public Specie() {}
	
	public Specie(long id, String commonName, String latinName) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.latinName = latinName;
	}
}
