package model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.RecensioneBean;

public class RecensioneModel {
	static Logger log=Logger.getLogger("RecensioneModelDebugger");

	public RecensioneModel() {
		
	}

	/**
	 * Permette di salvare una recensione
	 * @param recensione
	 */
	public void doSave(RecensioneBean recensione) {
		
	}
	
	/**
	 * Permette di ottenere le recensioni di un prodotto specificando un ordine di restituzione
	 * @param codiceProdotto
	 * @return recensioni
	 */
	public Set<RecensioneBean> doRetrieveByProdotto(String codiceProdotto, String order) {
		LinkedHashSet<RecensioneBean> recensioni=new LinkedHashSet<RecensioneBean>();

		return recensioni;
	}
	
	/**
	 * Permette di gestire i caratteri speciali nel commento di una recensione prima di memorizzarla
	 * @param commento
	 * @return commentoFiltrato
	 */
	public String correzzione(String commento) {
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
