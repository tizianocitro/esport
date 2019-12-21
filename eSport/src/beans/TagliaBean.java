package beans;

/**
 * Questa classe modella la taglia di un prodotto
 */
public class TagliaBean {
	
	/**
	 * Costruttore di default
	 */
	public TagliaBean() {
		
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prodotto 
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prodotto 
	 * @param prodotto
	 */
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la misura della taglia
	 * @return misura
	 */
	public String getMisura() {
		return misura;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la misura della taglia
	 * @param misura
	 */
	public void setMisura(String misura) {
		this.misura = misura;
	}

	/**
	 * Variabili d'istanza prodotto
	 */
	private String prodotto;
	
	/**
	 * Variabile d'istanza misura;
	 */
	private String misura;
}
