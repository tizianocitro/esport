package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.ComposizioneBean;
import beans.OrdineBean;
import beans.UtenteBean;

public class OrdineModel {
	private static final String TABLE_NAME="ordine";
	static Logger log=Logger.getLogger("OrdineModelDebugger");

	public OrdineModel() {
		
	}
	
	/**
	 * Permette di salvare un ordine
	 * @param ordine
	 * @throws SQLException 
	 */
	public void doSave(OrdineBean ordine) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		ComposizioneModel composizioneModel=new ComposizioneModel();
		
		String insertSQL="insert into " + OrdineModel.TABLE_NAME
				+ " (numero, stato, pagamento, indirizzo, totale, sottomissione, consegna, usr) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, ordine.getNumero());
			preparedStatement.setString(2, ordine.getStato());
			preparedStatement.setInt(3, ordine.getPagamento());
			preparedStatement.setInt(4, ordine.getIndirizzo());
			preparedStatement.setDouble(5, ordine.getTotale());
			preparedStatement.setString(6, ordine.getSottomissione());
			preparedStatement.setString(7, ordine.getConsegna());
			preparedStatement.setString(8, ordine.getUsername());
			
			preparedStatement.executeUpdate();
			
			for(ComposizioneBean comp: ordine.getComposizione()) {
				composizioneModel.doSave(comp);
			}
			
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
	 * Permette di aggiornare lo stato di un ordine attivo
	 * @param ordine
	 * @param stato
	 * @throws SQLException 
	 */
	public void aggiornaStato(OrdineBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL="update " + OrdineModel.TABLE_NAME + " "
					   + " set stato=?, "
					   + " consegna=? "
					   + " where numero=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, ordine.getStato());
			preparedStatement.setString(2, ordine.getConsegna());
			preparedStatement.setString(3, ordine.getNumero());
			
			preparedStatement.executeUpdate();
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
	 * Permette di ottenere tutti gli ordini specificando un ordine di restituzione
	 * @param order
	 * @return ordini
	 * @throws SQLException 
	 */
	public Set<OrdineBean> doRetrieveAll(String order) throws SQLException{
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ComposizioneModel composizioneModel=new ComposizioneModel();
		
		String selectSQL="select * from " + OrdineModel.TABLE_NAME;
		
		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean=new OrdineBean();

				bean.setNumero(rs.getString("numero"));
				bean.setStato(rs.getString("stato"));
				bean.setPagamento(rs.getInt("pagamento"));
				bean.setIndirizzo(rs.getInt("indirizzo"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setSottomissione(rs.getString("sottomissione"));
				bean.setConsegna(rs.getString("consegna"));
				bean.setUsername(rs.getString("usr"));
				bean.setComposizione(composizioneModel.doRetrieveByOrdine(bean));
				
				ordini.add(bean);
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
		
		return ordini;
	}
	
	/**
	 * Permette di ottenere un ordine specificandone il numero
	 * @param numero
	 * @return ordine
	 * @throws SQLException 
	 */
	public OrdineBean doRetrieveByNumero(String numero) throws SQLException {
		OrdineBean bean=new OrdineBean();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ComposizioneModel composizioneModel=new ComposizioneModel();
		
		String selectSQL = "select * from " + OrdineModel.TABLE_NAME + " where numero=?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, numero);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNumero(rs.getString("numero"));
				bean.setStato(rs.getString("stato"));
				bean.setPagamento(rs.getInt("pagamento"));
				bean.setIndirizzo(rs.getInt("indirizzo"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setSottomissione(rs.getString("sottomissione"));
				bean.setConsegna(rs.getString("consegna"));
				bean.setUsername(rs.getString("usr"));
				bean.setComposizione(composizioneModel.doRetrieveByOrdine(bean));
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
	 * Permette di ottenere gli ordini di un utente specificando un ordine di restituzione
	 * @param utente
	 * @param order
	 * @return ordini utente
	 * @throws SQLException 
	 */
	public Set<OrdineBean> doRetrieveByUtente(UtenteBean utente, String order) throws SQLException {
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ComposizioneModel composizioneModel=new ComposizioneModel();
		
		String selectSQL="select * from " + OrdineModel.TABLE_NAME + " where usr=?";
		
		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente.getUsername());

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean=new OrdineBean();

				bean.setNumero(rs.getString("numero"));
				bean.setStato(rs.getString("stato"));
				bean.setPagamento(rs.getInt("pagamento"));
				bean.setIndirizzo(rs.getInt("indirizzo"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setSottomissione(rs.getString("sottomissione"));
				bean.setConsegna(rs.getString("consegna"));
				bean.setUsername(rs.getString("usr"));
				bean.setComposizione(composizioneModel.doRetrieveByOrdine(bean));
				
				ordini.add(bean);
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
		
		return ordini;
	}
	
	/**
	 * Permette di ottenere gli ordini attivi specificando un ordine di restituzione
	 * @param utente
	 * @param order
	 * @return
	 * @throws SQLException 
	 */
	public Set<OrdineBean> doRetrieveIfAttivi(String order) throws SQLException {
		LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ComposizioneModel composizioneModel=new ComposizioneModel();
		
		String selectSQL="select * from " + OrdineModel.TABLE_NAME + " where stato=? and stato=?";
		
		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, OrdineBean.ELABORAZIONE);
			preparedStatement.setString(2, OrdineBean.SPEDIZIONE);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean=new OrdineBean();

				bean.setNumero(rs.getString("numero"));
				bean.setStato(rs.getString("stato"));
				bean.setPagamento(rs.getInt("pagamento"));
				bean.setIndirizzo(rs.getInt("indirizzo"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setSottomissione(rs.getString("sottomissione"));
				bean.setConsegna(rs.getString("consegna"));
				bean.setUsername(rs.getString("usr"));
				bean.setComposizione(composizioneModel.doRetrieveByOrdine(bean));
				
				ordini.add(bean);
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
		
		return ordini;
	}
	
	/**
	 * Permette di generare la data di sottomissione dell'ordine
	 * @return sottomissione
	 */
	public String generatoreSottomissione() {
		log.info("Imposto la data di sottomissione come la data odierna");
		Date d=Calendar.getInstance().getTime();
		String format="yyyy-MM-dd";
		DateFormat df=new SimpleDateFormat(format);
		String sottomissione=df.format(d);
		
		return sottomissione;
	}
	
	/**
	 * Permette di generare la data di consegna dell'ordine
	 * @return consegna
	 */
	public String generatoreConsegna() {
		log.info("Imposto la data di consegna");
    	Calendar cal=Calendar.getInstance();
    	cal.add(Calendar.DATE, 3);
    	String formatOne="yyyy-MM-dd";
		DateFormat dfOne=new SimpleDateFormat(formatOne);
		String consegna=dfOne.format(cal.getTime());
		
		return consegna;
	}
	
	/**
	 * Permette di generare il numero dell'ordine
	 * @return numero
	 * @throws SQLException 
	 */
	public String generatoreNumero() throws SQLException {		
		log.info("generatoreNumero -> eseguo doCount");
		int numeroOrdini=doCount();
		numeroOrdini++;
		
		return String.format("%06d", numeroOrdini);
	}
	
	/**
	 * Permette di ottenere il numero totale degli ordini memorizzati
	 * @return count
	 * @throws SQLException 
	 */
	public int doCount() throws SQLException {
		int numeroOrdini=0;
				
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL = "select count(*) as numeroRecord from " + OrdineModel.TABLE_NAME;
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				numeroOrdini=rs.getInt("numeroRecord");
			}
		}
	    finally {
	    	try {
	    		if (preparedStatement != null)
	    			preparedStatement.close();
	    	} 
	    	finally {
	    		DriverManagerConnectionPool.releaseConnection(connection);
	    	}
	    }
		
		return numeroOrdini;
	}
}
