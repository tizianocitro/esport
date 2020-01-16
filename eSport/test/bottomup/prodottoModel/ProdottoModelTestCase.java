package bottomup.prodottoModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.ProdottoBean;
import junit.framework.TestCase;
import model.ProdottoModel;

public class ProdottoModelTestCase extends TestCase {
	public ProdottoModelTestCase(String nome) {
		super(nome);
	}
	
	@Override
	public void setUp() {
		prodottoModel=new ProdottoModel();
		
		prodottoTest=new ProdottoBean();
		prodottoTest.setCodice("029");
		prodottoTest.setTipo("Divisa");
		prodottoTest.setIva(22);
		prodottoTest.setMarca("TestMarca");
		prodottoTest.setPrezzo(29.99);
		prodottoTest.setQt(29);
		prodottoTest.setNome("Divisa Home Test");
		prodottoTest.setDescrizione("Divisa Home per testing di ProdottoModel");
		
	}
	
	public void doRetrieveByCodice() throws SQLException {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		
		//Caso corretto
		prodotto.setCodice("001");
		
		//Verifico caso corretto
		assertNotNull(prodottoModel.doRetrieveByCodice(prodotto.getCodice()));
		
		//Caso errato
		prodotto.setCodice("");
		
		//Verifico caso errato
		assertNull(prodottoModel.doRetrieveByCodice(prodotto.getCodice()));
	}
	
	public void doSave() throws SQLException {
		//Caso corretto
		prodottoModel.doSave(prodottoTest);
		
		//Verifico caso corretto
		assertNotNull(prodottoModel.doRetrieveByCodice(prodottoTest.getCodice()));
		
		//Caso errato
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("");
		
		prodottoModel.doSave(prodotto);
		
		//Verifico caso errato
		assertNull(prodottoModel.doRetrieveByCodice(prodotto.getCodice()));
	}
	
	public void doRetrieveByTipo() throws SQLException {
		//Caso corretto
		LinkedHashSet<ProdottoBean> prodotti=(LinkedHashSet<ProdottoBean>) prodottoModel.doRetrieveByTipo("Divisa", "");
		
		//Verifico caso corretto
		assertNotNull(prodotti);
		
		//Caso errato
		prodotti=(LinkedHashSet<ProdottoBean>) prodottoModel.doRetrieveByTipo("", "");
		
		//Verifico caso errato
		assertNull(prodotti);
	}
	
	public void doUpdate() throws SQLException {
		//Caso corretto
		
		//Imposto delle modifiche
		prodottoTest.setDescrizione("doUpdate riuscito");
		prodottoTest.setQt(30);
		
		assertTrue(prodottoModel.doUpdate(prodottoTest));
		
		//Caso errato
		assertFalse(prodottoModel.doUpdate(null));
	}

	public void doDelete() throws SQLException {
		assertTrue(prodottoModel.doDelete(prodottoTest));
		
		assertFalse(prodottoModel.doDelete(null));
	}
	
	private ProdottoModel prodottoModel;
	private ProdottoBean prodottoTest;
}
