package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.TagliaBean;

public class TagliaModel {
	private static final String TABLE_NAME="taglia";
	static Logger log=Logger.getLogger("TagliaModelDebugger");

	public TagliaModel() {
		
	}

	/**
	 * Permette di salvare una taglia
	 * @param taglia
	 * @throws SQLException 
	 */
	public void doSave(TagliaBean taglia) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertSQL="insert into " + TagliaModel.TABLE_NAME
				+ " (prodotto, misura) "
				+ "values (?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, taglia.getProdotto());
			preparedStatement.setString(2, taglia.getMisura());

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
	 * Permette di ottenere le taglie di un prodotto specificando il codice del prodotto
	 * @param codiceProdotto
	 * @throws SQLException 
	 */
	public Set<TagliaBean> doRetrieveByProdotto(String prodotto, String order) throws SQLException {
		LinkedHashSet<TagliaBean> taglie=new LinkedHashSet<TagliaBean>();

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="select * from " + TagliaModel.TABLE_NAME + " where prodotto=?";
		
		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, prodotto);

			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
					TagliaBean bean=new TagliaBean();
				
					bean.setProdotto(rs.getString("prodotto"));
					bean.setMisura(rs.getString("misura"));
					
					taglie.add(bean);
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
		
		return taglie;
	}
}
