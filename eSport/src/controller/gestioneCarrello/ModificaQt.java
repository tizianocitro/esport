package controller.gestioneCarrello;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CarrelloBean;

@WebServlet("/ModificaQt")
public class ModificaQt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("ModificaQtDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("Ottengo il carrello");
			CarrelloBean carrello=(CarrelloBean) session.getAttribute("Carrello");
			
			log.info("Ottengo il codice del prodotto, la taglia e l'azione da eseguire: aumento | diminuizione");
			String codiceProdotto=request.getParameter("prodotto");
			String taglia=request.getParameter("taglia");
			String action=request.getParameter("action");
			
			log.info("Modifico la quantità del prodotto: " + codiceProdotto + ", azione: " + action);
			carrello.modificaQt(codiceProdotto, taglia, action);
			
			log.info("Aggiorno il carrello");
			session.setAttribute("Carrello", carrello);
		}
		
		RequestDispatcher view=request.getRequestDispatcher("Carrello.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
