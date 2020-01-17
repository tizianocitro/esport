package controller.gestioneCarrello;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CarrelloBean;
import beans.CarrelloItem;

@WebServlet("/RemoveProdottoCarrello")
public class RemoveProdottoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("RemoveProdottoCarrelloDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("RemoveProdottoCarrello -> ottengo il carrello");
			CarrelloBean carrello=(CarrelloBean)session.getAttribute("Carrello");
			
			log.info("RemoveProdottoCarrello -> ottengo codice prodotto da eliminare");
			String codiceProdotto=request.getParameter("prodotto");
				
			log.info("RemoveProdottoCarrello -> ottengo il prodotto da rimuovere dal carrello");
			CarrelloItem prodottoDaRimuovere=carrello.getProdotto(codiceProdotto);
			
			log.info("RemoveProdottoCarrello -> rimuovo il prodotto se presente nel carrello e quindi diverso da null");
			if(prodottoDaRimuovere!=null)
				carrello.removeProdotto(prodottoDaRimuovere);
			
			log.info("RemoveProdottoCarrello -> aggiorno il carrello");
			session.setAttribute("Carrello", carrello);
			
			response.sendRedirect(request.getContextPath() + "/Carrello");
		}
		//Fine synchronized
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
