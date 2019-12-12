package beans;

public class MetodoPagamentoBean {
	
	/*
	 * Costruttore di default
	 */
	public MetodoPagamentoBean(){
		
	}	
	/*
	 * @return username;
	 */
	
	public String getUsername() {
		return usr;
	}
	/*
	 * @param username
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	/*
	 * @return tipo;
	 */
	public String getTipo() {
		return tipo;
	}
	/*
	 * @param tipo;
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/*
	 * @return numero;
	 */
	public String getNumero() {
		return numero;
	}
	/*
	 * @param numero;
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Variabile d'istanza username
	 */
	
	private String usr;
	/*
	 * Variabile d'istanza tipo
	 */
	private String tipo;
	/*
	 * Variabile d'istanza numero
	 */
	private String numero;
}
