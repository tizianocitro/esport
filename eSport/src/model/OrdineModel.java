package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.OrdineBean;
import beans.UtenteBean;

public class OrdineModel {
	static Logger log=Logger.getLogger("OrdineModelDebugger");

	public OrdineModel() {
		
	}
	
	/**
	 * Permette di salvare un ordine
	 * @param ordine
	 */
	public void doSave(OrdineBean ordine) {
		
	}

	/**
	 * Permette di ottenere tutti gli ordini specificando un ordine di restituzione
	 * @param order
	 * @return ordini
	 */
	public Set<OrdineBean> doRetrieveAll(String order){
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		return ordini;
	}
	
	/**
	 * Permette di ottenere un ordine specificandone il numero
	 * @param numero
	 * @return ordine
	 */
	public OrdineBean doRetrieveByNumero(String numero) {
		
		return null;
	}
	
	/**
	 * Permette di ottenere gli ordini di un utente specificando un ordine di restituzione
	 * @param utente
	 * @param order
	 * @return
	 */
	public Set<OrdineBean> doRetrieveByUtente(UtenteBean utente, String order) {
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		return ordini;
	}
	
	/**
	 * Permette di ottenere gli ordini attivi specificando un ordine di restituzione
	 * @param utente
	 * @param order
	 * @return
	 */
	public Set<OrdineBean> doRetrieveIfAttivi(String order) {
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		return ordini;
	}
}
