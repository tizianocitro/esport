package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import beans.UtenteBean;

public class UtenteModel {
	private static final String TABLE_NAME="utente";
	static Logger log=Logger.getLogger("UtenteModelDebugger");

	public UtenteModel() {
		
	}

	/**
	 * Permette di salvare un utente
	 * @param utente
	 * @throws SQLException 
	 */
	public void doSave(UtenteBean utente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertSQL="insert into " + UtenteModel.TABLE_NAME
				+ " (username, pwd, nome, cognome, email, piva, telefono) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, utente.getNome());
			preparedStatement.setString(4, utente.getCognome());
			preparedStatement.setString(5, utente.getEmail());
			preparedStatement.setString(6, utente.getPiva());
			preparedStatement.setString(7, utente.getTelefono());

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
	 * Permette di verificare che l'utente si sia registrato con username e password specificati
	 * @param user
	 * @return utente validato
	 * @throws SQLException 
	 */
	public UtenteBean validate(UtenteBean utente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		IndirizzoModel indirizzoModel=new IndirizzoModel();
		MetodoPagamentoModel metodoPagamentoModel=new MetodoPagamentoModel();
		
		String selectSQL="select * from " + UtenteModel.TABLE_NAME;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean bean=new UtenteBean();
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("pwd"));
				
				if(bean.getUsername().equals(utente.getUsername())
						&& bean.getPassword().equals(utente.getPassword())) {
					
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
					bean.setEmail(rs.getString("email"));
					bean.setPiva(rs.getString("piva"));
					bean.setTelefono(rs.getString("telefono"));
					bean.setIndirizzi(indirizzoModel.doRetrieveByUtente(bean));
					bean.setMetPag(metodoPagamentoModel.doRetrieveByUtente(bean));
					
					return bean;

				}
			}
		} 
		finally {
			try {
				if(preparedStatement!= null)
					preparedStatement.close();
			} 
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return null;
	}
	
	/**
	 * Permette di ottenere un utente specificandone l'username
	 * @param username
	 * @return utente
	 * @throws SQLException 
	 */
	public UtenteBean doRetrieveByUsername(String username) throws SQLException {
		UtenteBean bean=new UtenteBean();

		Connection connection=null;
		PreparedStatement preparedStatement=null;

		IndirizzoModel indirizzoModel=new IndirizzoModel();
		MetodoPagamentoModel metodoPagamentoModel=new MetodoPagamentoModel();
		
		String selectSQL = "select * from " + UtenteModel.TABLE_NAME + " where username=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("pwd"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setPiva(rs.getString("piva"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setIndirizzi(indirizzoModel.doRetrieveByUtente(bean));
				bean.setMetPag(metodoPagamentoModel.doRetrieveByUtente(bean));
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
		
		return bean;
	}
	
	/**
	 * Permette di aggiornare i dati di un utente memorizzato
	 * @param utente
	 * @throws SQLException 
	 */
	public void doUpdate(UtenteBean utente) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String updateSQL="update " + UtenteModel.TABLE_NAME + " "
				   + " set username=?, "
				   + " pwd=?, "
				   + " nome=?, "
				   + " cognome=?, "
				   + " email=?, "
				   + " piva=?, "
				   + " telefono=? "
				   + " where username=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(updateSQL);

			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, utente.getNome());
			preparedStatement.setString(4, utente.getCognome());
			preparedStatement.setString(5, utente.getEmail());
			preparedStatement.setString(6, utente.getPiva());
			preparedStatement.setString(7, utente.getTelefono());
			
			preparedStatement.setString(8, utente.getUsername());

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
	 * Permette di eliminare un utente
	 * @param utente
	 * @throws SQLException 
	 */
	public boolean doDelete(UtenteBean utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result=0;

		String deleteSQL="delete from " + UtenteModel.TABLE_NAME + " where username=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, utente.getUsername());

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
