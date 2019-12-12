package beans;

import java.util.HashMap;
import java.util.Map;

public class CarrelloBean {
	
	/**
	 * Costruttore di default
	 */
	public CarrelloBean() {
		carrello=new HashMap<String, CarrelloItem>();
	}
	
	/**
	 * 
	 * @param carrello item
	 */
	public void addProdotto(CarrelloItem carrelloItem) {
		carrello.put("" + carrelloItem.getProdotto().getCodice(), carrelloItem);
	}
	
	/**
	 * 
	 * @param codiceProdotto
	 * @return carrello item
	 */
	public CarrelloItem getProdotto(String codiceProdotto) {
		return carrello.get(codiceProdotto);
	}
	
	/**
	 * 
	 * @param carrello item
	 */
	public void removeProdotto(CarrelloItem carrelloItem) {
		carrello.remove(carrelloItem.getProdotto().getCodice());
	}
	
	/**
	 * 
	 * @return carrello
	 */
	public Map<String, CarrelloItem> getCarrello() {
		return carrello;
	}

	/**
	 * 
	 * @param carrello
	 */
	public void setCarrello(Map<String, CarrelloItem> carrello) {
		this.carrello=carrello;
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
	 * Svuota il carrello
	 */
	public void svuotaCarrello() {
		carrello.clear();
	}
	
	/**
	 * Variabile d'istanza carrello
	 */
	private Map<String, CarrelloItem> carrello;
}
