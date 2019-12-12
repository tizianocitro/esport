package beans;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class CarrelloBean {
	public CarrelloBean() {
		cart=new HashSet<CarrelloItem>();
	}
	
	public void addProdotto(CarrelloItem ci) {
		cart.add(ci);
	}
	
	public void removeProdotto(CarrelloItem ci) {
		cart.remove(ci);
	}
	
	public Collection<CarrelloItem> getCart() {
		return cart;
	}

	public void setCart(Set<CarrelloItem> cart) {
		this.cart=cart;
	}

	public boolean isEmpty() {
		if(cart.size()==0)
			return true;
		
		return false;
	}
	
	private Set<CarrelloItem> cart;
}
