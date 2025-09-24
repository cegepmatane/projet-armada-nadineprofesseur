package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.VaisseauDAO;
import javafx.scene.control.TextField;
import donnee.EscadronDAO;
import modele.Vaisseau;
import modele.Escadron;
import vue.VueEditerVaisseau;
import vue.VueEscadron;

public class ControleurEscadron extends Controleur
{
	protected EscadronDAO escadronDAO = new EscadronDAO();
	protected VaisseauDAO vaisseauDAO = new VaisseauDAO();
	
	protected Escadron escadron = null;
	protected List<Vaisseau> vaisseaux = null;
	
	public void initialiser()
	{
		EscadronDAO escadronDao = new EscadronDAO();
		escadron = escadronDao.detaillerEscadron(2);
		System.out.println("Escadron : " + escadron.getNom());
		VueEscadron.getInstance().afficherEscadron(escadron);
	
		VaisseauDAO vaisseauDao = new VaisseauDAO();
		vaisseaux = vaisseauDao.listerVaisseauxParEscadron(2);
		for(Vaisseau vaisseau:vaisseaux)
		{
			System.out.println("Vaisseau : " + vaisseau.getNom() + " (" + vaisseau.getVitesse() + ")");
		}
		VueEscadron.getInstance().afficherVaisseaux(vaisseaux);
	
	}
	
	
	public ControleurEscadron()
	{
		Logger.logMsg(Logger.INFO, "new ControleurEscadron()");
	}
	
	// NOTIFICATION = ACTION UTILISATEUR
	
	public void reagirClicEscadron(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurEscadron.reagirClicEscadron("+id+")");		
	}	
	
	public void reagirClicAjouterVaisseau()
	{
		Logger.logMsg(Logger.INFO, "ControleurEscadron.reagirClicAjouterVaisseau()");
	}
	
	public void reagirClicEnregistrerAjoutVaisseau()
	{
		Logger.logMsg(Logger.INFO, "ControleurEscadron.reagirClicEnregistrerAjoutVaisseau()");
	}
	
	protected Vaisseau vaisseau;
	public void reagirClicEditerVaisseau(int id)
	{
		Logger.logMsg(Logger.INFO, "ControleurEscadron.reagirClicEditerVaisseau()");
	}
	public void reagirClicEnregistrerEditerVaisseau()
	{
		Logger.logMsg(Logger.INFO, "ControleurEscadron.reagirClicEnregistrerEditerVaisseau()");
	}

	public Vaisseau lireVaisseau(VueEditerVaisseau vueEditerVaisseau) 
	{
		Logger.logMsg(Logger.INFO, "VueEditerVaisseau.lireBateau()");
		Vaisseau bateau = new Vaisseau();
		TextField champsNom = (TextField)vueEditerVaisseau.lookup("#nom-bateau");
		bateau.setNom(champsNom.getText());		
		return bateau;
	}
}
