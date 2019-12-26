package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	 * Permette di aggiornare lo stato di un ordine attivo
	 * @param ordine
	 * @param stato
	 */
	public void aggiornaStato(OrdineBean ordine, String stato) {
		
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
	
	/**
	 * Permette di generare la data di sottomissione dell'ordine
	 * @return sottomissione
	 */
	public String generatoreSottomissione() {
		log.info("Imposto la data di sottomissione come la data odierna");
		Date d=Calendar.getInstance().getTime();
		String format="yyyy-MM-dd";
		DateFormat df=new SimpleDateFormat(format);
		String sottomissione=df.format(d);
		
		return sottomissione;
	}
	
	/**
	 * Permette di generare la data di consegna dell'ordine
	 * @return consegna
	 */
	public String generatoreConsegna() {
		log.info("Imposto la data di consegna");
    	Calendar cal=Calendar.getInstance();
    	cal.add(Calendar.DATE, 3);
    	String formatOne="yyyy-MM-dd";
		DateFormat dfOne=new SimpleDateFormat(formatOne);
		String consegna=dfOne.format(cal.getTime());
		
		return consegna;
	}
	
	/**
	 * Permette di generare il numero dell'ordine
	 * @return numero
	 */
	public String generatoreNumero() {		
		log.info("generatoreNumero -> eseguo doCount");
		int count=doCount();
		count++;
		
		return String.format("%06d", count);
	}
	
	/**
	 * Permette di ottenere il numero totale degli ordini memorizzati
	 * @return count
	 */
	public int doCount() {
		int count=0;
				
		return count;
	}
}
