package topdown;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.RecensioneBean;

public class RecensioneModelStub {
	static Logger log=Logger.getLogger("RecensioneModelStubDebugger");
	
	public RecensioneModelStub() {
		
	}
	
	public void doSave(RecensioneBean recensione) {
		
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
	
	/**
	 * Permette di gestire i caratteri speciali nel commento di una recensione prima di memorizzarla
	 * @param commento
	 * @return commentoFiltrato
	 */
	public String correzione(String commento) {
		if(!hasSpecialChars(commento)) {
			return commento;
		}

		StringBuilder commentoFiltrato = new StringBuilder(commento.length());
		char c;
		for(int i=0; i<commento.length(); i++) {
			c = commento.charAt(i);
			switch(c) {
			case '<': commentoFiltrato.append("&lt;"); break;
			case '>': commentoFiltrato.append("&gt;"); break;
			case '"': commentoFiltrato.append("&quot;"); break;
			case '&': commentoFiltrato.append("&amp;"); break;
			default: commentoFiltrato.append(c);
			}
		}
		return commentoFiltrato.toString();
	}

	/**
	 * Permette di verificare che il commento di una recensione contenga caratteri speciali
	 * @param input
	 * @return flag
	 */
	private boolean hasSpecialChars(String input) {
		boolean flag=false;
		
		if((input != null) && (input.length() > 0)) {
			char c;
			
			for(int i=0; i<input.length(); i++) {
				c = input.charAt(i);
				switch(c) {
				case '<': flag = true; break;
				case '>': flag = true; break;
				case '"': flag = true; break;
				case '&': flag = true; break;
				}
			}
		}

		return flag;
	}
}
