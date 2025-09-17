package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Escadron;

public class EscadronDAO {

	public List<Escadron> listerEscadrons()
	{
		Logger.logMsg(Logger.INFO, "EscadronDAO.listerEscadrons()");
		List<Escadron> escadrons = new ArrayList<Escadron>();
		
		try {
			Connection connexion = 	BaseDeDonnees.getInstance().getConnexion();
			Statement requete = connexion.createStatement();
			ResultSet curseur = requete.executeQuery("SELECT * FROM escadron");
			
			while(curseur.next())
			{
				String nom = curseur.getString("nom");
				//System.out.println(nom);
				
				Escadron escadron = new Escadron(nom);
				escadrons.add(escadron);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return escadrons;
	}
	
	public Escadron detaillerEscadron(int id)
	{
		Logger.logMsg(Logger.INFO, "EscadronDAO.detaillerEscadron()");
		Escadron escadron = new Escadron();
		
		
		return escadron;
	}
}