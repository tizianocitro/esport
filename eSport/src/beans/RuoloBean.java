package beans;

/**
 * Questa classe modella il ruolo di un utente
 */
public class RuoloBean {
	
	/**
	 * Costruttore di default
	 */
	public RuoloBean() {
		
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell'utente
	 * @return username
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il permesso assegnato all'utente
	 * @return permesso
	 */
	public String getPermesso() {
		return permesso;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il permesso assegnato all'utente
	 * @param permesso
	 */
	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}
	
	/**
	 * Variabile d'istanza username
	 */
	private String usr;
	
	/**
	 * Variabile d'istanza permesso
	 */
	private String permesso;
}
