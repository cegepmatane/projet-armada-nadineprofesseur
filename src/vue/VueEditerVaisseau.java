package vue;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurEscadron;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Vaisseau;
import modele.Escadron;

public class VueEditerVaisseau extends Vue
{
	public ControleurEscadron controleur;
	
	protected static VueEditerVaisseau instance;
	public static VueEditerVaisseau getInstance() {if(null == instance) instance = new VueEditerVaisseau(); return instance;};
	private VueEditerVaisseau() {
		super("editer-vaisseau.fxml", VueEditerVaisseau.class,995,617);
		Logger.logMsg(Logger.INFO, "new VueEditerVaisseau()");
	}
	
	public void activerControles()
	{
		super.activerControles();
		Button actionEnregistrer = (Button)lookup("#action-enregistrer-vaisseau");
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur enregistrer vaisseau");
				controleur.reagirClicEnregistrerEditerVaisseau();
			}});
	}	
	
	public void afficherVaisseau(Vaisseau vaisseau)
	{
		Logger.logMsg(Logger.INFO, "VueEditerVaisseau.afficherVaisseau()");
		TextField champsNom = (TextField)lookup("#nom-vaisseau");
		champsNom.setText(vaisseau.getNom());
	}
	
	public void afficherEscadron(Escadron flotte)
	{
		Logger.logMsg(Logger.INFO, "VueEditerVaisseau.afficherEscadron()");
		Label vueNomEscadron = (Label)lookup("#nom-escadron");
		vueNomEscadron.setText(flotte.getNom());
	}
	
	public Vaisseau lireVaisseau() 
	{
		Logger.logMsg(Logger.INFO, "VueAjouterVaisseau.lireVaisseau()");
		Vaisseau vaisseau = new Vaisseau();
		TextField champsNom = (TextField)lookup("#nom-vaisseau");
		vaisseau.setNom(champsNom.getText());
		
		return vaisseau;
	}

}
