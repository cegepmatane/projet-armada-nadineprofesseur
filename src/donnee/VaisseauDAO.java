package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Vaisseau;

public class VaisseauDAO {
	
	public Vaisseau detaillerVaisseau(int id)
	{
		return null;
	}
	
	public List<Vaisseau> listerVaisseauxParEscadron(int idEscadron)
	{
		Logger.logMsg(Logger.INFO, "VaisseauDAO.listerVaisseauxParEscadron()");
		List<Vaisseau> vaisseaux = new ArrayList<Vaisseau>();
		
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			Statement requete = connexion.createStatement();
			ResultSet curseur = requete.executeQuery("SELECT * FROM vaisseau WHERE id_escadron = " + idEscadron);
			
			while(curseur.next())
			{
				int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				double valeur = curseur.getDouble("valeur");
				double vitesse = curseur.getDouble("vitesse");
				
				//System.out.println(nom);
				Vaisseau vaisseau = new Vaisseau();
				vaisseau.setNom(nom);
				vaisseau.setValeur(valeur);
				vaisseau.setVitesse(vitesse);
				vaisseau.setIdEscadron(idEscadron);
				vaisseau.setId(id);
				
				vaisseaux.add(vaisseau);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		return vaisseaux;
	}
	
	public void ajouterVaisseau(Vaisseau vaisseau)
	{
		
		//String SQL_AJOUTER_VAISSEAU = "INSERT INTO vaisseau(nom, id_escadron) VALUES('test', 2)";
		String SQL_AJOUTER_VAISSEAU = "INSERT INTO vaisseau(nom, valeur, vitesse, id_escadron) VALUES('"+vaisseau.getNom()+"', "+ vaisseau.getValeur()+" , "+vaisseau.getVitesse()+" ,"+vaisseau.getIdEscadron()+")";
		//String SQL_AJOUTER_VAISSEAU = "INSERT INTO vaisseau(nom, id_escadron) VALUES(?, ?)";
		Logger.logMsg(Logger.INFO, "VaisseauDAO.ajouterVaisseau()");
		try {
			Connection connexion = BaseDeDonnees.getInstance().getConnexion();
			Statement requete = connexion.createStatement();
			requete.execute(SQL_AJOUTER_VAISSEAU);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void editerVaisseau(Vaisseau vaisseau) {
		Logger.logMsg(Logger.INFO, "VaisseauDAO.editerVaisseau()");
	}

}
