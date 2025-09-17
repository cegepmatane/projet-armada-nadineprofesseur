package modele;

public class Escadron {
	
	protected int id;
	protected String nom;

	public Escadron() {
	}

	public Escadron(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
