package business.entitie;

public class Animal {

	private long id;
	private String name;
	private int sex;
	private String coatColor;
	private Specie specie;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCoatColor() {
		return coatColor;
	}
	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}
	public Specie getSpecie() {
		return specie;
	}
	public void setSpecie(Specie specie) {
		this.specie = specie;
	}
	
	@Override
	public String toString() {
		return "\n\tid: " + id 
			 + "\n\tname: " + name 
			 + "\n\tsex: " + sex 
			 + "\n\tcoatColor: " + coatColor 
			 + "\n\tspecie: " + specie.toStringBis();
	}
	
	public Animal() {}
	
	public Animal(long id, String name, int sex, String coatColor, Specie specie) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.specie = specie;
	}
	
}
