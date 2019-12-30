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
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertSQL="insert into " + IndirizzoModel.TABLE_NAME
				+ " (usr, citta, via, civico, cap) "
				+ "values (?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, indirizzo.getUsername());
			preparedStatement.setString(2, indirizzo.getCitta());
			preparedStatement.setString(3, indirizzo.getVia());
			preparedStatement.setString(4, indirizzo.getCap());

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
	 * Permette di ottenere gli indirizzi aggiunti da un utente
	 * @param user
	 * @return indirizzo
	 * @throws SQLException 
	 */
	public Set<IndirizzoBean> doRetrieveByUtente(UtenteBean utente) throws SQLException{
		LinkedHashSet<IndirizzoBean> indirizzi=new LinkedHashSet<IndirizzoBean>();
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;

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
		
		return indirizzi;
	}
	
	/**
	 * Permette di eleminare un indirizzo memorizzato
	 * @param indirizzo
	 * @throws SQLException 
	 */
	public boolean doDelete(IndirizzoBean indirizzo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result=0;

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
		
		return result!=0;
	}
}
