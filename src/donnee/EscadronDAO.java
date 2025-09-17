package donnee;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Escadron;

public class EscadronDAO {

	public List<Escadron> listerEscadrons()
	{
		Logger.logMsg(Logger.INFO, "EscadronDAO.listerEscadrons()");
		
		List<Escadron> escadrons = new ArrayList<Escadron>();
		
		
		return escadrons;
	}
	
	public Escadron detaillerEscadron(int id)
	{
		Logger.logMsg(Logger.INFO, "EscadronDAO.detaillerEscadron()");
		Escadron escadron = new Escadron();
		
		
		return escadron;
	}
}