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
	
	//Tests doRetrieveByUtente
	public void doRetrieveByUtenteCorretto() throws SQLException {	
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
		
		//Ottengo i ruoli dell'utente
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		assertFalse(ruoli.isEmpty());
		assertNotNull(ruoli);
	}
	
	public void doRetrieveByUtenteErrato() throws SQLException {	
		//Ottengo i ruoli dell'utente
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(null);
		
		assertNull(ruoli);
	}
	//Fine tests doRetrieveByUtente
	
	//Test doSave
	public void doSaveCorretto() throws SQLException {
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");
		
		//Creo ruolo da salvare
		RuoloBean ruolo=new RuoloBean();
		ruolo.setUsername("CarloRaucci");
		ruolo.setPermesso("Catalogo");
		
		//Salvo il ruolo
		ruoloModel.doSave(ruolo);
		
		//Ottengo i ruoli
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		//Verifico
		assertNotNull(ruoli);
		assertFalse(ruoli.isEmpty());
		assertTrue(ruoli.containsKey(ruolo.getPermesso()));
	}
	
	public void doSaveErrato() throws SQLException {
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");
		
		//Creo ruolo da salvare
		RuoloBean ruolo=new RuoloBean();
		ruolo.setUsername("");
		ruolo.setPermesso("");
		
		//Salvo il ruolo
		ruoloModel.doSave(ruolo);
		
		//Ottengo i ruoli
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(user);
		
		assertFalse(ruoli.containsKey(ruolo.getPermesso()));
	}
	//Fine test doSave
	
	private RuoloModel ruoloModel;

}
