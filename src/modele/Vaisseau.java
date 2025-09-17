package modele;

public class Vaisseau {
	
	protected int id;
	protected String nom;
	protected double valeur;
	protected double vitesse;
	protected int idEscadron; // a remplacer par reference vers l'objet de escadron
	
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
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	public int getIdEscadron() {
		return idEscadron;
	}
	public void setIdEscadron(int idEscadron) {
		this.idEscadron = idEscadron;
	}

}
