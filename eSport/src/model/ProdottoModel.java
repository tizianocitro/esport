package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ProdottoBean;

public class ProdottoModel {
	private static final String TABLE_NAME="prodotto";
	static Logger log=Logger.getLogger("ProdottoModelDebugger");

	public ProdottoModel() {
		
	}
	
	/**
	 * Permette di salvare un prodotto
	 * @param prodotto
	 * @throws SQLException 
	 */
	public void doSave(ProdottoBean prodotto) throws SQLException {
		log.info("ProdottoModel -> doSave");

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doSave -> verifico pre-condizioni");
		if(prodotto==null || prodotto.getCodice()==null || prodotto.getCodice().equals("")
				|| prodotto.getNome()==null || prodotto.getNome().equals("")
				|| prodotto.getMarca()==null || prodotto.getMarca().equals("")
				|| prodotto.getTipo()==null || prodotto.getTipo().equals("")
				|| prodotto.getDescrizione()==null || prodotto.getDescrizione().equals("")
				|| prodotto.getQt()<1 || prodotto.getIva()<1 || prodotto.getPrezzo()<1)
			return;

		log.info("doSave -> eseguo query");
		String insertSQL="insert into " + ProdottoModel.TABLE_NAME
				+ " (codice, nome, tipo, marca, qt, prezzo, iva, descrizione) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
				
			preparedStatement.setString(1, prodotto.getCodice());
			preparedStatement.setString(2, prodotto.getNome());
			preparedStatement.setString(3, prodotto.getTipo());
			preparedStatement.setString(4, prodotto.getMarca());
			preparedStatement.setInt(5, prodotto.getQt());
			preparedStatement.setDouble(6, prodotto.getPrezzo());
			preparedStatement.setInt(7, prodotto.getIva());
			preparedStatement.setString(8, prodotto.getDescrizione());
			
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
		log.info("ProdottoModel -> doSave terminato");
	}
	
	/**
	 * Permette di ottenere i prodotti in base al tipo specificando un ordinamento
	 * @param tipo
	 * @return prodotti
	 * @throws SQLException 
	 */
	public Set<ProdottoBean> doRetrieveByTipo(String tipo, String order) throws SQLException{
		log.info("ProdottoModel -> doRetrieveByTipo");
		
		LinkedHashSet<ProdottoBean> prodotti=new LinkedHashSet<ProdottoBean>();
		TagliaModel tagliaModel=new TagliaModel();
		
		log.info("doRetrieveByTipo -> verifico pre-condizioni");
		if(tipo==null || tipo.equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doRetrieveByTipo -> eseguo query");
		String selectSQL="select * from " + ProdottoModel.TABLE_NAME + " where tipo=?";
		
		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, tipo);

			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
					ProdottoBean bean=new ProdottoBean();
				
					bean.setCodice(rs.getString("codice"));
					bean.setTipo(rs.getString("tipo"));
					bean.setNome(rs.getString("nome"));
					bean.setMarca(rs.getString("marca"));
					bean.setQt(rs.getInt("qt"));
					bean.setPrezzo(rs.getDouble("prezzo"));
					bean.setIva(rs.getInt("iva"));
					bean.setDescrizione(rs.getString("descrizione"));
					bean.setTaglie(tagliaModel.doRetrieveByProdotto(bean.getCodice()));
					
					prodotti.add(bean);
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
		log.info("ProdottoModel -> doRetrieveByTipo terminato");
		
		return prodotti;
	}
	
	/**
	 * Permette di ottenere un prodotto specificando il codice
	 * @param tipo
	 * @return prodotti
	 * @throws SQLException 
	 */
	public ProdottoBean doRetrieveByCodice(String codice) throws SQLException{
		log.info("ProdottoModel -> doRetrieveByCodice");

		ProdottoBean bean=new ProdottoBean();
		TagliaModel tagliaModel=new TagliaModel();
		
		log.info("doRetrieveByCodice -> verifico pre-condizioni");
		if(codice==null || codice.equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doRetrieveByCodice -> eseguo query");
		String selectSQL="select * from " + ProdottoModel.TABLE_NAME + " where codice=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice);

			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
				bean.setCodice(rs.getString("codice"));
				bean.setTipo(rs.getString("tipo"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setQt(rs.getInt("qt"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setIva(rs.getInt("iva"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setTaglie(tagliaModel.doRetrieveByProdotto(bean.getCodice()));
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
		log.info("ProdottoModel -> doRetrieveByCodice terminato");
		if(bean.getCodice()==null || bean.getCodice().equals(""))
			return null;
		
		return bean;
	}
	
	/**
	 * Permette di salvare un prodotto
	 * @param prodotto
	 * @throws SQLException 
	 */
	public boolean doUpdate(ProdottoBean prodotto) throws SQLException {
		log.info("ProdottoModel -> doUpdate");

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.info("doUpdate -> verifico pre-condizioni");
		if(prodotto==null || prodotto.getCodice()==null || prodotto.getCodice().equals("")
				|| prodotto.getNome()==null || prodotto.getNome().equals("")
				|| prodotto.getMarca()==null || prodotto.getMarca().equals("")
				|| prodotto.getTipo()==null || prodotto.getTipo().equals("")
				|| prodotto.getDescrizione()==null || prodotto.getDescrizione().equals("")
				|| prodotto.getQt()<1 || prodotto.getIva()<1 || prodotto.getPrezzo()<1
				|| doRetrieveByCodice(prodotto.getCodice())==null)
			return false;
		
		int result=0;

		log.info("doUpdate -> eseguo query");
		String updateSQL="update " + ProdottoModel.TABLE_NAME + " "
					   + " set nome=?, "
					   + " marca=?, "
					   + " qt=?, "
					   + " prezzo=?, "
					   + " iva=?, "
					   + " descrizione=? "
					   + " where codice=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getMarca());
			preparedStatement.setInt(3, prodotto.getQt());
			preparedStatement.setDouble(4, prodotto.getPrezzo());
			preparedStatement.setInt(5, prodotto.getIva());
			preparedStatement.setString(6, prodotto.getDescrizione());
			preparedStatement.setString(7, prodotto.getCodice());
			
			result=preparedStatement.executeUpdate();
			
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
		log.info("ProdottoModel -> doUpdate terminato");
		
		return (result!=0);
	}
	
	/**
	 * Permette di eliminare un prodotto
	 * @param prodotto
	 * @throws SQLException 
	 */
	public boolean doDelete(ProdottoBean prodotto) throws SQLException {
		log.info("ProdottoModel -> doDelete");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.info("doDelete -> verifico pre-condizioni");
		if(prodotto==null || prodotto.getCodice()==null || prodotto.getCodice().equals("")
				|| prodotto.getNome()==null || prodotto.getNome().equals("")
				|| prodotto.getMarca()==null || prodotto.getMarca().equals("")
				|| prodotto.getTipo()==null || prodotto.getTipo().equals("")
				|| prodotto.getDescrizione()==null || prodotto.getDescrizione().equals("")
				|| prodotto.getQt()<1 || prodotto.getIva()<1 || prodotto.getPrezzo()<1
				|| doRetrieveByCodice(prodotto.getCodice())==null)
			return false;
		
		int result=0;

		log.info("doDelete -> eseguo query");
		String deleteSQL="delete from " + ProdottoModel.TABLE_NAME + " where codice=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, prodotto.getCodice());

			result=preparedStatement.executeUpdate();
			
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
		log.info("ProdottoModel -> doDelete terminato");
		
		return (result!=0);
	}
}
