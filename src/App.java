
import architecture.Controleur;
import architecture.Fenetre;
import vue.VueArmada;
import vue.VueEscadron;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueArmada.class);
		//Controleur.choisirVuePrincipale(VueEscadron.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
