package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurArmada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Escadron;

public class VueArmada extends Vue {

	protected ControleurArmada controleur;
	protected static VueArmada instance = null; 
	public static VueArmada getInstance() {if(null==instance)instance = new VueArmada();return VueArmada.instance;}; 
	
	private VueArmada() 
	{
		super("armada.fxml", VueArmada.class,995,617); 
		super.controleur = this.controleur = new ControleurArmada();
		Logger.logMsg(Logger.INFO, "new VueArmada()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherEscadrons(List<Escadron> escadrons)
	{
		Logger.logMsg(Logger.INFO, "VueArmada.afficherEscadrons()");
		VBox vueEscadrons = (VBox)lookup("#liste-escadrons");
		System.out.println(vueEscadrons);
		
		vueEscadrons.getChildren().clear();
		
		for(Escadron escadron:escadrons)
		{
			Logger.logMsg(Logger.INFO,"Escadron recue par la vue " + escadron.getNom());
									
			HBox vueNouvelEscadron = new HBox();
			vueNouvelEscadron.getStyleClass().add("escadron");
			vueNouvelEscadron.setPadding(new Insets(15, 12, 15, 12));
			vueNouvelEscadron.setSpacing(10);
			
			ImageView vueIcone = new ImageView();
			vueIcone.setImage(new Image("vue/decoration/petit-vaisseau-blanc.png"));
			vueIcone.setFitHeight(40);
			vueIcone.setFitWidth( 40 );
			vueNouvelEscadron.getChildren().add(vueIcone);
			
			Label vueTitre = new Label(escadron.getNom());
			vueTitre.getStyleClass().add("titre");
			vueTitre.setStyle("-fx-font: 24 arial;");
			vueNouvelEscadron.getChildren().add(vueTitre);
			
			Button action = new Button("Consulter");
			action.setId(escadron.getId()+"");
			action.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Button source = (Button)e.getSource();
					Logger.logMsg(Logger.INFO, "Clic sur un escadron " + source.getId());		
					controleur.reagirClicEscadron(Integer.parseInt(source.getId()));
				}});			
			vueNouvelEscadron.getChildren().add(action);
			
			vueEscadrons.getChildren().add((vueNouvelEscadron));
		}		
	}
	
	public void afficherNombreEscadrons(int nombreEscadrons)
	{
		Logger.logMsg(Logger.INFO, "VueArmada.afficherNombreEscadrons()");
		
		Label vueNombreEscadrons = (Label)lookup("#nombre-escadrons");
		vueNombreEscadrons.setText(nombreEscadrons + " ESCADRONS");
		
	}
	
}
