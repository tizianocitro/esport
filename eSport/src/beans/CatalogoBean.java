package beans;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class CatalogoBean {
	/**
	 * Costruttore di default
	 */
	public CatalogoBean() {
		this.catalogo=new LinkedHashSet<ProdottoBean>();
	}
	
	/**
	 * 
	 * @return catalogo
	 */
	public Collection<ProdottoBean> getCatalogo() {
		return catalogo;
	}

	/**
	 * 
	 * @param catalogo
	 */
	public void setCatalogo(Set<ProdottoBean> catalogo) {
		this.catalogo=catalogo;
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void addProdotto(ProdottoBean prodotto) {
		catalogo.add(prodotto);
	}
	
	/**
	 * 
	 * @param prodotto
	 */
	public void removeProdotto(ProdottoBean prodotto) {
		catalogo.remove(prodotto);
	}
	
	/**
	 * 
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
