package topdown;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utilities.ServletUtilities;
import beans.CarrelloBean;
import beans.CarrelloItem;

@WebServlet("/RemoveProdottoCarrelloStub")
public class RemoveProdottoCarrelloStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("RemoveProdottoCarrelloStubDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("Ottengo il carrello");
			CarrelloBean carrello=(CarrelloBean)session.getAttribute("Carrello");
			
			log.info("Ottengo codice prodotto da eliminare");
			String codiceProdotto=request.getParameter("prodotto");
						
			log.info("Ottengo il prodotto da rimuovere dal carrello");
			CarrelloItem prodottoDaRimuovere=carrello.getProdotto(codiceProdotto);
			
			log.info("Prodotto ottenuto: " + prodottoDaRimuovere.getProdotto().getCodice());
			if(prodottoDaRimuovere!=null)
				carrello.removeProdotto(prodottoDaRimuovere);
			
			log.info("Aggiorno il carrello");
			session.setAttribute("Carrello", carrello);
		}
		//Fine synchronized
		RequestDispatcher view=request.getRequestDispatcher("Carrello.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
