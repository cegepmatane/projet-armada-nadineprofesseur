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
				String nom = curseur.getString("nom");
				System.out.println(nom);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		return vaisseaux;
	}
	
	public void ajouterVaisseau(Vaisseau vaisseau)
	{
		Logger.logMsg(Logger.INFO, "VaisseauDAO.ajouterVaisseau()");
	}

	public void editerVaisseau(Vaisseau vaisseau) {
		Logger.logMsg(Logger.INFO, "VaisseauDAO.editerVaisseau()");
	}

}
