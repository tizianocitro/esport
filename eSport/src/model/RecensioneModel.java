package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import beans.RecensioneBean;

public class RecensioneModel {
	private static final String TABLE_NAME="recensione";
	static Logger log=Logger.getLogger("RecensioneModelDebugger");

	public RecensioneModel() {
		
	}

	/**
	 * Permette di salvare una recensione
	 * @param recensione
	 * @throws SQLException 
	 */
	public void doSave(RecensioneBean recensione) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertSQL="insert into " + RecensioneModel.TABLE_NAME
				+ " (voto, commento, usr, prodotto) "
				+ "values (?, ?, ?, ?)";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, recensione.getVoto());
			preparedStatement.setString(2, recensione.getCommento());
			preparedStatement.setString(3, recensione.getUsername());
			preparedStatement.setString(4, recensione.getProdotto());

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
	 * Permette di ottenere le recensioni di un prodotto specificando un ordine di restituzione
	 * @param codiceProdotto
	 * @return recensioni
	 * @throws SQLException 
	 */
	public Set<RecensioneBean> doRetrieveByProdotto(String prodotto, String order) throws SQLException {
		LinkedHashSet<RecensioneBean> recensioni=new LinkedHashSet<RecensioneBean>();

		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String selectSQL = "select * from " + RecensioneModel.TABLE_NAME + " where prodotto=?";

		if (order!=null && !order.equals("")) {
			selectSQL+=" order by " + order;
		}

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, prodotto);

			ResultSet rs=preparedStatement.executeQuery();

			while (rs.next()) {
				RecensioneBean temp=new RecensioneBean();
				
				temp.setVoto(rs.getInt("voto"));
				temp.setCommento(rs.getString("commento"));
				temp.setUsername(rs.getString("usr"));
				temp.setProdotto(rs.getString("prodotto"));
				
				recensioni.add(temp);
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
		
		return recensioni;
	}
	
	/**
	 * Permette di gestire i caratteri speciali nel commento di una recensione prima di memorizzarla
	 * @param commento
	 * @return commentoFiltrato
	 */
	public String correzione(String commento) {
		if(!hasSpecialChars(commento)) {
			return commento;
		}

		StringBuilder commentoFiltrato = new StringBuilder(commento.length());
		char c;
		for(int i=0; i<commento.length(); i++) {
			c = commento.charAt(i);
			switch(c) {
			case '<': commentoFiltrato.append("&lt;"); break;
			case '>': commentoFiltrato.append("&gt;"); break;
			case '"': commentoFiltrato.append("&quot;"); break;
			case '&': commentoFiltrato.append("&amp;"); break;
			default: commentoFiltrato.append(c);
			}
		}
		return commentoFiltrato.toString();
	}

	/**
	 * Permette di verificare che il commento di una recensione contenga caratteri speciali
	 * @param input
	 * @return flag
	 */
	private boolean hasSpecialChars(String input) {
		boolean flag=false;
		
		if((input != null) && (input.length() > 0)) {
			char c;
			
			for(int i=0; i<input.length(); i++) {
				c = input.charAt(i);
				switch(c) {
				case '<': flag = true; break;
				case '>': flag = true; break;
				case '"': flag = true; break;
				case '&': flag = true; break;
				}
			}
		}

		return flag;
	}
}
