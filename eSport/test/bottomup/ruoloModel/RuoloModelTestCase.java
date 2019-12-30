package bottomup.ruoloModel;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import beans.RuoloBean;
import beans.UtenteBean;
import junit.framework.TestCase;
import model.RuoloModel;

public class RuoloModelTestCase extends TestCase {
	public RuoloModelTestCase(String nome) {
		super(nome);
	}
	
	public void doRetrieveByUtente() throws SQLException {
		RuoloModel ruoloModel=new RuoloModel();
		
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
		
		LinkedHashMap<String, RuoloBean> map=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		assertFalse(map.isEmpty());
	}
	
	public void doSave() throws SQLException {
		RuoloModel ruoloModel=new RuoloModel();
		
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");
		
		LinkedHashMap<String, RuoloBean> map=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		int size=map.size();
		
		RuoloBean ruolo=new RuoloBean();
		ruolo.setUsername("CarloRaucci");
		ruolo.setPermesso("Catalogo");
		
		ruoloModel.doSave(ruolo);
		
		LinkedHashMap<String, RuoloBean> saveMap=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		assertTrue(saveMap.size()>size);
	}
}
