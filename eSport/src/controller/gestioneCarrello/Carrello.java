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

@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("CarrelloDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("Carrello -> verifico che il carrello esiste, se non esiste lo creo");
			CarrelloBean carrello=(CarrelloBean) session.getAttribute("Carrello");
			if(carrello==null)
				carrello=new CarrelloBean();

			log.info("Carrello -> aggiungo carrello alla sessione");
			session.setAttribute("Carrello", carrello);
		}
		
		RequestDispatcher view=request.getRequestDispatcher("Carrello.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
