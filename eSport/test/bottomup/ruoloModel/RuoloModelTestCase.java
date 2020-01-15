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
	
	@Override
	public void setUp() {
		ruoloModel=new RuoloModel();
	}
	
	//Test doRetrieveByUtente
	public void doRetrieveByUtente() throws SQLException {	
		//Caso corretto
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
		
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		//Verifico caso corretto
		assertFalse(ruoli.isEmpty());
		assertNotNull(ruoli);
		
		//Caso errato
		ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(null);
		
		//Verifico caso errato
		assertNull(ruoli);
	}
	
	//Test doSave
	public void doSave() throws SQLException {
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");
		
		//Creo ruolo da salvare
		RuoloBean ruolo=new RuoloBean();
		
		//Caso corretto
		ruolo.setUsername("CarloRaucci");
		ruolo.setPermesso("Catalogo");
		
		//Salvo il ruolo
		ruoloModel.doSave(ruolo);
		
		//Ottengo i ruoli
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		//Verifico caso corretto
		assertNotNull(ruoli);
		assertFalse(ruoli.isEmpty());
		assertTrue(ruoli.containsKey(ruolo.getPermesso()));
		
		//Caso errato
		ruolo.setUsername("");
		ruolo.setPermesso("");
		
		//Salvo il ruolo
		ruoloModel.doSave(ruolo);
		
		//Ottengo i ruoli
		ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		//Verifico caso errato
		assertFalse(ruoli.containsKey(ruolo.getPermesso()));
	}
	
	private RuoloModel ruoloModel;

}
