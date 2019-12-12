package beans;

public class TagliaBean {
	/*
	 * Costruttore di default
	 */
	public TagliaBean() {
		
	}
	
	/*
	 * @return prodotto
	 */
	public String getProdotto() {
		return prodotto;
	}
	/*
	 * @param prodotto
	 */
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	/*
	 * @return misura
	 */
	public String getMisura() {
		return misura;
	}
	/*
	 * @param misura
	 */
	public void setMisura(String misura) {
		this.misura = misura;
	}




	/*
	 * Variabile d'istanza prodotto
	 */
	private String prodotto;
	/*
	 * Variabile d'istanza misura;
	 */
	private String misura;
}
