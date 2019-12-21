package beans;

/**
 * Questa classe modella un ordine 
 */
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
	 * Permette di ottenere il valore della variabile d'istanza che modella il numero dell'ordine
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il numero dell'ordine
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella lo stato dell'ordine
	 * @return stato
 	 */
	public String getStato() {
		return stato;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella lo stato dell'ordine
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il pagamento dell'ordine
	 * @return pagamento
	 */
	public int getPagamento() {
		return pagamento;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il pagamento dell'ordine
	 * @param pagamento
	 */
	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'indirizzo dell'ordine
	 * @return indirizzo
	 */
	public int getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'indirizzo dell'ordine
	 * @param indirizzo
	 */
	public void setIndirizzo(int indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il totale dell'ordine
	 * @return prezzoTot
	 */
	public double getTotale() {
		return totale;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il totale dell'ordine
	 * @param prezzoTot
	 */
	public void setTotale(double prezzoTot) {
		this.totale = prezzoTot;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la data in cui è stato effettuato l'ordine
	 * @return dataOrd
	 */
	public String getSottomissione() {
		return sottomissione;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la data in cui è stato effettuato l'ordine
	 * @param dataOrd
	 */
	public void setSottomissione(String sottomissione) {
		this.sottomissione = sottomissione;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la data di consegna dell'ordine
	 * @return consegna
	 */
	public String getConsegna() {
		return consegna;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la data di consegna dell'ordine
	 * @param consegna
	 */
	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'username di chi ha effettuato l'ordine
	 * @return usr
	 */
	public String getUsername() {
		return usr;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'username di chi ha effettuato l'ordine
	 * @param usr
	 */
	public void setUsername(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la composizione dell'ordine
	 * @return composizione
	 */
	public Set<ComposizioneBean> getComposizione() {
		return composizione;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la composizione dell'ordine
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
	private int pagamento;

	/*
	 * Variabili d'istanza pagamento
	 */
	private int indirizzo;
	
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
