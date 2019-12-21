package beans;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Questa classe modella un utente
 */
public class UtenteBean {
	
	/**
	 * Costruttore di default
	 */
	public UtenteBean() {
		metPags=new LinkedHashSet<MetodoPagamentoBean>();
		indirizzi=new LinkedHashSet<IndirizzoBean>();
		ruoli=new LinkedHashMap<String, RuoloBean>();
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username dell'utente
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username dell'utente
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la password dell'utente
	 * @return password
	 */
	public String getPassword() {
		return pass;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la password dell'utente
	 * @param password
	 */
	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella i ruoli dell'utente
	 * @return ruoli
	 */
	public Map<String, RuoloBean> getRuolo() {
		return ruoli;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella i ruoli dell'utente
	 * @param ruoli
	 */
	public void setRuolo(Map<String, RuoloBean> ruoli) {
		this.ruoli = ruoli;
	}
	
	/**
	 * Permette di aggiungere un nuovo ruolo
	 * @param ruolo
	 */
	public void addRuolo(RuoloBean ruolo) {
		ruoli.put("" + ruolo.getPermesso(), ruolo);
	}
	
	/**
	 * Permette di rimuovere un ruolo
	 * @param ruolo
	 */
	public void removeRuolo(RuoloBean ruolo) {
		ruoli.remove(ruolo.getPermesso());
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il nome dell'utente
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il nome dell'utente
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il cognome dell'utente
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il cognome dell'utente
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'email dell'utente
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'email dell'utente
	 * @param email
	 */
	public void setEmail(String email) {
		this.email=email;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la partita iva dell'utente
	 * @return partitaIVA
	 */
	public String getPiva() {
		return piva;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la partita iva dell'utente
	 * @param piva
	 */
	public void setPiva(String piva) {
		this.piva=piva;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella i metodi di pagamento dell'utente
	 * @return metodi pagamento
	 */
	public Set<MetodoPagamentoBean> getMetPag() {
		return metPags;
	}
	
	/**
	 * Permette di modicare il valore della variabile d'istanza che modella i metodi di pagamento dell'utente
	 * @param metPags
	 */
	public void setMetPag(Set<MetodoPagamentoBean> metPags) {
		this.metPags=metPags;
	}
	
	/**
	 * Permette di ottenere un singolo metodo di pagamento in base al codice identificativo del metodo di pagamento
	 * @param codice
	 * @return metodo pagamento
	 */
	public MetodoPagamentoBean getMetPag(int codice) {
		for(MetodoPagamentoBean metodo: metPags)
			if(metodo.getCodice()==codice)
				return metodo;
		
		return null;
	}
	
	/**
	 * Permette di aggiungere un nuovo metodo di pagamento 
	 * @param metPag
	 */
	public void addMetPag(MetodoPagamentoBean metPag) {
		metPags.add(metPag);
	}
	
	/**
	 * Permette di rimuovere un metodo di pagamento 
	 * @param metPag
	 */
	public void removeMetPag(MetodoPagamentoBean metPag) {
		metPags.remove(metPag);
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il numero di telefono dell'utente
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**Permette di modificare il valore della variabile d'istanza che modella il numero di telefono dell'utente
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella gli indirizzi dell'utente
	 * @return indirizzi
	 */
	public Set<IndirizzoBean> getIndirizzi() {
		return indirizzi;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella gli indirizzi dell'utente
	 * @param indirizzi
	 */
	public void setIndirizzi(Set<IndirizzoBean> indirizzi) {
		this.indirizzi=indirizzi;
	}

	/**
	 * Permette di ottenere un singolo indirizzo dell'utente in base al codice identificativo dell'indirizzo
	 * @param codice
	 * @return indirizzo
	 */
	public IndirizzoBean getIndirizzo(int codice) {
		for(IndirizzoBean indirizzo: indirizzi)
			if(indirizzo.getCodice()==codice)
				return indirizzo;
		
		return null;
	}
	
	/**
	 * Permette di aggiungere un nuovo indirizzo
	 * @param indirizzo
	 */
	public void addIndirizzo(IndirizzoBean indirizzo) {
		indirizzi.add(indirizzo);
	}
	
	/**
	 * Permette di rimuovere un indirizzo
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
	 * Variabile d'istanza metodi di pagamento
	 */
	private Set<MetodoPagamentoBean> metPags;
	
	/**
	 * Variabile d'istanza indirizzi
	 */
	private Set<IndirizzoBean> indirizzi;
	
	/**
	 * Variabile d'istanza ruoli
	 */
	private Map<String, RuoloBean> ruoli;
}