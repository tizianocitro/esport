package bottomup.indirizzoModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.IndirizzoBean;
import beans.UtenteBean;
import junit.framework.TestCase;
import model.IndirizzoModel;

public class IndirizzoModelTestCase extends TestCase {
	public IndirizzoModelTestCase(String nome) {
		super(nome);
	}

	@Override
	public void setUp() {
		indirizzoModel=new IndirizzoModel();
		
		// Creo indirizzo da salvare
		indirizzo=new IndirizzoBean();
		indirizzo.setUsername("CarloRaucci");
		indirizzo.setCitta("Salerno");
		indirizzo.setVia("Marco Ferrino");
		indirizzo.setCap("84096");
		indirizzo.setCivico("56");
	}

	//Test doRetrieveByUtente
	public void doRetrieveByUtente() throws SQLException {	
		//Caso corretto
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
			
		//Ottengo gli indirizzi dell'utente
		LinkedHashSet<IndirizzoBean> indirizzi=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(user);
			
		//Verifico caso corretto
		assertFalse(indirizzi.isEmpty());
		assertNotNull(indirizzi);
		
		//Caso errato
		//Ottengo gli indirizzi dell'utente
		indirizzi=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(null);
			
		//Verifico caso errato
		assertNull(indirizzi);
	}
	
	// Test doSave
	public void doSave() throws SQLException {
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");

		//Caso corretto
		//Salvo l'indirizzo
		indirizzoModel.doSave(indirizzo);

		// Ottengo gli indirizzi
		LinkedHashSet<IndirizzoBean> indirizzi=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(user);

		//Verifico caso corretto
		assertNotNull(indirizzi);
		assertFalse(indirizzi.isEmpty());

		//Caso errato
		//Creo indirizzo da salvare
		IndirizzoBean indirizzo=new IndirizzoBean();

		//Salvo l'indirizzo
		indirizzoModel.doSave(indirizzo);

		//Ottengo gli indirizzi
		indirizzi=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(user);

		//Verifico caso errato
		assertFalse(indirizzi.contains(indirizzo));
	}

	//Test doDelete
	public void doDelete() throws SQLException {
		assertTrue(indirizzoModel.doDelete(indirizzo));
	}
	
	private IndirizzoModel indirizzoModel;
	private IndirizzoBean indirizzo;
}
