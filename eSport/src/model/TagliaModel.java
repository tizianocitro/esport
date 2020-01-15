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
		log.info("TagliaModel -> doSave");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doSave -> verifico che la taglia da salvare sia corretta");
		if(taglia==null || taglia.getProdotto()==null || taglia.getProdotto().equals("")
				|| taglia.getMisura()==null || taglia.getMisura().equals(""))
				return;
		
		log.info("doSave -> eseguo query");
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
		log.info("TagliaModel -> doSave terminato");
	}
	
	/**
	 * Permette di ottenere le taglie di un prodotto specificando il codice del prodotto
	 * @param codiceProdotto
	 * @throws SQLException 
	 */
	public Set<TagliaBean> doRetrieveByProdotto(String prodotto) throws SQLException {
		log.info("TagliaModel -> doRetrieveByProdotto");
		LinkedHashSet<TagliaBean> taglie=new LinkedHashSet<TagliaBean>();

		log.info("doRetrieveByProdotto -> verifico che il prodotto sia corretto");
		if(prodotto==null || prodotto.equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doRetrieveByProdotto -> eseguo query");
		String selectSQL="select * from " + TagliaModel.TABLE_NAME + " where prodotto=?";

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
		log.info("TagliaModel -> doRetrieveByProdotto terminato");
		
		return taglie;
	}
}
