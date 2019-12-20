package beans;


public class ComposizioneBean {
	/**
	 * Costruttore di default
	 */
	public ComposizioneBean() {
	}
	
    /**
     *  
     * @return ordine
     */
	public String getOrdine() {
		return ordine;
	}
	
	/**
	 * 
	 * @param ordine
	 */
	public void setOrdine(String ordine) {
		this.ordine = ordine;
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
	
	/**
	 * 
	 * @return nomeProdotto
	 */
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	/**
	 * 
	 * @param nomeProdotto
	 */
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	/**
	 * 
	 * @return prezzoven
	 */
	public double getPrezzoVen() {
		return prezzoVen;
	}
	
	/**
	 * 
	 * @param prezzoven
	 */
	public void setPrezzoVen(double prezzoven) {
		this.prezzoVen = prezzoven;
	}
	
	/**
	 * 
	 * @return ivaven
	 */
	public int getIvaven() {
		return ivaVen;
	}
	
	/**
	 * 
	 * @param ivaven
	 */
	public void setIvaVen(int ivaVen) {
		this.ivaVen = ivaVen;
	}
	
	/**
	 * 
	 * @return qt
	 */
	public int getQt() {
		return qt;
	}
	
	/**
	 * 
	 * @param qt
	 */
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	/**
	 * 
	 * @return taglia
	 */
	public String getTaglia() {
		return taglia;
	}

	/**
	 * 
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
