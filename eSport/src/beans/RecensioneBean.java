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
	 * Permette di ottenere il valore della variabile d'istanza che modella il voto della recensione
	 * @return voto
	 */
	public int getVoto() {
		return voto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il voto della recensione
	 * @param voto
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il commento della recensione
	 * @return commento
	 */
	public String getCommento() {
		return commento;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il commento della recensione
	 * @param commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell'utente che ha lasciato la recensione
	 * @return usr
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente che ha lasciato la recensione
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prodotto recensito
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prodotto recensito
	 * @param prodotto
	 */
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	/*
	 * Variabile d'istanza voto
	 */
	private int voto;
	
	/*
	 * Variabile d'istanza commento
	 */
	private String commento;
	
	/*
	 * Variabile d'istanza username
	 */
	private String usr;
	
    /**
     * Variabile d'istanza prodotto
     */
	private String prodotto;
	
	/**
	 * Costanti statiche per esprimere il range dei valori possibili per il voto delle recensioni
	 */
	public static final int VOTO_MINIMO=1;
	public static final int VOTO_MASSIMO=10;
	public static final int LUNGHEZZA_MINIMA=12;
	public static final int LUNGHEZZA_MASSIMA=512;
}
