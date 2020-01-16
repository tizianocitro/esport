package bottomup.composizioneModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.ComposizioneBean;
import beans.OrdineBean;
import junit.framework.TestCase;
import model.ComposizioneModel;
import model.OrdineModel;

public class ComposizioneModelTestCase extends TestCase {
	public ComposizioneModelTestCase(String name) {
		super(name);
	}
	
	@Override
	public void setUp() {
		composizioneModel=new ComposizioneModel();
	}
	
	public void doSave() throws SQLException {
		//Creo ordine
		OrdineModel ordineModel=new OrdineModel();
		
		//Creo un ordine
		OrdineBean ordine=new OrdineBean();
		ordine.setNumero("000002");
		ordine.setIndirizzo(1);
		ordine.setPagamento(1);
		ordine.setStato(OrdineBean.ELABORAZIONE);
		ordine.setUsername("root");
		ordine.setTotale(99.99);
		ordine.setSottomissione("2020-01-16");
		ordine.setConsegna("2020-01-19");
				
		ComposizioneBean comp=new ComposizioneBean();
		comp.setOrdine(ordine.getNumero());
		comp.setProdotto("001");
		comp.setIvaVen(22);
		comp.setPrezzoVen(99.99);
		comp.setNomeProdotto("Divisa Home Real Madrid");
		comp.setQt(1);
		comp.setTaglia("M");
		
		ordine.addProdotto(comp);
		
		//Salvo l'ordine
		ordineModel.doSave(ordine);
		
		//Caso corretto
		comp=new ComposizioneBean();
		comp.setOrdine(ordine.getNumero());
		comp.setProdotto("002");
		comp.setIvaVen(22);
		comp.setPrezzoVen(89.99);
		comp.setNomeProdotto("Divisa Home Napoli");
		comp.setQt(1);
		comp.setTaglia("L");
		
		composizioneModel.doSave(comp);
		
		LinkedHashSet<ComposizioneBean> composizioni=(LinkedHashSet<ComposizioneBean>) composizioneModel.doRetrieveByOrdine(ordine);
		
		assertNotNull(composizioni);
		assertFalse(composizioni.isEmpty());
		
		//Caso errato
		comp=null;
		composizioneModel.doSave(comp);
		
		composizioni=(LinkedHashSet<ComposizioneBean>) composizioneModel.doRetrieveByOrdine(ordine);
		
		assertFalse(composizioni.contains(comp));
	}
	
	public void doRetrieveByOrdine() throws SQLException {
		//Creo ordine
		OrdineBean ordine=new OrdineBean();
		ordine.setNumero("000002");
		
		//Caso corretto
		LinkedHashSet<ComposizioneBean> composizione=(LinkedHashSet<ComposizioneBean>) composizioneModel.doRetrieveByOrdine(ordine);
		
		assertNotNull(composizione);
		assertFalse(composizione.isEmpty());
		
		//Caso errato
		ordine.setNumero("");
		
		composizione=(LinkedHashSet<ComposizioneBean>) composizioneModel.doRetrieveByOrdine(ordine);
		
		assertNull(composizione);
	}
	
	private ComposizioneModel composizioneModel;
}
