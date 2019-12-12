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
	
	public void addRuolo(RuoloBean ruolo) {
		ruoli.add(ruolo);
	}
	
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
	
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPiva() {
		return piva;
	}
	
	public void setPiva(String piva) {
		this.piva=piva;
	}
	
	public Collection<MetodoPagamentoBean> getMetpag() {
		return metPags;
	}
	
	public void setMetpag(Set<MetodoPagamentoBean> metPags) {
		this.metPags=metPags;
	}
	
	public void addMetPag(MetodoPagamentoBean metPag) {
		metPags.add(metPag);
	}
	
	public void removeMetPag(MetodoPagamentoBean metPag) {
		metPags.remove(metPag);
	}

	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	public Collection<MetodoPagamentoBean> getIndirizzi() {
		return indirizzi;
	}
	
	public void setIndirizzi(Set<IndirizzoBean> indirizzi) {
		this.indirizzi=indirizzi;
	}

	public void addIndirizzo(IndirizzoBean indirizzo) {
		indirizzi.add(indirizzo);
	}
	
	public void removeIndirizzo(IndirizzoBean indirizzo) {
		indirizzi.remove(indirizzo);
	}
	
	private String username;
	private String pass;
	private String nome;
	private String cognome;
	private String email;
	private String piva;
	private String telefono;
	private Set<MetodoPagamentoBean> metPags;
	private Set<IndirizzoBean> indirizzi;
	private Set<RuoloBean> ruoli;
}
