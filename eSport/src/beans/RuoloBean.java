package beans;

public class RuoloBean {
	/**
	 * Costruttore di default
	 */
	public RuoloBean() {
		
	}
	
	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * 
	 * @return permesso
	 */
	public String getPermesso() {
		return permesso;
	}
	
	/**
	 * 
	 * @param permesso
	 */
	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}

	private String usr;
	private String permesso;
}
