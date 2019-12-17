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

	@Override
	public boolean equals(Object item) {
		if(!(item instanceof CarrelloItem) || item==null)
			return false;
		
		CarrelloItem carrelloItem=(CarrelloItem) item;

		return prodotto.getCodice().equals(carrelloItem.getProdotto().getCodice()) && qt==carrelloItem.getQt()
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
