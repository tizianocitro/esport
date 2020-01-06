package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import beans.RuoloBean;
import beans.UtenteBean;

public class RuoloModel {
	private static final String TABLE_NAME="ruolo";
	static Logger log=Logger.getLogger("RuoloModelDebugger");

	public RuoloModel() {
		
	}

	/**
	 * Permette di salvare un ruolo
	 * @param ruolo
	 * @throws SQLException 
	 */
	public void doSave(RuoloBean ruolo) throws SQLException {
		log.info("RuoloModel -> doSave");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("RuoloModel -> verifico la correttezza del ruolo da salvare");
		if(ruolo==null || ruolo.getUsername()==null || ruolo.getUsername().equals("")
				|| ruolo.getPermesso()==null || ruolo.getPermesso().equals(""))
			return;
		
		String insertSQL="insert into " + RuoloModel.TABLE_NAME
				+ " (usr, permesso) "
				+ "values (?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, ruolo.getUsername());
			preparedStatement.setString(2, ruolo.getPermesso());

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
		log.info("RuoloModel -> doSave terminato");
	}
	
	/**
	 * Permette di ottenere i ruoli assegnati ad un utente
	 * @param user
	 * @return ruoli
	 * @throws SQLException 
	 */
	public Map<String, RuoloBean> doRetrieveByUtente(UtenteBean utente) throws SQLException{
		log.info("RuoloModel -> doRetrieveByUtente");
		LinkedHashMap<String, RuoloBean> ruoli=new LinkedHashMap<String, RuoloBean>();

		log.info("RuoloModel -> verifico che l'username dell'utente sia corretto");
		if(utente==null || utente.getUsername()==null || utente.getUsername().equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="select * from " + RuoloModel.TABLE_NAME + " where usr=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente.getUsername());

			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
					RuoloBean bean=new RuoloBean();
				
					bean.setUsername(rs.getString("usr"));
					bean.setPermesso(rs.getString("permesso"));
					
					ruoli.put("" + bean.getPermesso(), bean);
			}
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
		log.info("Ho ottenuto i ruoli, ruoli vuota: " + ruoli.isEmpty());
		
		return ruoli;
	}
}
