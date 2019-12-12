package beans;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;

public class CatalogoBean {
	/**
	 * Costruttore di default
	 */
	public CatalogoBean() {
		this.catalogo=new HashSet<ProdottoBean>();
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
	 * Variabile d'istanza catalogo
	 */
	private Set<ProdottoBean> catalogo;
}
