package model;

import java.util.logging.Logger;

import beans.UtenteBean;

public class UtenteModel {
	static Logger log=Logger.getLogger("UtenteModelDebugger");

	public UtenteModel() {
		
	}

	/**
	 * Permette di salvare un utente
	 * @param utente
	 */
	public void doSave(UtenteBean utente) {
		
	}
	
	/**
	 * Permette di verificare che l'utente si sia registrato con username e password specificati
	 * @param user
	 * @return utente validato
	 */
	public UtenteBean validate(UtenteBean utente) {
		
		return null;
	}
	
	/**
	 * Permette di ottenere un utente specificandone l'username
	 * @param username
	 * @return utente
	 */
	public UtenteBean doRetrieveByUsername(String username) {
		
		return null;
	}
	
	/**
	 * Permette di aggiornare i dati di un utente memorizzato
	 * @param utente
	 */
	public void doUpdate(UtenteBean utente) {
		
	}
	
	/**
	 * Permette di eliminare un utente
	 * @param utente
	 */
	public void doDelete(UtenteBean utente) {
		
	}
	
}
