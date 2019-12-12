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
	
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	public String getPermesso() {
		return permesso;
	}
	
	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}

	private String usr;
	private String permesso;
}
