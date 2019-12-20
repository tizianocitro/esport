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
	
	public Set<IndirizzoBean> doRetrieveByUtente(UtenteBean user){
		LinkedHashSet<IndirizzoBean> indirizzi=new LinkedHashSet<IndirizzoBean>();

		IndirizzoBean indOne=new IndirizzoBean();
		indOne.setUsername(user.getUsername());
		indOne.setCap("84096");
		indOne.setCitta("Salerno");
		indOne.setCivico("67");
		indOne.setVia("Via Tullio Maratea");
		indirizzi.add(indOne);
		
		IndirizzoBean indTwo=new IndirizzoBean();
		indTwo.setUsername(user.getUsername());
		indTwo.setCap("84092");
		indTwo.setCitta("Napoli");
		indTwo.setCivico("46");
		indTwo.setVia("Via Ponzio Pilato");
		indirizzi.add(indTwo);
		
		return indirizzi;
	}
}
