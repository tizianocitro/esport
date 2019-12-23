package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.IndirizzoBean;
import beans.UtenteBean;

public class IndirizzoModel {
	static Logger log=Logger.getLogger("IndirizzoModelDebugger");

	public IndirizzoModel() {
		
	}

	/**
	 * Permette di salvare un indirizzo
	 * @param indirizzo
	 */
	public void doSave(IndirizzoBean indirizzo) {
		
	}
	
	/**
	 * Permette di ottenere gli indirizzi aggiunti da un utente
	 * @param user
	 * @return indirizzo
	 */
	public Set<IndirizzoBean> doRetrieveByUtente(UtenteBean utente){
		LinkedHashSet<IndirizzoBean> indirizzi=new LinkedHashSet<IndirizzoBean>();
	
		return indirizzi;
	}
	
	/**
	 * Permette di eleminare un indirizzo memorizzato
	 * @param indirizzo
	 */
	public void doDelete(IndirizzoBean indirizzo) {
		
	}
}
