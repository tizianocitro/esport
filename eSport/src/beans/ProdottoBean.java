package beans;

import java.util.Set;

public class ProdottoBean {
	/**
	 * Costruttore di default
	 */
	public ProdottoBean() {
	}
	
	/**
	 * 
	 * @return codice
	 */
	public String getCodice() {
		return codice;
	}
	
	/**
	 * 
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice=codice;
	}
	
	/**
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo=tipo;
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
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * 
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca=marca;
	}

	/**
	 * 
	 * @return taglie
	 */
	public Set<TagliaBean> getTaglie() {
		return taglie;
	}
	
	/**
	 * 
	 * @param taglie
	 */
	public void setTaglie(Set<TagliaBean> taglie) {
		this.taglie = taglie;
	}
	
	/**
	 * 
	 * @return qt
	 */
	public int getQt() {
		return qt;
	}
	
	/**
	 * 
	 * @param qt
	 */
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	/**
	 * 
	 * @return prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * 
	 * @return iva
	 */
	public int getIva() {
		return iva;
	}
	
	/**
	 * 
	 * @param iva
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	/**
	 * 
	 * @return descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * 
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * 
	 * @return recensioni
	 */
	public Set<RecensioneBean> getRecensioni() {
		return recensioni;
	}

	/**
	 * 
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
