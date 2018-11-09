package business.entitie;

public class Automobile {
	
	private long id;
	private String marque;
	private String modele;
	private Moteur moteur;
	private Frein frein;
	
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
	public Moteur getMoteur() {
		return moteur;
	}
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	public Frein getFrein() {
		return frein;
	}
	public void setFrein(Frein frein) {
		this.frein = frein;
	}

	public Automobile(long id, String marque, String modele, Moteur moteur, Frein frein) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.moteur = moteur;
		this.frein = frein;
	}
	
	public Automobile() {}
	

}
