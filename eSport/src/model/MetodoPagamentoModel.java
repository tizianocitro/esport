package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.MetodoPagamentoBean;
import beans.UtenteBean;

public class MetodoPagamentoModel {
	private static final String TABLE_NAME="metodopagamento";
	static Logger log=Logger.getLogger("MetodoPagamentoModelDebugger");

	public MetodoPagamentoModel() {

	}
 
	/**
	 * Permette di salvare un metodo di pagamento
	 * @param metodo
	 * @throws SQLException 
	 */
	public void doSave(MetodoPagamentoBean metodo) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertSQL="insert into " + MetodoPagamentoModel.TABLE_NAME
				+ " (usr, tipo, numero) "
				+ "values (?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, metodo.getUsername());
			preparedStatement.setString(2, metodo.getTipo());
			preparedStatement.setString(3, metodo.getNumero());

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
	 * Permette di ottenere i metodi di pagamento aggiunti da un utente
	 * @param user
	 * @return metodi di pagamento
	 * @throws SQLException 
	 */
	public Set<MetodoPagamentoBean> doRetrieveByUtente(UtenteBean utente) throws SQLException{
		LinkedHashSet<MetodoPagamentoBean> metodi=new LinkedHashSet<MetodoPagamentoBean>();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String selectSQL = "select * from " + MetodoPagamentoModel.TABLE_NAME + " where usr=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente.getUsername());

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				MetodoPagamentoBean temp=new MetodoPagamentoBean();
				
				temp.setCodice(rs.getInt("codice"));
				temp.setUsername(rs.getString("usr"));
				temp.setTipo(rs.getString("tipo"));
				temp.setNumero(rs.getString("numero"));
				
				metodi.add(temp);
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
		
		return metodi;
	}
	
	/**
	 * Permette di eleminare un metodo di pagamento memorizzato
	 * @param metodo
	 * @throws SQLException 
	 */
	public boolean doDelete(MetodoPagamentoBean metodo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result=0;

		String deleteSQL="delete from " + MetodoPagamentoModel.TABLE_NAME + " where codice=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, metodo.getCodice());

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
