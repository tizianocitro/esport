package beans;

/*
 * Questa classe modella il metodo di pagamento degli utenti
 */

public class MetodoPagamentoBean {
	
	/*
	 * Costruttore di default
	 */
	public MetodoPagamentoBean(){
		
	}	
	
	/*
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell' utente
	 * @return username;
	 */
	public String getUsername() {
		return usr;
	}
	
	/*
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente
	 * @param username
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/*
	 * Permette di ottenere il valore della variabile d'istanza che modella il tipo di metodo di pagamento dell'utente
	 * @return tipo;
	 */
	public String getTipo() {
		return tipo;
	}
	
	/*
	 * Permette di modificare il valore della variabile d'istanza che modella il tipo di metodo di pagamento dell'utente
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
