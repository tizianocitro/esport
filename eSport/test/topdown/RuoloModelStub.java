package topdown;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import beans.RuoloBean;
import beans.UtenteBean;

public class RuoloModelStub {
	static Logger log=Logger.getLogger("RuoloModelStub");
	
	public RuoloModelStub() {
		
	}
	
	public Map<String, RuoloBean> doRetrieveByUtente(UtenteBean user){
		log.info("Metodo: doRetrieveByUtente");

		LinkedHashMap<String, RuoloBean> ruoli=new LinkedHashMap<String, RuoloBean>();
		
		RuoloBean utente=new RuoloBean();
		utente.setUsername(user.getUsername());
		utente.setPermesso("Utente");
		
		log.info("Inserisco ruolo: " + utente.getPermesso());
		ruoli.put(utente.getPermesso(), utente);
		
		RuoloBean catalogo=new RuoloBean();
		catalogo.setUsername(user.getUsername());
		catalogo.setPermesso("Catalogo");
	
		log.info("Inserisco ruolo: " + catalogo.getPermesso());
		ruoli.put(catalogo.getPermesso(), catalogo);
		
		RuoloBean ordini=new RuoloBean();
		ordini.setUsername(user.getUsername());
		ordini.setPermesso("Ordini");
		
		log.info("Inserisco ruolo: " + ordini.getPermesso());
		ruoli.put(ordini.getPermesso(), ordini);
		
		return ruoli;
	}
}
