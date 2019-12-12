package beans;

import java.util.Collection;
import java.util.Set;

public class ProdottoBean {
	public ProdottoBean() {
	}
	
	public String getCodice() {
		return codice;
	}
	
	public void setCodice(String codice) {
		this.codice=codice;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca=marca;
	}

	public Collection<TagliaBean> getTaglia() {
		return taglie;
	}
	
	public void setTaglia(Set<TagliaBean> taglie) {
		this.taglie = taglie;
	}
	
	public int getQuant() {
		return quant;
	}
	
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getIva() {
		return iva;
	}
	
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	 * Variabili d'istanza quantità
	 */
	private int quant;
	
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
}
