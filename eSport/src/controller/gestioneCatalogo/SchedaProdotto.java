package controller.gestioneCatalogo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProdottoBean;
import beans.RecensioneBean;
import model.ProdottoModel;
import model.RecensioneModel;

@WebServlet("/SchedaProdotto")
public class SchedaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("SchedaProdottoDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("Scheda prodotto -> ottengo il codice del prodotto da mostrare dalla richiesta");
			String codiceProdotto=request.getParameter("codProd");
			String order=request.getParameter("order");
			if(order==null)
				order="voto";
			
			ProdottoModel prodottoModel=new ProdottoModel();
			
			log.info("Scheda prodotto -> ottengo il prodotto da mostrare");
			ProdottoBean prodottoDaMostrare=new ProdottoBean();
			try {
				prodottoDaMostrare=prodottoModel.doRetrieveByCodice(codiceProdotto);
			} catch (SQLException e) {
				log.info("SchedaProdotto -> errore ottenimento prodotto");
				e.printStackTrace();
			}
			if(prodottoDaMostrare!=null) {				
				log.info("Scheda prodotto -> ottengo le recensioni per il prodotto da mostrare");
				RecensioneModel recensioneModel=new RecensioneModel();

				try {
					LinkedHashSet<RecensioneBean> recensioni=(LinkedHashSet<RecensioneBean>) recensioneModel.doRetrieveByProdotto(codiceProdotto, order);
					if(recensioni!=null)
						prodottoDaMostrare.setRecensioni(recensioni);
				} 
				catch (SQLException e) {
					log.info("Scheda prodotto -> errore ottenimento recensioni per prodotto: " + codiceProdotto);
					e.printStackTrace();
				}	
				
				log.info("Scheda prodotto -> aggiungo il prodotto da mostrare alla sessione");
				session.setAttribute("ProdottoDaMostrare", prodottoDaMostrare);
			}
		}
		
		RequestDispatcher view=request.getRequestDispatcher("SchedaProdotto.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
