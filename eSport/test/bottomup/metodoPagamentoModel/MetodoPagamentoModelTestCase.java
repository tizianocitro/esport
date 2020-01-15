package bottomup.metodoPagamentoModel;

import java.sql.SQLException;
import java.util.LinkedHashSet;

import beans.MetodoPagamentoBean;
import beans.UtenteBean;
import junit.framework.TestCase;
import model.MetodoPagamentoModel;

public class MetodoPagamentoModelTestCase extends TestCase {
	public MetodoPagamentoModelTestCase(String nome) {
		super(nome);
	}
	
	@Override
	public void setUp() {
		metodoPagamentoModel=new MetodoPagamentoModel();
		
		// Creo indirizzo da salvare
		metodo=new MetodoPagamentoBean();
		metodo.setUsername("CarloRaucci");
		metodo.setTipo("Paypal");
		metodo.setNumero("test-35262340931");
	}
	
	//Test doRetrieveByUtente
	public void doRetrieveByUtente() throws SQLException {	
		//Caso corretto
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("root");
			
		//Ottengo gli indirizzi dell'utente
		LinkedHashSet<MetodoPagamentoBean> metodi=(LinkedHashSet<MetodoPagamentoBean>) metodoPagamentoModel.doRetrieveByUtente(user);
			
		assertFalse(metodi.isEmpty());
		assertNotNull(metodi);
		
		//Caso errato
		//Ottengo gli indirizzi dell'utente
		metodi=(LinkedHashSet<MetodoPagamentoBean>) metodoPagamentoModel.doRetrieveByUtente(null);
			
		assertNull(metodi);
	}
	
	public void doSave() throws SQLException {
		//Creo l'utente
		UtenteBean user=new UtenteBean();
		user.setUsername("CarloRaucci");
		
		//Caso corretto
		metodoPagamentoModel.doSave(metodo);
		
		// Ottengo i metodi di pagamento
		LinkedHashSet<MetodoPagamentoBean> metodi=(LinkedHashSet<MetodoPagamentoBean>) metodoPagamentoModel.doRetrieveByUtente(user);

		//Verifico caso corretto
		assertNotNull(metodi);
		assertFalse(metodi.isEmpty());
		
		//Caso errato
		MetodoPagamentoBean metodo=new MetodoPagamentoBean();

		metodoPagamentoModel.doSave(metodo);
		
		// Ottengo i metodi di pagamento
		metodi=(LinkedHashSet<MetodoPagamentoBean>) metodoPagamentoModel.doRetrieveByUtente(user);

		//Verifico caso errato
		assertFalse(metodi.contains(metodo));
	}
	
	//Test doDelete
	public void doDelete() throws SQLException {
		assertFalse(metodoPagamentoModel.doDelete(metodo));
	}
	
	private MetodoPagamentoModel metodoPagamentoModel;
	private MetodoPagamentoBean metodo;
}
