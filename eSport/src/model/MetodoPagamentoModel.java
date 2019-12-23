package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.MetodoPagamentoBean;
import beans.UtenteBean;

public class MetodoPagamentoModel {
	static Logger log=Logger.getLogger("MetodoPagamentoModelDebugger");

	public MetodoPagamentoModel() {

	}
 
	/**
	 * Permette di salvare un metodo di pagamento
	 * @param metodo
	 */
	public void doSave(MetodoPagamentoBean metodo) {
		
	}
	
	/**
	 * Permette di ottenere i metodi di pagamento aggiunti da un utente
	 * @param user
	 * @return metodi di pagamento
	 */
	public Set<MetodoPagamentoBean> doRetrieveByUtente(UtenteBean utente){
		LinkedHashSet<MetodoPagamentoBean> metodi=new LinkedHashSet<MetodoPagamentoBean>();
		
		return metodi;
	}
	
	/**
	 * Permette di eleminare un metodo di pagamento memorizzato
	 * @param metodo
	 */
	public void doDelete(MetodoPagamentoBean metodo) {
		
	}
}
