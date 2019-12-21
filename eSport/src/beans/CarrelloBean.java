package beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Questa classe modella il carrello per un utente
 */
public class CarrelloBean {
	
	/**
	 * Costruttore di default
	 */
	public CarrelloBean() {
		carrello=new LinkedHashSet<CarrelloItem>();
	}
	
	/**
	 * Permette di inserire un elemento nel carrello
	 * @param carrello item
	 */
	public void addProdotto(CarrelloItem carrelloItem) {
		carrello.add(carrelloItem);
	}
	
	/**
	 * Permette di inserire un elemento nel carrello se già presente aumentandone la quantità senza reinserirlo
	 * @param carrello item
	 */
	public void reAddProdotto(CarrelloItem carrelloItem) {
		for(CarrelloItem item: carrello) {
			if(item.equals(carrelloItem))
				item.setQt(item.getQt() + 1);
		}
	}
	
	/**
	 * Permette di ottenere un elemento dal carrello specificando il codice del prodotto da ottenere
	 * @param codiceProdotto
	 * @return carrello item
	 */
	public CarrelloItem getProdotto(String codiceProdotto) {
		for(CarrelloItem item: carrello) {
			if(item.getProdotto().getCodice().equals(codiceProdotto))
				return item;
		}
		
		return null;
	}
	
	/**
	 * Permette di rimuovere un elemento dal carrello
	 * @param carrello item
	 */
	public void removeProdotto(CarrelloItem carrelloItem) {
		ArrayList<CarrelloItem> array=new ArrayList<CarrelloItem>();
		for(CarrelloItem item: carrello) {
			array.add(item);
		}
		
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).equals(carrelloItem))
				array.remove(i);
		}
		
		svuotaCarrello();
		
		for(CarrelloItem item: array)
			carrello.add(item);
	}
	
	/**
	 * Permette di ottenere il valore della variabile d'istanza che modella il carrello
	 * @return carrello
	 */
	public Set<CarrelloItem> getCarrello() {
		return carrello;
	}

	/**
	 * Permette di modificare il valore della variabile d'istanza che modella il carrello
	 * @param carrello
	 */
	public void setCarrello(Set<CarrelloItem> carrello) {
		this.carrello=carrello;
	}

	/**
	 * Permette di modificare la quantità di un elemento nel carrello aumentandola o diminuiendola di un'unita
	 * @param codiceProdotto
	 * @param action
	 */
	public void modificaQt(String codiceProdotto, String taglia, String action) {
		for(CarrelloItem item: carrello) {
			if(item.getProdotto().getCodice().equals(codiceProdotto) 
					&& item.getTaglia().equals(taglia))
				if(action.equals("plus"))
					item.setQt(item.getQt() + 1);
				else if(action.equals("minus")) {
					item.setQt(item.getQt() - 1);
				}
		}
	}
	
	/**
	 * Permette di sapere se il carrello è vuoto oppure no
	 * @return true se vuoto, altrimenti false
	 */
	public boolean isEmpty() {
		if(carrello.size()==0)
			return true;
		
		return false;
	}
	
	/**
	 * Permette di verificare che un elemento sia gia presente nel carrello
	 * @return true se il prodotto è già nel carrello, altrimenti false
	 */
	public boolean contains(CarrelloItem carrelloItem) {
		for(CarrelloItem item: carrello)
			if(item.equals(carrelloItem))
				return true;

		return false;
	}
	
	/**
	 * Permette di svuotare il carrello
	 */
	public void svuotaCarrello() {
		carrello.clear();
	}
	
	/**
	 * Variabile d'istanza carrello
	 */
	private Set<CarrelloItem> carrello;
}
