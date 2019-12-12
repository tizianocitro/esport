package beans;

public class CarrelloItem {
	
	/*
	 * Costruttore CarrelloItem
	 */
	public CarrelloItem() {
		qt=1;
	}
	
	/*
	 * @return prodotto
	 */
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	
	/*
	 * @param prodotto
	 */
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto=prodotto;
	}
	
	/*
	 * @return quantita
	 */
	public int getQt() {
		return qt;
	}
	
	/*
	 * @param quantita
	 */
	public void setQt(int qt) {
		this.qt=qt;
	}

	/*
	 * Variabili d'istanza prodotto
	 */
	private ProdottoBean prodotto;
	
	/*
	 * Variabili d'istanza quantita
	 */
	private int qt;
}
