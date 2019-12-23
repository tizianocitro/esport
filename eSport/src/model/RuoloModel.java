package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import beans.RuoloBean;
import beans.UtenteBean;

public class RuoloModel {
	static Logger log=Logger.getLogger("RuoloModelDebugger");

	public RuoloModel() {
		
	}

	/**
	 * Permette di salvare un ruolo
	 * @param ruolo
	 */
	public void doSave(RuoloBean ruolo) {
		
	}
	
	/**
	 * Permette di ottenere i ruoli assegnati ad un utente
	 * @param user
	 * @return ruoli
	 */
	public Map<String, RuoloBean> doRetrieveByUtente(UtenteBean utente){
		LinkedHashMap<String, RuoloBean> ruoli=new LinkedHashMap<String, RuoloBean>();

		return ruoli;
	}
}
