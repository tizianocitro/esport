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
import beans.CarrelloItem;
import beans.CatalogoBean;
import beans.ProdottoBean;

@WebServlet("/AddProdottoCarrello")
public class AddProdottoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("AddProdottoCarrelloDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("AddProdottoCarrello -> verifico che il carrello esista");
			CarrelloBean carrello=(CarrelloBean)session.getAttribute("Carrello");
			if(carrello==null) {
				log.info("AddProdottoCarrello -> se non esiste, lo creo");
				carrello=new CarrelloBean();
				session.setAttribute("Carrello", carrello);
			}
			
			log.info("AddProdottoCarrello -> ottengo codice prodotto e taglia dalla richiesta");
			String codiceProdotto=request.getParameter("prodotto");
			String taglia=request.getParameter("selectTaglia");
			
			log.info("AddProdottoCarrello -> controllo che l'utente abbia scelto la taglia");
			if(taglia.equalsIgnoreCase("Scegli la taglia")) {
				log.info("AddProdottoCarrello -> se non lo ha fatto il prodotto non viene aggiunto al carrello");
				response.sendRedirect(request.getContextPath() + "/SchedaProdotto?codProd=" + codiceProdotto);
			}
			else {
				log.info("AddProdottoCarrello -> se l'utente ha inserito la taglia, procedo ottenendo il catalogo");
				CatalogoBean catalogo=(CatalogoBean) session.getAttribute("Catalogo");
				
				log.info("AddProdottoCarrello -> ottengo il prodotto da aggiungere al carrello dal catalogo");
				ProdottoBean prodottoDaAggiungere=catalogo.getProdotto(codiceProdotto);
				if(prodottoDaAggiungere!=null) {
					log.info("AddProdottoCarrello -> creo il carrello item da aggiungere");
					CarrelloItem item=new CarrelloItem();
					item.setProdotto(prodottoDaAggiungere);
					item.setTaglia(taglia);
					
					log.info("AddProdottoCarrello -> verifico se il prodotto è già nel carrello o meno");
					if(!carrello.contains(item)) {
						log.info("AddProdottoCarrello -> non è nel carrello, lo aggiungo");
						carrello.addProdotto(item);
					}
					else {
						log.info("AddProdottoCarrello -> già nel carrello, ne aumento solo la quantità");
						carrello.reAddProdotto(item);
					}
				}
				log.info("AddProdottoCarrello -> aggiorno il carrello nella sessione");
				session.setAttribute("Carrello", carrello);
				
				RequestDispatcher view=request.getRequestDispatcher("Carrello.jsp");
				view.forward(request, response);
			}
			//Fine else
		}
		//Fine synchronized
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
