package beans;

public class RecensioneBean {
	/**
	 * Costruttore di default
	 */
	public RecensioneBean() {
		
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
	public String getUsername() {
		return usr;
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
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

	/*
	 * Variabili d'istanza voto
	 */
	private int voto;
	/*
	 * Variabili d'istanza commento
	 */
	private String commento;
	/*
	 * Variabili d'istanza username
	 */
	private String usr;
    /**
     * Variabili d'istanza prodotto
     */
	private String prodotto;
}
