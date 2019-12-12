package beans;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Costruttore di default
 */
public class CarrelloBean {
	public CarrelloBean() {
		carrello=new HashSet<CarrelloItem>();
	}
	
	/**
	 * 
	 * @param carrello item
	 */
	public void addProdotto(CarrelloItem ci) {
		carrello.add(ci);
	}
	
	/**
	 * 
	 * @param carrello item
	 */
	public void removeProdotto(CarrelloItem ci) {
		carrello.remove(ci);
	}
	
	/**
	 * 
	 * @return carrello
	 */
	public Collection<CarrelloItem> getCart() {
		return carrello;
	}

	/**
	 * 
	 * @param carrello
	 */
	public void setCart(Set<CarrelloItem> carrello) {
		this.carrello=carrello;
	}

	/**
	 * 
	 * @return vuoto / non vuoto
	 */
	public boolean isEmpty() {
		if(carrello.size()==0)
			return true;
		
		return false;
	}
	
	/**
	 * Variabile d'istanza carrello
	 */
	private Set<CarrelloItem> carrello;
}
