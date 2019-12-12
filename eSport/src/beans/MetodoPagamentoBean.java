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
		return username;
	}
	/*
	 * @param username
	 */
	public void setUsername(String usr) {
		this.usr = username;
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
	
	
	
	
	private String usr;
	private String tipo;
	private String numero;
}
