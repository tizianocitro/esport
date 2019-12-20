package beans;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrdineBean {
	/**
	 * Costruttore di default
	 */
	public OrdineBean() {
		composizione=new LinkedHashSet<ComposizioneBean>();
	}
    
	/**
	 * 
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * 
	 * @return stato
 	 */
	public String getStato() {
		return stato;
	}

	/**
	 * 
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * 
	 * @return pagamento
	 */
	public String getPagamento() {
		return pagamento;
	}

	/**
	 * 
	 * @param pagamento
	 */
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * 
	 * @return prezzoTot
	 */
	public double getTotale() {
		return totale;
	}
	
	/**
	 * 
	 * @param prezzoTot
	 */
	public void setTotale(double prezzoTot) {
		this.totale = prezzoTot;
	}
	
	/**
	 * 
	 * @return dataOrd
	 */
	public String getSottomissione() {
		return sottomissione;
	}
	
	/**
	 * 
	 * @param dataOrd
	 */
	public void setSottomissione(String sottomissione) {
		this.sottomissione = sottomissione;
	}
	
	/**
	 * 
	 * @return consegna
	 */
	public String getConsegna() {
		return consegna;
	}

	/**
	 * 
	 * @param consegna
	 */
	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	/**
	 * 
	 * @return usr
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
	 * @return composizione
	 */
	public Set<ComposizioneBean> getComposizione() {
		return composizione;
	}

	/**
	 * 
	 * @param composizione
	 */
	public void setComposizione(Set<ComposizioneBean> composizione) {
		this.composizione = composizione;
	}

	/*
	 * Variabili d'istanza numero
	 */
	private String numero;
	
	/**
	 * Variabile d'istanza stato
	 */
	private String stato;
	
	/*
	 * Variabili d'istanza pagamento
	 */
	private String pagamento;

	/*
	 * Variabili d'istanza prezzoTotale
	 */
	private double totale;
	
	/*
	 * Variabili d'istanza dataOrdine
	 */
	private String sottomissione;
	
	/*
	 * Variabili d'istanza consegna
	 */
	private String consegna;
	
	/*
	 * Variabili d'istanza username
	 */
	private String usr;
	
	/**
	 * Variabile d'istanza composizione
	 */
	private Set<ComposizioneBean> composizione;
	
}
