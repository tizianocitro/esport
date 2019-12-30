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
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
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
	}
	
	/**
	 * Permette di ottenere i ruoli assegnati ad un utente
	 * @param user
	 * @return ruoli
	 * @throws SQLException 
	 */
	public Map<String, RuoloBean> doRetrieveByUtente(UtenteBean utente) throws SQLException{
		LinkedHashMap<String, RuoloBean> ruoli=new LinkedHashMap<String, RuoloBean>();

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
		
		return ruoli;
	}
}
