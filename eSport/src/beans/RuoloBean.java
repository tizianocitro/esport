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
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username di un utente
	 * @return username
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username di un utente
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il permesso di un utente
	 * @return permesso
	 */
	public String getPermesso() {
		return permesso;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il permesso di un utente
	 * @param permesso
	 */
	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}
	
	/*
	 * Variabili d'istanza username
	 */
	private String usr;
	/*
	 * Variabili d'istanza permesso
	 */
	private String permesso;
}
