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

public class VueAjouterVaisseau extends Vue
{
	public ControleurEscadron controleur;
	
	protected static VueAjouterVaisseau instance;
	public static VueAjouterVaisseau getInstance() {if(null == instance) instance = new VueAjouterVaisseau(); return instance;};
	private VueAjouterVaisseau() {
		super("ajouter-vaisseau.fxml", VueAjouterVaisseau.class,995,617);
		Logger.logMsg(Logger.INFO, "new VueAjouterVaisseau()");
		super.controleur = this.controleur = new ControleurEscadron();
	}
	
	public void activerControles()
	{
		super.activerControles();
		Button actionEnregistrer = (Button)lookup("#action-enregistrer-vaisseau");
		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Logger.logMsg(Logger.INFO, "Clic sur enregistrer vaisseau");
				controleur.reagirClicEnregistrerAjoutVaisseau();
			}});
	}	
	
	public Vaisseau lireVaisseau() 
	{
		Logger.logMsg(Logger.INFO, "VueEditerVaisseau.lireVaisseau()");
		Vaisseau vaisseau = new Vaisseau();
		TextField champsNom = (TextField)lookup("#nom-vaisseau");
		vaisseau.setNom(champsNom.getText());
		TextField champsVitesse = (TextField)lookup("#vitesse-vaisseau");
		String vitesseEnTexte = champsVitesse.getText();
		double vitesse = Double.parseDouble(vitesseEnTexte);
		vaisseau.setVitesse(vitesse);
		TextField champsValeur = (TextField)lookup("#valeur-vaisseau");
		vaisseau.setValeur(Double.parseDouble(champsValeur.getText()));
		
		return vaisseau;
	}
	
	public void afficherEscadron(Escadron escadron)
	{
		Logger.logMsg(Logger.INFO, "VueAjouterVaisseau.afficherEscadron()");
		Label vueNomEscadron = (Label)lookup("#nom-escadron");
		vueNomEscadron.setText(escadron.getNom());
	}
	

}
