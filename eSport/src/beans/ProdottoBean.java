package beans;

import java.util.Set;

/**
 * Questa classe modella un prodotto
 */

public class ProdottoBean {
	/**
	 * Costruttore di default
	 */
	public ProdottoBean() {
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il codice del prodotto
	 * @return codice
	 */
	public String getCodice() {
		return codice;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il codice del prodotto
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice=codice;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il tipo del prodotto
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il tipo del prodotto
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il nome del prodotto
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il nome del prodotto
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome=nome;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la marca del prodotto
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la marca del prodotto
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca=marca;
	}

	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella le taglie del prodotto
	 * @return taglie
	 */
	public Set<TagliaBean> getTaglie() {
		return taglie;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella le taglie del prodotto
	 * @param taglie
	 */
	public void setTaglie(Set<TagliaBean> taglie) {
		this.taglie = taglie;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la quantità del prodotto
	 * @return qt
	 */
	public int getQt() {
		return qt;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la quantità del prodotto
	 * @param qt
	 */
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il prezzo del prodotto
	 * @return prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il prezzo del prodotto
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella l'iva del prodotto
	 * @return iva
	 */
	public int getIva() {
		return iva;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella l'iva del prodotto
	 * @param iva
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella la descrizione del prodotto
	 * @return descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Permette di modificare il valore della variabile d'istanza che modella la descrizione del prodotto
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella le recensioni del prodotto
	 * @return recensioni
	 */
	public Set<RecensioneBean> getRecensioni() {
		return recensioni;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella le recensioni del prodotto
	 * @param recensioni
	 */
	public void setRecensioni(Set<RecensioneBean> recensioni) {
		this.recensioni = recensioni;
	}
	
	/*
	 * Variabili d'istanza codice
	 */
	private String codice;
	
	/*
	 * Variabili d'istanza tipo
	 */
	private String tipo;
	
	/*
	 * Variabili d'istanza nome
	 */
	private String nome;
	
	/*
	 * Variabili d'istanza marca
	 */
	private String marca;
	
	/*
	 * Variabili d'istanza taglie
	 */
	private Set<TagliaBean> taglie;
	
	/*
	 * Variabili d'istanza quantita'
	 */
	private int qt;
	
	/*
	 * Variabili d'istanza prezzo
	 */
	private double prezzo;
	
	/*
	 * Variabili d'istanza iva
	 */
	private int iva;
	
	/*
	 * Variabili d'istanza descrizione
	 */
	private String descrizione;
	
	/**
	 * Variabili d'istanza recensioni
	 */
	private Set<RecensioneBean> recensioni;
}
