package topdown;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.logging.Logger;

import beans.IndirizzoBean;
import beans.MetodoPagamentoBean;
import beans.RuoloBean;
import beans.UtenteBean;

public class UtenteModelStub {
	static Logger log=Logger.getLogger("UtenteModelStubDebugger");
	
	public UtenteModelStub() {
		
	}
	
	public UtenteBean validate(UtenteBean user) {
		log.info("Metodo: validate -> metodo: doRetrieveAll");
		LinkedHashMap<String, UtenteBean> users=(LinkedHashMap<String, UtenteBean>) doRetrieveAll();
		
		log.info("Comincio scorrimento");
		for(UtenteBean utente: users.values()) {
			if(utente.getUsername().equals(user.getUsername()) && utente.getPassword().equals(user.getPassword())) {
				log.info("utente restituito: " + utente.getUsername() + ", pwd: " + utente.getPassword());
				
				return utente;
			}
		}
		
		return null;
	}
	
	public Map<String, UtenteBean> doRetrieveAll(){
		log.info("Metodo: doRetrieveAll -> UtenteModelStub");
		RuoloModelStub ruoloModel=new RuoloModelStub();
		IndirizzoModelStub indirizzoModel=new IndirizzoModelStub();
		MetodoPagamentoModelStub metPagModel=new MetodoPagamentoModelStub();

		LinkedHashMap<String, UtenteBean> users=new LinkedHashMap<String, UtenteBean>();
		String pIva="11111111111";
		String tel="3391771608";
		
		log.info("Creo l'utente Paolo");
		UtenteBean paolo=new UtenteBean();
		paolo.setUsername("PaoloG");
		paolo.setPassword("paolopwd");
		paolo.setNome("Paolo");
		paolo.setCognome("Gioconda");
		paolo.setEmail("paolog@gmail.com");
		paolo.setPiva(pIva);
		paolo.setTelefono(tel);
		
		log.info("Ottengo indirizzi per Paolo");
		LinkedHashSet<IndirizzoBean> indirizziPaolo=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(paolo, 1);
		for(IndirizzoBean indirizzo: indirizziPaolo)
			paolo.addIndirizzo(indirizzo);
		
		log.info("Ottengo metodi di pagamento per Paolo");
		LinkedHashSet<MetodoPagamentoBean> metodiPaolo=(LinkedHashSet<MetodoPagamentoBean>) metPagModel.doRetrieveByUtente(paolo, 1);
		for(MetodoPagamentoBean metodo: metodiPaolo)
			paolo.addMetPag(metodo);
		
		log.info("Ottengo ruoli per Paolo");
		LinkedHashMap<String, RuoloBean> ruoli=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(paolo);
		paolo.addRuolo(ruoli.get("Utente"));

		log.info("Inserisco: " + paolo.getUsername() + ", " + paolo.getPassword());
		users.put("" + paolo.getUsername(), paolo);
		
		log.info("Creo l'utente root");
		UtenteBean root=new UtenteBean();
		root.setUsername("root");
		root.setPassword("root");
		root.setNome("Amministratore");
		root.setCognome("Globale");
		root.setEmail("root@esport.com");
		root.setPiva(pIva);
		root.setTelefono(tel);
		
		log.info("Ottengo indirizzi per root");
		LinkedHashSet<IndirizzoBean> indirizzi=(LinkedHashSet<IndirizzoBean>) indirizzoModel.doRetrieveByUtente(root, 3);
		for(IndirizzoBean indirizzo: indirizzi)
			root.addIndirizzo(indirizzo);
		
		log.info("Ottengo metodi di pagamento per root");
		LinkedHashSet<MetodoPagamentoBean> metodi=(LinkedHashSet<MetodoPagamentoBean>) metPagModel.doRetrieveByUtente(root, 3);
		for(MetodoPagamentoBean metodo: metodi)
			root.addMetPag(metodo);
		
		log.info("Ottengo ruoli per root");
		LinkedHashMap<String, RuoloBean> ruoliRoot=(LinkedHashMap<String, RuoloBean>) ruoloModel.doRetrieveByUtente(root);
		root.addRuolo(ruoliRoot.get("Utente"));
		root.addRuolo(ruoliRoot.get("Catalogo"));
		root.addRuolo(ruoliRoot.get("Ordini"));
		
		log.info("Inserisco: " + root.getUsername() + ", " + root.getPassword());
		users.put("" + root.getUsername(), root);

		return users;
	}
	
	public UtenteBean doRetrieveByUsername(String username) {
		log.info("Metodo: doRetrieveByUsername -> metodo: doRetrieveAll");
		LinkedHashMap<String, UtenteBean> users=(LinkedHashMap<String, UtenteBean>) doRetrieveAll();
		
		log.info("Comincio scorrimento");
		for(UtenteBean utente: users.values()) {
			if(utente.getUsername().equals(username)) {
				log.info("utente restituito: " + utente.getUsername());
				
				return utente;
			}
		}
		
		return null;
	}
}
