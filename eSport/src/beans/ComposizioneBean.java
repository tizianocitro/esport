package beans;

/**
 * Questa classe modella la composizione dell'ordine
 */

public class ComposizioneBean {
	/**
	 * Costruttore di default
	 */
	public ComposizioneBean() {
	}
	
    /**
     *  Permette di ottenere il valore della variabile d'istanza che modella l'ordine
     * @return ordine
     */
	public String getOrdine() {
		return ordine;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'ordine
	 * @param ordine
	 */
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prodotto dell'ordine
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prodotto dell'ordine
	 * @param prodotto
	 */
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	
	/**
	 * Permette di ottenre il valore della variabile d'istanza che modella il nome del prodotto dell'ordine
	 * @return nomeProdotto
	 */
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il nome del prodotto dell'ordine
	 * @param nomeProdotto
	 */
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prezzo di vendita di un prodotto dell'ordine
	 * @return prezzoven
	 */
	public double getPrezzoVen() {
		return prezzoVen;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prezzo di vendita di un prodotto dell'ordine
	 * @param prezzoven
	 */
	public void setPrezzoVen(double prezzoven) {
		this.prezzoVen = prezzoven;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'iva di un prodotto dell'ordine
	 * @return ivaven
	 */
	public int getIvaVen() {
		return ivaVen;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'iva di un prodotto dell'ordine
	 * @param ivaven
	 */
	public void setIvaVen(int ivaVen) {
		this.ivaVen = ivaVen;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la quantità di un prodotto dell'ordine
	 * @return qt
	 */
	public int getQt() {
		return qt;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la quantità di un prodotto dell'ordine
	 * @param qt
	 */
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la taglia di un prodotto dell'ordine
	 * @return taglia
	 */
	public String getTaglia() {
		return taglia;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la taglia di un prodotto dell'ordine
	 * @param taglia
	 */
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	/**
	 * Variabile d'istanza ordine
	 */
	private String ordine;
	/**
	 * Variabile d'istanza prodotto
	 */
	private String prodotto;
	/**
	 * Variabile d'istanza nome prodotto
	 */
	private String nomeProdotto;
	/**
	 * Variabile d'istanza prezzo di vendita
	 */
	private double prezzoVen;
	/**
	 * Variabile d'istanza iva di vendita
	 */
	private int ivaVen;
	/**
	 * Variabile d'istanza quantità
	 */
	private int qt;
	
	/**
	 * Variabile d'istanza taglia
	 */
	private String taglia;
}
