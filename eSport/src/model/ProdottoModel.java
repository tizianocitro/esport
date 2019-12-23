package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ProdottoBean;

public class ProdottoModel {
	static Logger log=Logger.getLogger("ProdottoModelDebugger");

	public ProdottoModel() {
		
	}
	
	/**
	 * Permette di salvare un prodotto
	 * @param prodotto
	 */
	public void doSave(ProdottoBean prodotto) {
		
	}
	
	/**
	 * Permette di ottenere i prodotti in base al tipo specificando un ordinamento
	 * @param tipo
	 * @return prodotti
	 */
	public Set<ProdottoBean> doRetrieveByTipo(String tipo, String order){
		LinkedHashSet<ProdottoBean> prodotti=new LinkedHashSet<ProdottoBean>();
		
		return prodotti;
	}
	
	/**
	 * Permette di ottenere un prodotto specificando il codice
	 * @param tipo
	 * @return prodotti
	 */
	public ProdottoBean doRetrieveByCodice(String codice){
		
		return null;
	}
	
	/**
	 * Permette di salvare un prodotto
	 * @param prodotto
	 */
	public void doUpdate(ProdottoBean prodotto) {
		
	}
	
	/**
	 * Permette di eliminare un prodotto
	 * @param prodotto
	 */
	public void doDelete(ProdottoBean prodotto) {
		
	}
}
