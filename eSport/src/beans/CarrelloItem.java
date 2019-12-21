package beans;

/**
 * Questa classe modella gli elementi del carrello
 */
public class CarrelloItem {
	
	/*
	 * Costruttore CarrelloItem
	 */
	public CarrelloItem() {
		qt=1;
	}
	
	/*
	 * Permette di ottenere il valore della variabile d'istanza che modella il prodotto
	 * @return prodotto
	 */
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	
	/*
	 * Permette di modificare il valore della variabile d'istanza che modella il prodotto
	 * @param prodotto
	 */
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto=prodotto;
	}
	
	/*
	 * Permette di ottenere il valore della variabile d'istanza che modella la quantità di un prodotto
	 * @return quantita
	 */
	public int getQt() {
		return qt;
	}
	
	/*
	 * Permette di modificare il valore della variabile d'istanza che modella la quantità di un prodotto
	 * @param quantita
	 */
	public void setQt(int qt) {
		this.qt=qt;
	}

	/**
	 * 
	 * Permette di ottenere il valore della variabile d'istanza che modella la taglia di un prodotto
	 * @return taglia
	 */
	public String getTaglia() {
		return taglia;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la taglia di un prodotto
	 * @param taglia
	 */
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	/**
	 * Permette di confrontare due prodotti per verificare che essi siano uguali 
	 */
	@Override
	public boolean equals(Object item) {
		if(!(item instanceof CarrelloItem) || item==null)
			return false;
		
		CarrelloItem carrelloItem=(CarrelloItem) item;
		
		return prodotto.getCodice().equals(carrelloItem.getProdotto().getCodice())
				&& taglia.equals(carrelloItem.getTaglia());
	}
	
	/*
	 * Variabile d'istanza prodotto
	 */
	private ProdottoBean prodotto;
	
	/*
	 * Variabile d'istanza quantita
	 */
	private int qt;
	
	/**
	 * Variabile d'istanza taglia
	 */
	private String taglia;
}
