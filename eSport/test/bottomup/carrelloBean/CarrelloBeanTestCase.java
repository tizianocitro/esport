package bottomup.carrelloBean;

import beans.CarrelloBean;
import beans.CarrelloItem;
import beans.ProdottoBean;
import junit.framework.TestCase;

public class CarrelloBeanTestCase extends TestCase {
	public CarrelloBeanTestCase(String name) {
		super(name);
	}

	@Override
	public void setUp() {
		carrello=new CarrelloBean();
	}
	
	@Override
	public void tearDown() {
		carrello.svuotaCarrello();
	}
	
	public void getProdotto() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		carrello.addProdotto(item);
		
		//Caso corretto
		assertNotNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Caso errato
		assertNull(carrello.getProdotto(null));
		
	}
	
	public void addProdotto() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Caso corretto
		carrello.addProdotto(item);
		
		assertNotNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Caso errato
		//Primo casp
		item.getProdotto().setCodice("");
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Secondo caso
		item.setTaglia("");;
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Terzo caso
		item.setQt(0);
		
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
	}
	
	public void reAddProdotto() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Caso corretto
		//Aggiungo prodotto prima volta
		carrello.reAddProdotto(item);
		
		CarrelloItem temp=carrello.getProdotto(item.getProdotto().getCodice());
		assertNotNull(temp);
		assertTrue(temp.getQt()==1);
		
		//Aggiungo prodotto seconda volta
		carrello.reAddProdotto(item);
		
		temp=carrello.getProdotto(item.getProdotto().getCodice());
		assertNotNull(temp);
		assertTrue(temp.getQt()==2);
		
		//Caso errato
		//Primo casp
		item.getProdotto().setCodice("");
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Secondo caso
		item.setTaglia("");;
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
		
		//Terzo caso
		item.setQt(0);
		
		carrello.addProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
	}
	
	public void removeProdotto() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Aggiungo prodotto
		carrello.reAddProdotto(item);
		
		//Caso corretto
		int size=carrello.getCarrello().size();
		
		carrello.removeProdotto(item);
		
		assertNull(carrello.getProdotto(item.getProdotto().getCodice()));
		assertTrue(carrello.getCarrello().size()<size);
		
		//Caso errato
		//Primo caso
		size=carrello.getCarrello().size();

		carrello.removeProdotto(item);
		
		assertTrue(carrello.getCarrello().size()==size);
		
		//Secondo caso
		size=carrello.getCarrello().size();

		carrello.removeProdotto(null);
		
		assertTrue(carrello.getCarrello().size()==size);
	}
	
	public void modificaQt() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Aggiungo prodotto
		carrello.reAddProdotto(item);
		
		//Caso corretto
		//Primo caso
		int qt=item.getQt();
		
		carrello.modificaQt(item.getProdotto().getCodice(), item.getTaglia(), CarrelloBean.ACTION_PLUS);
		
		assertTrue(item.getQt()==qt+1);
		
		//Caso errato
		//Primo caso		
		qt=item.getQt();
		
		carrello.modificaQt("", item.getTaglia(), CarrelloBean.ACTION_PLUS);
		
		assertTrue(item.getQt()==qt);
		
		//Secondo caso		
		qt=item.getQt();
		
		carrello.modificaQt(item.getProdotto().getCodice(), "", CarrelloBean.ACTION_PLUS);
		
		assertTrue(item.getQt()==qt);
		
		//Terzo caso
		qt=item.getQt();
		
		carrello.modificaQt(item.getProdotto().getCodice(), item.getTaglia(), "pls");
		
		assertTrue(item.getQt()==qt);
	}
	
	public void contains() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Aggiungo prodotto
		carrello.reAddProdotto(item);
		
		//Caso corretto
		assertTrue(carrello.contains(item));
		
		//Caso errato
		//Primo caso
		assertFalse(carrello.contains(null));
		
		//Secondo caso
		item.getProdotto().setCodice("");
		
		assertFalse(carrello.contains(item));
		
		//Terzo caso
		item.setTaglia("");
		
		assertFalse(carrello.contains(item));
	}
	
	public void svuotaCarrello() {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Creo item
		CarrelloItem item=new CarrelloItem();
		item.setProdotto(prodotto);
		item.setTaglia("L");
		
		//Aggiungo prodotto
		carrello.reAddProdotto(item);
		
		//Caso corretto
		carrello.svuotaCarrello();
		
		assertTrue(carrello.isEmpty());
	}
	
	private CarrelloBean carrello;
}
