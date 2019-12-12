package beans;

import java.util.Collection;
import java.util.Set;

public class UtenteBean {
	/**
	 * Costruttore di default
	 */
	public UtenteBean() {
	}
	
	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return pass;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	/**
	 * 
	 * @return ruoli
	 */
	public Collection<RuoloBean> getRuolo() {
		return ruoli;
	}
	
	/**
	 * 
	 * @param ruoli
	 */
	public void setRuolo(Set<RuoloBean> ruoli) {
		this.ruoli = ruoli;
	}
	
	/**
	 * 
	 * @param ruolo
	 */
	public void addRuolo(RuoloBean ruolo) {
		ruoli.add(ruolo);
	}
	
	/**
	 * 
	 * @param ruolo
	 */
	public void removeRuolo(RuoloBean ruolo) {
		ruoli.remove(ruolo);
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
		this.nome=nome;
	}
	
	/**
	 * 
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email=email;
	}
	
	/**
	 * 
	 * @return partitaIVA
	 */
	public String getPiva() {
		return piva;
	}
	
	/**
	 * 
	 * @param piva
	 */
	public void setPiva(String piva) {
		this.piva=piva;
	}
	
	/**
	 * 
	 * @return metodi pagamento
	 */
	public Collection<MetodoPagamentoBean> getMetpag() {
		return metPags;
	}
	
	/**
	 * 
	 * @param metPags
	 */
	public void setMetpag(Set<MetodoPagamentoBean> metPags) {
		this.metPags=metPags;
	}
	
	/**
	 * 
	 * @param metPag
	 */
	public void addMetPag(MetodoPagamentoBean metPag) {
		metPags.add(metPag);
	}
	
	/**
	 * 
	 * @param metPag
	 */
	public void removeMetPag(MetodoPagamentoBean metPag) {
		metPags.remove(metPag);
	}

	/**
	 * 
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	/**
	 * 
	 * @return indirizzi
	 */
	public Collection<IndirizzoBean> getIndirizzi() {
		return indirizzi;
	}
	
	/**
	 * 
	 * @param indirizzi
	 */
	public void setIndirizzi(Set<IndirizzoBean> indirizzi) {
		this.indirizzi=indirizzi;
	}

	/**
	 * 
	 * @param indirizzo
	 */
	public void addIndirizzo(IndirizzoBean indirizzo) {
		indirizzi.add(indirizzo);
	}
	
	/**
	 * 
	 * @param indirizzo
	 */
	public void removeIndirizzo(IndirizzoBean indirizzo) {
		indirizzi.remove(indirizzo);
	}
	
	/**
	 * Variabile d'istanza username
	 */
	private String username;
	/**
	 * Variabile d'istanza password
	 */
	private String pass;
	/**
	 * Variabile d'istanza nome
	 */
	private String nome;
	/**
	 * Variabile d'istanza cognome
	 */
	private String cognome;
	/**
	 * Variabile d'istanza email
	 */
	private String email;
	/**
	 * Variabile d'istanza partita iva
	 */
	private String piva;
	/**
	 * Variabile d'istanza telefono
	 */
	private String telefono;
	/**
	 * Variabile d'istanza metodo pagamento
	 */
	private Set<MetodoPagamentoBean> metPags;
	/**
	 * Variabile d'istanza indirizzi
	 */
	private Set<IndirizzoBean> indirizzi;
	/**
	 * Variabile d'istanza ruoli
	 */
	private Set<RuoloBean> ruoli;
}