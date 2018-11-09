package main;

public class Famille extends Person {

	private Famille[] enfants = new Famille[10];
	private int nbenfant;

	public void giveBirth(String newname) {
		enfants[nbenfant] = new Famille(this.getId(),newname, this.getLname(), 0);
		nbenfant++;
	}

	public Famille[] getEnfants() {
		return enfants;
	}

	public void setEnfants(Famille[] enfants) {
		this.enfants = enfants;
	}


	public void getEverything(int x, String indent) {
		boolean isTrue  = true; 
		if(x == 0) {
			System.out.print(getId() + " - " +getFname() + " " + getLname() + " " + getAge() + "ans\n");
			x++;
		}
		for(int i = 0; i < nbenfant ; i++) {
			if(getEnfants()[i] != null) {
				if(i == 0) {
					System.out.print(indent + "\t" + getEnfants()[i].getId() + " - " + getEnfants()[i].getFname() + " " + getEnfants()[i].getLname() + " " + getEnfants()[i].getAge() + "ans\n");
				}
				else {
					System.out.print(indent + getEnfants()[i].getId() + " - " + getEnfants()[i].getFname() + " " + getEnfants()[i].getLname() + " " + getEnfants()[i].getAge() + "ans\n");

				}
				if (i == 0 && isTrue) {
					indent += "\t";
					isTrue  = false; 
				}	
				getEnfants()[i].getEverything(x, indent);
			}
			else if (nbenfant == i && indent.length() >= 4 && getEnfants()[i] == null) {
				indent = indent.substring(indent.length()-2, indent.length());
				getEnfants()[i].getEverything(x, indent);
			}
			else if (nbenfant == i) {
				break;
			}
			else {
				System.out.println( indent + getEnfants()[i].getId() + " - " +getEnfants()[i].getFname() + " " + getEnfants()[i].getLname() + " " + getEnfants()[i].getAge() + "ans");
				break;
			}
		}
	}


	public int getNbenfant() {
		return nbenfant;
	}

	public void setNbenfant(int nbenfant) {
		this.nbenfant = nbenfant;
	}

	public Famille(int id, String fname, String lname, int age) {
		super(id,fname, lname, age);
		// TODO Auto-generated constructor stub
	}
}
