package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.IndirizzoBean;
import beans.UtenteBean;

public class IndirizzoModel {
	private static final String TABLE_NAME="indirizzo";
	static Logger log=Logger.getLogger("IndirizzoModelDebugger");

	public IndirizzoModel() {
		
	}

	/**
	 * Permette di salvare un indirizzo
	 * @param indirizzo
	 * @throws SQLException 
	 */
	public void doSave(IndirizzoBean indirizzo) throws SQLException {
		log.info("IndirizzoModel -> doSave");
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doSave -> verifico la correttezza dell'indirizzo da salvare");
		if(indirizzo==null || indirizzo.getUsername()==null || indirizzo.getUsername().equals("")
				|| indirizzo.getCitta()==null || indirizzo.getCitta().equals("")
				|| indirizzo.getVia()==null || indirizzo.getVia().equals("")
				|| indirizzo.getCap()==null || indirizzo.getCap().equals("")
				|| indirizzo.getCivico()==null || indirizzo.getCivico().equals(""))
			return;
		
		log.info("doSave -> eseguo query");
		String insertSQL="insert into " + IndirizzoModel.TABLE_NAME
				+ " (usr, citta, via, civico, cap) "
				+ "values (?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, indirizzo.getUsername());
			preparedStatement.setString(2, indirizzo.getCitta());
			preparedStatement.setString(3, indirizzo.getVia());
			preparedStatement.setString(4, indirizzo.getCivico());
			preparedStatement.setString(5, indirizzo.getCap());

			preparedStatement.executeUpdate();

			connection.commit();
		} 
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}	 
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		log.info("IndirizzoModel -> doSave terminato");
	}
	
	/**
	 * Permette di ottenere gli indirizzi aggiunti da un utente
	 * @param user
	 * @return indirizzo
	 * @throws SQLException 
	 */
	public Set<IndirizzoBean> doRetrieveByUtente(UtenteBean utente) throws SQLException{
		log.info("IndirizzoModel -> doRetrieveByUtente");
		LinkedHashSet<IndirizzoBean> indirizzi=new LinkedHashSet<IndirizzoBean>();
	
		log.info("doRetrieveByUtente -> verifico che l'username dell'utente sia corretto");
		if(utente==null || utente.getUsername()==null || utente.getUsername().equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		log.info("doRetrieveByUtente -> eseguo query");
		String selectSQL = "select * from " + IndirizzoModel.TABLE_NAME + " where usr=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente.getUsername());

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				IndirizzoBean temp=new IndirizzoBean();
				
				temp.setCodice(rs.getInt("codice"));
				temp.setUsername(rs.getString("usr"));
				temp.setCitta(rs.getString("citta"));
				temp.setVia(rs.getString("via"));
				temp.setCivico(rs.getString("civico"));
				temp.setCap(rs.getString("cap"));
				
				indirizzi.add(temp);
			}
		} 
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		log.info("IndirizzoModel -> doRetrieveByUtente terminato");
		
		return indirizzi;
	}
	
	/**
	 * Permette di eleminare un indirizzo memorizzato
	 * @param indirizzo
	 * @throws SQLException 
	 */
	public boolean doDelete(IndirizzoBean indirizzo) throws SQLException {
		log.info("IndirizzoModel -> doDelete");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.info("doDelete -> controllo correttezza indirizzo");
		if(indirizzo==null)
			return false;
		
		int result=0;

		log.info("doDelete -> eseguo query");

		String deleteSQL="delete from " + IndirizzoModel.TABLE_NAME + " where codice=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, indirizzo.getCodice());

			result=preparedStatement.executeUpdate();
		} 
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} 
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		log.info("IndirizzoModel -> doDelete terminato");

		return (result!=0);
	}
}
