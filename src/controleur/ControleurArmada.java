package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Escadron;
import vue.VueArmada;
import vue.VueEscadron;

public class ControleurArmada extends Controleur{

	public ControleurArmada()
	{
		Logger.logMsg(Logger.INFO, "new ControleurArmada()");
	}

	public void initialiser()
	{
		Logger.logMsg(Logger.INFO, "ControleurArmada.initialiser()");
		
		List<Escadron> escadrons = new ArrayList<Escadron>();
		Escadron escadron;
		
		// Ajout d'une nouvelle flotte
		escadron = new Escadron();
		escadron.setNom("BattleStar Galactica");
		escadrons.add(escadron);
		
		escadron = new Escadron();
		escadron.setNom("Pegasus");
		escadrons.add(escadron);		

		VueArmada.getInstance().afficherEscadrons(escadrons);
	}	

	// NOTIFICATION = ACTION UTILISATEUR
	
	public void reagirClicEscadron(int id)
	{		
		Logger.logMsg(Logger.INFO, "ControleurArmada.reagirClicEscadron("+id+")");
		VueEscadron.getInstance().getControleur().reagirClicEscadron(id);
	}
}
