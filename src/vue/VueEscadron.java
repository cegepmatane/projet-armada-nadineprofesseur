package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurEscadron;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Vaisseau;
import modele.Escadron;

public class VueEscadron extends Vue
{
	protected static VueEscadron instance = null;
	public static VueEscadron getInstance() 
	{
		if(null == instance) instance = new VueEscadron();
		return instance;
	}
	
	public ControleurEscadron controleur = null;
	public ControleurEscadron getControleur() {return this.controleur;}
	
	private VueEscadron() {
		super("escadron.fxml", VueEscadron.class,995,617);
		super.controleur = this.controleur = new ControleurEscadron();
		Logger.logMsg(Logger.INFO, "new VueEscadron()");
	}

	public void activerControles()
	{
		super.activerControles();
		Button actionAjouterBateau = (Button)lookup("#action-ajouter-vaisseau");
		
		actionAjouterBateau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controleur.reagirClicAjouterVaisseau();
			}});
	}	

	public void afficherEscadron(Escadron escadron)
	{
		Logger.logMsg(Logger.INFO, "VueEscadron.afficherEscadron()");
		Label vueTitreEscadron = (Label)lookup("#escadron-titre");
		vueTitreEscadron.setText(escadron.getNom());
	}
	
	public void afficherVaisseaux(List<Vaisseau> vaisseaux) 
	{
		Logger.logMsg(Logger.INFO, "VueEscadron.afficherVaisseaux()");
		VBox vueVaisseaux = (VBox)lookup("#liste-vaisseaux");
		vueVaisseaux.getChildren().clear();
		Button action;
		
		for(Vaisseau vaisseau:vaisseaux)
		{			
			Logger.logMsg(Logger.INFO, "Vaisseau : " + vaisseau.getNom());
			HBox vueVaisseau = new HBox();
			vueVaisseau.getStyleClass().add("vaisseau");
			vueVaisseau.setPadding(new Insets(15, 12, 15, 12));
			vueVaisseau.setSpacing(10);
			
			Label vueTitre = new Label(vaisseau.getNom());
			vueTitre.getStyleClass().add("titre");
			vueTitre.setStyle("-fx-font: 24 arial;");
			vueVaisseau.getChildren().add(vueTitre);
			
			action = new Button("�diter");
			action.setId(vaisseau.getId()+"");
			action.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Button source = (Button)e.getSource();
					Logger.logMsg(Logger.INFO, "Clic sur le vaisseau " + source.getId());		
					controleur.reagirClicEditerVaisseau(Integer.parseInt(source.getId()));
				}});			
			vueVaisseau.getChildren().add(action);
			
			vueVaisseaux.getChildren().add(vueVaisseau);
		}
	}

	
	
}
