package bottomup.recensioneModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.ProdottoBean;
import beans.RecensioneBean;
import junit.framework.TestCase;
import model.RecensioneModel;

public class RecensioneModelTestCase extends TestCase {
	public RecensioneModelTestCase(String nome) {
		super(nome);
	}
	
	@Override
	public void setUp() {
		recensioneModel=new RecensioneModel();
	}
	
	public void doSave() throws SQLException {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("002");

		//Creo la taglia
		RecensioneBean recensione=new RecensioneBean();
		
		//Caso corretto
		recensione.setProdotto(prodotto.getCodice());
		recensione.setUsername("root");
		recensione.setVoto(7);
		String commento="Prodotto molto interessante che mi ha soddisfatto al massimo. Consiglio a tutti l'acquisto!";
		recensione.setCommento(commento);
		
		recensioneModel.doSave(recensione);
				
		LinkedHashSet<RecensioneBean> recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto(prodotto.getCodice(), "");
				
		//Verifico caso corretto
		assertFalse(recensioni.isEmpty());
		assertNotNull(recensioni);
				
		//Casi errato
		//Primo caso, voto errato
		recensione.setVoto(0);
				
		recensioneModel.doSave(recensione);
				
		recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto(prodotto.getCodice(), "");
				
		//Verifico caso corretto
		assertFalse(recensioni.contains(recensione));
		
		//Secondo caso, commento errato
		recensione.setCommento("");
		
		recensioneModel.doSave(recensione);
		
		recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto(prodotto.getCodice(), "");
				
		//Verifico caso corretto
		assertFalse(recensioni.contains(recensione));
	}
	
	public void doRetrieveByProdotto() throws SQLException {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
				
		//Caso corretto
		LinkedHashSet<RecensioneBean> recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto(prodotto.getCodice(), "");

		//Verifico caso corretto
		assertFalse(recensioni.isEmpty());
		assertNotNull(recensioni);
				
		//Caso errato
		recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto("", "");

		//Verifico caso corretto
		assertNull(recensioni);
	}
	
	private RecensioneModel recensioneModel;
}
