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
	public int getQuantity() {
		return qt;
	}
	
	/**
	 * 
	 * @param qt
	 */
	public void setQuantity(int qt) {
		this.qt = qt;
	}
	
	private String ordine;
	private String prodotto;
	private String nomeProdotto;
	private double prezzoVen;
	private int ivaVen;
	private int qt;
}
