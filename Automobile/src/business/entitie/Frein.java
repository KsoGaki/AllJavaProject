package business.entitie;

public class Frein {

	private long id;
	private String marque;
	private String modele;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public Frein(long id, String marque, String modele) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
	}
	
	public Frein() {}
	
}
