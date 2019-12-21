package beans;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Questa classe modella il catalogo
 */

public class CatalogoBean {
	
	/**
	 * Costruttore di default
	 */
	public CatalogoBean() {
		this.catalogo=new LinkedHashSet<ProdottoBean>();
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il catalogo
	 * @return catalogo
	 */
	public Collection<ProdottoBean> getCatalogo() {
		return catalogo;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il catalogo
	 * @param catalogo
	 */
	public void setCatalogo(Set<ProdottoBean> catalogo) {
		this.catalogo=catalogo;
	}

	/**
	 * Permette di aggiungere un prodotto al catalogo
	 * @param prodotto
	 */
	public void addProdotto(ProdottoBean prodotto) {
		catalogo.add(prodotto);
	}
	
	/**
	 * Permette di rimuovere un prodotto dal catalogo
	 * @param prodotto
	 */
	public void removeProdotto(ProdottoBean prodotto) {
		catalogo.remove(prodotto);
	}
	
	/**
	 * Permette di ottenere un prodotto presente nel catalogo specificando il codice del prodotto
	 * @param codiceProdotto
	 * @return prodotto
	 */
	public ProdottoBean getProdotto(String codiceProdotto) {
		for(ProdottoBean prodotto: catalogo)
			if(prodotto.getCodice().equals(codiceProdotto))
				return prodotto;
		
		return null;
	}
	
	/**
	 * Variabile d'istanza catalogo
	 */
	private Set<ProdottoBean> catalogo;
}
