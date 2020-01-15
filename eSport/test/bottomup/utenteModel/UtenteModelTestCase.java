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
	
	//Test doSave
	public void doSave() throws SQLException {
		//Caso corretto
		utenteModel.doSave(utenteTest);
		
		//Verifico caso corretto
		assertNotNull(utenteModel.doRetrieveByUsername(utenteTest.getUsername()));
		
		//Caso errato
		UtenteBean utenteErrato=new UtenteBean();
		
		utenteModel.doSave(utenteErrato);
		
		//Verifico caso errato
		assertNull(utenteModel.doRetrieveByUsername(utenteErrato.getUsername()));
	}
	
	//Test validate
	public void validate() throws SQLException {
		//Caso corretto
		UtenteBean validato=utenteModel.validate(utenteTest);
		
		//Verifico caso corretto
		assertNotNull(validato);
		
		//Casi errati
		//Primo test
		validato=utenteModel.validate(null);
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
	
	//Test doRetrieveByUsername
	public void doRetrieveByUsername() throws SQLException {
		//Caso corretto
		UtenteBean user=utenteModel.doRetrieveByUsername(utenteTest.getUsername());
		
		//Verifico caso corretto
		assertNotNull(user);
		
		//Caso errato
		user=utenteModel.doRetrieveByUsername("");
		
		//Verifico caso errato
		assertNull(user);
	}
	
	//Test doUpdate
	public void doUpdate() throws SQLException {
		//Caso corretto
		//Imposto delle modifiche
		utenteTest.setNome("Tiziano");
		assertTrue(utenteModel.doUpdate(utenteTest));

		//Caso errato
		assertFalse(utenteModel.doUpdate(null));

	}
	
	//Test doDelete
	public void doDelete() throws SQLException {		
		assertTrue(utenteModel.doDelete(utenteTest));
	}
	
	private UtenteModel utenteModel;
	private UtenteBean utenteTest;
}
