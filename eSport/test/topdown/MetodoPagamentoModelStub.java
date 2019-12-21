package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.MetodoPagamentoBean;
import beans.UtenteBean;

public class MetodoPagamentoModelStub {
	static Logger log=Logger.getLogger("MetodoPagamentoModelStubDebugger");
	
	public MetodoPagamentoModelStub() {
		
	}
	
	public Set<MetodoPagamentoBean> doRetrieveByUtente(UtenteBean user, int codice){
		LinkedHashSet<MetodoPagamentoBean> metodi=new LinkedHashSet<MetodoPagamentoBean>();

		MetodoPagamentoBean metPagOne=new MetodoPagamentoBean();
		metPagOne.setCodice(codice);
		metPagOne.setUsername(user.getUsername());
		metPagOne.setTipo("Postepay");
		metPagOne.setNumero("1378122267340911");
		metodi.add(metPagOne);
		
		codice++;
		
		MetodoPagamentoBean metPagTwo=new MetodoPagamentoBean();
		metPagTwo.setCodice(codice);
		metPagTwo.setUsername(user.getUsername());
		metPagTwo.setTipo("Postepay");
		metPagTwo.setNumero("1378134767340924");
		metodi.add(metPagTwo);
		
		return metodi;
	}
}
