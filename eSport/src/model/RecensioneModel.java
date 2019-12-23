package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.RecensioneBean;

public class RecensioneModel {
	static Logger log=Logger.getLogger("RecensioneModelDebugger");

	public RecensioneModel() {
		
	}

	/**
	 * Permette di salvare una recensione
	 * @param recensione
	 */
	public void doSave(RecensioneBean recensione) {
		
	}
	
	/**
	 * Permette di ottenere le recensioni di un prodotto specificando un ordine di restituzione
	 * @param codiceProdotto
	 * @return recensioni
	 */
	public Set<RecensioneBean> doRetrieveByProdotto(String codiceProdotto, String order) {
		LinkedHashSet<RecensioneBean> recensioni=new LinkedHashSet<RecensioneBean>();

		return recensioni;
	}
}
