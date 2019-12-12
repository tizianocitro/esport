package beans;

public class OrdineBean {
	/**
	 * Costruttore di default
	 */
	public OrdineBean() {	
	}
    
	/**
	 * 
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return prezzoTot
	 */
	public double getPrezzoTot() {
		return prezzoTot;
	}
	
	/**
	 * 
	 * @param prezzoTot
	 */
	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}
	
	/**
	 * 
	 * @return dataOrd
	 */
	public String getDataOrd() {
		return dataOrd;
	}
	
	/**
	 * 
	 * @param dataOrd
	 */
	public void setDataOrd(String dataOrd) {
		this.dataOrd = dataOrd;
	}
	
	/**
	 * 
	 * @return consegna
	 */
	public String getConsegna() {
		return consegna;
	}

	/**
	 * 
	 * @param consegna
	 */
	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	/**
	 * 
	 * @return usr
	 */
	public String getUsrutente() {
		return usr;
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void setUsrutente(String usr) {
		this.usr = usr;
	}
	
	
	private String numero;
	private String nome;
	private double prezzoTot;
	private String dataOrd;
	private String consegna;
	private String usr;
	
}
