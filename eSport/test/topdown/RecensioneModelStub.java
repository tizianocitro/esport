package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.RecensioneBean;

public class RecensioneModelStub {
	static Logger log=Logger.getLogger("RecensioneModelStubDebugger");
	
	public RecensioneModelStub() {
		
	}
	
	public Set<RecensioneBean> doRetrieveAll() {
		LinkedHashSet<RecensioneBean> recensioni=new LinkedHashSet<RecensioneBean>();
		String commento="Prodotto molto interessante che mi ha soddisfatto al massimo. Consiglio a tutti l'acquisto!";
		
		RecensioneBean recensioneOne=new RecensioneBean();
		recensioneOne.setProdotto("001");
		recensioneOne.setUsername("PaoloG");
		recensioneOne.setVoto(9);
		recensioneOne.setCommento(commento);
		recensioni.add(recensioneOne);
		
		return recensioni;
	}
	
	public Set<RecensioneBean> doRetrieveByProdotto(String codiceProdotto) {
		LinkedHashSet<RecensioneBean> recensioni=(LinkedHashSet<RecensioneBean>) doRetrieveAll();

		LinkedHashSet<RecensioneBean> recensioniProdotto=new LinkedHashSet<RecensioneBean>();
		
		for(RecensioneBean recensione: recensioni) {
			if(recensione.getProdotto().equals(codiceProdotto))
				recensioniProdotto.add(recensione);
		}
		
		return recensioniProdotto;
	}
}
