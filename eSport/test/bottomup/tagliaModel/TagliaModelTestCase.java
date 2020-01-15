package bottomup.tagliaModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.ProdottoBean;
import beans.TagliaBean;
import junit.framework.TestCase;
import model.TagliaModel;

public class TagliaModelTestCase extends TestCase {
	public TagliaModelTestCase(String nome) {
		super(nome);
	}
	
	@Override
	public void setUp() {
		tagliaModel=new TagliaModel();
	}
	
	//Test doSave
	public void doSave() throws SQLException {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");

		//Creo la taglia
		TagliaBean taglia=new TagliaBean();

		//Caso corretto
		taglia.setProdotto(prodotto.getCodice());
		taglia.setMisura("XXL");
		
		tagliaModel.doSave(taglia);
		
		LinkedHashSet<TagliaBean> taglie=(LinkedHashSet<TagliaBean>) tagliaModel.doRetrieveByProdotto(prodotto.getCodice());
		
		//Verifico caso corretto
		assertFalse(taglie.isEmpty());
		assertNotNull(taglie);
		
		//Caso errato
		taglia.setProdotto("");
		taglia.setMisura("");
		
		tagliaModel.doSave(taglia);
		
		taglie=(LinkedHashSet<TagliaBean>) tagliaModel.doRetrieveByProdotto(prodotto.getCodice());
		
		//Verifico caso corretto
		assertFalse(taglie.contains(taglia));
	}
	
	//Test doRetrieveByProdotto
	public void doRetrieveByProdotto() throws SQLException {
		//Creo prodotto
		ProdottoBean prodotto=new ProdottoBean();
		prodotto.setCodice("001");
		
		//Caso corretto
		LinkedHashSet<TagliaBean> taglie=(LinkedHashSet<TagliaBean>) tagliaModel.doRetrieveByProdotto(prodotto.getCodice());

		//Verifico caso corretto
		assertFalse(taglie.isEmpty());
		assertNotNull(taglie);
		
		//Caso errato
		taglie=(LinkedHashSet<TagliaBean>) tagliaModel.doRetrieveByProdotto("");

		//Verifico caso corretto
		assertNull(taglie);
	}
	
	private TagliaModel tagliaModel;
}
