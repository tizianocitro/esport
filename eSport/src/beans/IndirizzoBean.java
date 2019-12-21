package beans;

/**
 * Questa classe modella gli indirizzi  degli utenti
 */

public class IndirizzoBean {
	
	/**
	 * Costruttore di default
	 */
	public IndirizzoBean () {
		
	}	

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell'utente
	 * @return username
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente
	 * @param username
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la città dell'utente
	 * @return citta
	 */
	public String getCitta() {
		return citta;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la città dell'utente
	 * @param citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la via dell'utente
	 * @return via
	 */
	public String getVia() {
		return via;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la via dell'utente
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il numero civico dell'utente
	 * @return civico
	 */
	public String getCivico() {
		return civico;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il numero civico dell'utente
	 * @param civico
	 */
	public void setCivico(String civico) {
		this.civico = civico;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il cap dell'utente
	 * @return cap
	 */
	public String getCap() {
		return cap;
	}
	
	/**
	 * Permette di modicare il valore della variabile d'istanza che modella il cap dell'utente
	 * @param cap
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
		return citta + ", " + via + " " + civico;
	}
	
	/**
	 * Variabile d'istanza codice
	 */
	private int codice;
	/**
	 * Variabile d'istanza username
	 */
	private String usr;
	/**
	 * Variabile d'istanza citta
	 */
	private String citta;
	/**
	 * Variabile d'istanza via
	 */
	private String via;
	/**
	 * Variabile d'istanza civico
	 */
	private String civico;
	/**
	 * Variabile d'istanza cap
	 */
	private String cap;
}