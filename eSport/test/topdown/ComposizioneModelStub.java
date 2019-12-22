package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ComposizioneBean;
import beans.OrdineBean;

public class ComposizioneModelStub {
	static Logger log=Logger.getLogger("ComposizioneModelStubDebugger");
	
	public ComposizioneModelStub() {
		
	}
	
	public Set<ComposizioneBean> doRetrieveByOrdine(OrdineBean ordine){
		LinkedHashSet<ComposizioneBean> comp=new LinkedHashSet<ComposizioneBean>();
		
		ComposizioneBean compOne=new ComposizioneBean();
		compOne.setOrdine(ordine.getNumero());
		compOne.setProdotto("001");
		compOne.setNomeProdotto("Divisa Home Real Madrid");
		compOne.setPrezzoVen(99.99);
		compOne.setIvaVen(22);
		compOne.setQt(1);
		compOne.setTaglia("S");
		comp.add(compOne);
		
		return comp;
	}
	
	public void doSave(ComposizioneBean composizione) {
		
	}
}
