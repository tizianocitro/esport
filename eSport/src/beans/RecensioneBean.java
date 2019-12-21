package beans;

/**
 * Questa classe modella la recensione di un utente
 */
public class RecensioneBean {
	/**
	 * Costruttore di default
	 */
	public RecensioneBean() {
		
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il voto dell'utente
	 * @return voto
	 */
	public int getVoto() {
		return voto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il voto dell'utente
	 * @param voto
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il commento dell'utente
	 * @return commento
	 */
	public String getCommento() {
		return commento;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il commento dell'utente
	 * @param commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell'utente
	 * @return usr
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prodotto da recensire
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prodotto da recensire
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
