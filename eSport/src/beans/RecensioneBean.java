package beans;

public class RecensioneBean {
	public RecensioneBean() {
		
	}
	
	public RecensioneBean(int voto, String commento, String usrutente, String passutente,
			String prodotto) {
		this.voto = voto;
		this.commento = commento;
		this.usrutente = usrutente;
		this.passutente = passutente;
		this.prodotto = prodotto;
	}

	public int getVoto() {
		return voto;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	public String getCommento() {
		return commento;
	}
	
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	public String getUsrutente() {
		return usrutente;
	}
	
	public void setUsrutente(String usrutente) {
		this.usrutente = usrutente;
	}
	
	public String getPassutente() {
		return passutente;
	}
	
	public void setPassutente(String passutente) {
		this.passutente = passutente;
	}
	
	public String getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	private int voto;
	private String commento;
	private String usrutente;
	private String passutente;
	private String prodotto;
}
