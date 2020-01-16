package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ComposizioneBean;
import beans.OrdineBean;

public class ComposizioneModel {
	private static final String TABLE_NAME="composizione";
	static Logger log=Logger.getLogger("ComposizioneModelDebugger");

	public ComposizioneModel() {

	}
	
	/**
	 * Permette di memorizzare un prodotto come parte della composizione di un'ordine
	 * @param composizione
	 * @throws SQLException 
	 */
	public void doSave(ComposizioneBean composizione) throws SQLException {
		log.info("ComposizioneModel -> doSave");
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doSave -> verifico pre-condizioni");
		if(composizione==null || composizione.getOrdine()==null || composizione.getOrdine().equals("")
				|| composizione.getProdotto()==null || composizione.getProdotto().equals("")
				|| composizione.getNomeProdotto()==null || composizione.getNomeProdotto().equals("")
				|| composizione.getPrezzoVen()<1 || composizione.getIvaVen()<1 || composizione.getQt()<1
				|| composizione.getTaglia()==null || composizione.getTaglia().equals(""))
			return;
		
		log.info("doSave -> eseguo query");
		String insertSQL="insert into " + ComposizioneModel.TABLE_NAME
				+ " (ordine, prodotto, nomeprodotto, prezzoven, ivaven, qt, taglia) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, composizione.getOrdine());
			preparedStatement.setString(2, composizione.getProdotto());
			preparedStatement.setString(3, composizione.getNomeProdotto());
			preparedStatement.setDouble(4, composizione.getPrezzoVen());
			preparedStatement.setInt(5, composizione.getIvaVen());
			preparedStatement.setInt(6, composizione.getQt());
			preparedStatement.setString(7, composizione.getTaglia());

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
		log.info("ComposizioneModel -> doSave terminato");
	}
	
	/**
	 * Permette di ottenere i prodotti della composizione di un ordine
	 * @param ordine
	 * @return composizione di un ordine
	 * @throws SQLException 
	 */
	public Set<ComposizioneBean> doRetrieveByOrdine(OrdineBean ordine) throws SQLException{
		log.info("ComposizioneModel -> doRetrieveByOrdine");
		
		LinkedHashSet<ComposizioneBean> composizione=new LinkedHashSet<ComposizioneBean>();

		log.info("doRetrieveByOrdine -> verifico pre-condizioni");
		if(ordine==null || ordine.getNumero()==null || ordine.getNumero().equals(""))
			return null;
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		log.info("doRetrieveByOrdine -> eseguo query");
		String selectSQL="select * from " + ComposizioneModel.TABLE_NAME + " where ordine=?";
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, ordine.getNumero());

			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
				ComposizioneBean bean=new ComposizioneBean();
				
				bean.setOrdine(rs.getString("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setNomeProdotto(rs.getString("nomeprodotto"));
				bean.setPrezzoVen(rs.getDouble("prezzoven"));
				bean.setIvaVen(rs.getInt("ivaven"));
				bean.setQt(rs.getInt("qt"));
				bean.setTaglia(rs.getString("taglia"));
					
				composizione.add(bean);
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
		log.info("ComposizioneModel -> doRetrieveByOrdine terminato");
		
		return composizione;
	}
}
