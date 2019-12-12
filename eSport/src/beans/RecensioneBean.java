package beans;

public class RecensioneBean {
	/**
	 * Costruttore di default
	 */
	public RecensioneBean() {
		
	}
	
	/**
	 * 
	 * @return codice
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * 
	 * @param codice
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}

	/**
	 * 
	 * @return voto
	 */
	public int getVoto() {
		return voto;
	}
	
	/**
	 * 
	 * @param voto
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	/**
	 * 
	 * @return commento
	 */
	public String getCommento() {
		return commento;
	}
	
	/**
	 * 
	 * @param commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	/**
	 * 
	 * @return usr
	 */
	public String getUsrutente() {
		return usr;
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void setUsrutente(String usr) {
		this.usr = usr;
	}
	
	/**
	 * 
	 * @return passUtente
	 */
	public String getPassUtente() {
		return passUtente;
	}
	
	/**
	 * 
	 * @param passUtente
	 */
	public void setPassutente(String passUtente) {
		this.passUtente = passUtente;
	}
	
	/**
	 * 
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	
	/**
	 * 
	 * @param prodotto
	 */
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	private int codice;
	private int voto;
	private String commento;
	private String usr;
	private String passUtente;
	private String prodotto;
}
