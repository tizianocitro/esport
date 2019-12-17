package beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CarrelloBean {
	
	/**
	 * Costruttore di default
	 */
	public CarrelloBean() {
		carrello=new LinkedHashSet<CarrelloItem>();
	}
	
	/**
	 * 
	 * @param carrello item
	 */
	public void addProdotto(CarrelloItem carrelloItem) {
		carrello.add(carrelloItem);
	}
	
	/**
	 */
	public void reAddProdotto(CarrelloItem carrelloItem) {
		for(CarrelloItem item: carrello) {
			if(item.equals(carrelloItem))
				item.setQt(item.getQt() + 1);
		}
	}
	
	/**
	 * 
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
	 * 
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
	 * 
	 * @return carrello
	 */
	public Set<CarrelloItem> getCarrello() {
		return carrello;
	}

	/**
	 * 
	 * @param carrello
	 */
	public void setCarrello(Set<CarrelloItem> carrello) {
		this.carrello=carrello;
	}

	/**
	 * 
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
	 * 
	 * @return true se vuoto, altrimenti false
	 */
	public boolean isEmpty() {
		if(carrello.size()==0)
			return true;
		
		return false;
	}
	
	/**
	 * 
	 * @return true se il prodotto è già nel carrello, altrimenti false
	 */
	public boolean contains(CarrelloItem carrelloItem) {
		for(CarrelloItem item: carrello)
			if(item.equals(carrelloItem))
				return true;

		return false;
	}
	
	/**
	 * Svuota il carrello
	 */
	public void svuotaCarrello() {
		carrello.clear();
	}
	
	/**
	 * Variabile d'istanza carrello
	 */
	private Set<CarrelloItem> carrello;
}
