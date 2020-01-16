package bottomup.ordineModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.ComposizioneBean;
import beans.OrdineBean;
import beans.UtenteBean;
import junit.framework.TestCase;
import model.OrdineModel;

public class OrdineModelTestCase extends TestCase {
	public OrdineModelTestCase(String name) {
		super(name);
	}

	@Override
	public void setUp() {
		ordineModel=new OrdineModel();
		
		ordineTest=new OrdineBean();
		ordineTest.setNumero("000001");
		ordineTest.setIndirizzo(1);
		ordineTest.setPagamento(1);
		ordineTest.setStato(OrdineBean.ELABORAZIONE);
		ordineTest.setUsername("root");
		ordineTest.setTotale(99.99);
		ordineTest.setSottomissione("2020-01-16");
		ordineTest.setConsegna("2020-01-19");
	}
	
	//Test doRetrieveByNumero
	public void doRetrieveByNumero() throws SQLException {
		//Caso corretto
		assertNotNull(ordineModel.doRetrieveByNumero(ordineTest.getNumero()));
		
		//Caso errato
		assertNull(ordineModel.doRetrieveByNumero(""));
	}
	
	//Test doRetrieveAll
	public void doRetrieveAll() throws SQLException {
		assertNotNull(ordineModel.doRetrieveAll(""));
	}
	
	//Test doSave
	public void doSave() throws SQLException {
		//Creo una composizione
		ComposizioneBean comp=new ComposizioneBean();
		comp.setOrdine(ordineTest.getNumero());
		comp.setProdotto("001");
		comp.setIvaVen(22);
		comp.setPrezzoVen(99.99);
		comp.setNomeProdotto("Divisa Home Real Madrid");
		comp.setQt(1);
		comp.setTaglia("M");
		
		//Aggiungo composizone all'ordine
		ordineTest.addProdotto(comp);
		
		//Caso corretto
		ordineModel.doSave(ordineTest);
		
		//Verifico caso corretto
		assertNotNull(ordineModel.doRetrieveByNumero(ordineTest.getNumero()));
		
		//Caso errato
		OrdineBean ordine=new OrdineBean();
		
		ordineModel.doSave(ordine);
		
		//Verifico caso errato
		assertNull(ordineModel.doRetrieveByNumero(ordine.getNumero()));
	}
	
	//Test doRetrieveByUtente
	public void doRetrieveByUtente() throws SQLException {
		//Caso corretto

		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
		
		assertNotNull(ordineModel.doRetrieveByUtente(user, ""));
		
		//Caso errato
		assertNull(ordineModel.doRetrieveByUtente(null, ""));
	}
	
	//Test doRetrieveIfAttivi
	public void doRetrieveIfAttivi() throws SQLException {
		//Caso corretto
		LinkedHashSet<OrdineBean> ordini=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveIfAttivi("");
		
		//Verifico caso corretto
		assertNotNull(ordini);
		
		for(OrdineBean o: ordini)
			assertFalse(o.getStato().equals(OrdineBean.CONSEGNATO));
	}
	
	//Test aggiornaStato
	public void aggiornaStato() throws SQLException {
		//Imposto delle modifiche
		ordineTest.setStato(OrdineBean.SPEDIZIONE);
		
		ordineModel.aggiornaStato(ordineTest);
		
		OrdineBean ordine=ordineModel.doRetrieveByNumero(ordineTest.getNumero());

		assertTrue(ordine.getStato().equals(OrdineBean.SPEDIZIONE));
	}
	
	private OrdineModel ordineModel;
	private OrdineBean ordineTest;
}
