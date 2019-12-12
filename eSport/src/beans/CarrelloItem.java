package beans;

public class CarrelloItem {
	public CarrelloItem() {
		qt=1;
	}
	
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto=prodotto;
	}
	
	public int getQt() {
		return qt;
	}
	
	public void setQt(int qt) {
		this.qt=qt;
	}

	private ProdottoBean prodotto;
	private int qt;
}
