package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.IndirizzoBean;
import beans.UtenteBean;

public class IndirizzoModelStub {
	static Logger log=Logger.getLogger("IndirizzoModelStubDebugger");
	
	public IndirizzoModelStub() {
		
	}
	
	public Set<IndirizzoBean> doRetrieveByUtente(UtenteBean user, int codice){
		LinkedHashSet<IndirizzoBean> indirizzi=new LinkedHashSet<IndirizzoBean>();

		IndirizzoBean indOne=new IndirizzoBean();
		indOne.setCodice(codice);
		indOne.setUsername(user.getUsername());
		indOne.setCap("84096");
		indOne.setCitta("Salerno");
		indOne.setCivico("67");
		indOne.setVia("Via Tullio Maratea");
		indirizzi.add(indOne);
		
		codice++;

		IndirizzoBean indTwo=new IndirizzoBean();
		indTwo.setCodice(codice);
		indTwo.setUsername(user.getUsername());
		indTwo.setCap("84092");
		indTwo.setCitta("Napoli");
		indTwo.setCivico("46");
		indTwo.setVia("Via Ponzio Pilato");
		indirizzi.add(indTwo);
		
		return indirizzi;
	}
}
