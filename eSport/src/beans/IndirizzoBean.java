package beans;

public class IndirizzoBean {
	
	/**
	 * Costruttore di default
	 */
	public IndirizzoBean () {
		
	}	

	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * 
	 * @return citta
	 */
	public String getCitta() {
		return citta;
	}
	
	/**
	 * 
	 * @param citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	/**
	 * 
	 * @return via
	 */
	public String getVia() {
		return via;
	}
	
	/**
	 * 
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * 
	 * @return civico
	 */
	public String getCivico() {
		return civico;
	}
	
	/**
	 * 
	 * @param civico
	 */
	public void setCivico(String civico) {
		this.civico = civico;
	}
	
	/**
	 * 
	 * @return cap
	 */
	public String getCap() {
		return cap;
	}
	
	/**
	 * 
	 * @param cap
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	private String usr;
	private String citta;
	private String via;
	private String civico;
	private String cap;
}