package bottomup.utenteModel;

import java.sql.SQLException;

import beans.UtenteBean;
import junit.framework.TestCase;
import model.UtenteModel;

public class UtenteModelTestCase extends TestCase {
	public UtenteModelTestCase(String nome) {
		super(nome);
	}

	@Override
	public void setUp() {
		utenteModel=new UtenteModel();

		//Creo l'utente
		utenteTest=new UtenteBean();
		utenteTest.setUsername("RaulCitro");
		utenteTest.setPassword("raulcitro");
		utenteTest.setNome("Raul");
		utenteTest.setCognome("Citro");
		utenteTest.setEmail("raulcitro@gmail.it");
		utenteTest.setTelefono("3321783520");
	}
	
	//Tests doSave
	public void doSaveCorretto() throws SQLException {
		utenteModel.doSave(utenteTest);
		
		assertNotNull(utenteModel.doRetrieveByUsername(utenteTest.getUsername()));
	}
	
	public void doSaveErrato() throws SQLException {
		UtenteBean utenteErrato=new UtenteBean();
		
		utenteModel.doSave(utenteErrato);
		
		assertNull(utenteModel.doRetrieveByUsername(utenteErrato.getUsername()));
	}
	//Fine test doSave
	
	//Tests validate
	public void validateCorretto() throws SQLException {
		UtenteBean validato=utenteModel.validate(utenteTest);
		
		assertNotNull(validato);
	}
	
	public void validateErrato() throws SQLException {
		//Primo test
		UtenteBean validato=utenteModel.validate(null);
		assertNull(validato);
		
		//Secondo test
		UtenteBean user=new UtenteBean();
		user.setUsername("");
		
		validato=utenteModel.validate(user);
		assertNull(validato);
		
		//Terzo test
		user.setUsername("Raulcitro");
		user.setPassword("");
		
		validato=utenteModel.validate(user);
		assertNull(validato);
	}
	//Fine tests validate
	
	//Tests doRetrieveByUsername
	public void doRetrieveByUsernameCorretto() throws SQLException {
		UtenteBean user=utenteModel.doRetrieveByUsername(utenteTest.getUsername());
		
		assertNotNull(user);
	}
	
	public void doRetrieveByUsernameErrato() throws SQLException {
		UtenteBean user=utenteModel.doRetrieveByUsername("");
		
		assertNull(user);
	}
	//Fine tests doRetrieveByUsername
	
	//Tests doDelete
	public void doUpdateCorretto() throws SQLException {
		utenteTest.setNome("Tiziano");
		assertTrue(utenteModel.doUpdate(utenteTest));
	}
	
	public void doUpdateErrato() throws SQLException {
		assertFalse(utenteModel.doUpdate(null));
	}
	//Fine tests doDelete
	
	//Tests doDelete
	public void doDeleteCorretto() throws SQLException {		
		assertTrue(utenteModel.doDelete(utenteTest));
	}
	//Fine tests doDelete
	
	private UtenteModel utenteModel;
	private UtenteBean utenteTest;
}
