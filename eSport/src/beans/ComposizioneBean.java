package beans;


public class ComposizioneBean {
	public ComposizioneBean() {
	}

	public String getOrdine() {
		return ordine;
	}
	
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	
	public String getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	public double getPrezzoven() {
		return prezzoven;
	}
	
	public void setPrezzoven(double prezzoven) {
		this.prezzoven = prezzoven;
	}
	
	public int getIvaven() {
		return ivaven;
	}
	
	public void setIvaven(int ivaven) {
		this.ivaven = ivaven;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private String ordine;
	private String prodotto;
	private String nomeProdotto;
	private double prezzoven;
	private int ivaven;
	private int quantity;
}
