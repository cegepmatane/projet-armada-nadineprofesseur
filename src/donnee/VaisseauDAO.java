package donnee;

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
