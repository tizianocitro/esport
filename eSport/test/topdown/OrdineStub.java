package topdown;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utilities.ServletUtilities;
import beans.OrdineBean;
import beans.UtenteBean;

@WebServlet("/OrdineStub")
public class OrdineStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("OrdineStubDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String GESTORE="gestore";
		
		String redirectedPage="";
		
		log.info("Distinguo tra utente e gestore degli ordini");
		String toDo=request.getParameter("toDo");
		if(toDo==null || toDo.equals(""))
			toDo="utente";
		
		synchronized(session) {
			log.info("Verifico che l'utente si sia autenticato");
			Boolean userAuth=(Boolean) session.getAttribute("userAuth");
			if((userAuth==null) || (!userAuth.booleanValue())) {
				redirectedPage="Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();
				OrdineBean ordOne=ServletUtilities.simulateOrdine("root", "000001", ServletUtilities.ELABORAZIONE);
				ordini.add(ordOne);
				
				OrdineBean ordTwo=ServletUtilities.simulateOrdine("PaoloG", "000002", ServletUtilities.SPEDIZIONE);
				ordini.add(ordTwo);
				
				OrdineBean ordThree=ServletUtilities.simulateOrdine("PaoloG", "000003", ServletUtilities.CONSEGNATO);
				ordini.add(ordThree);
				
				log.info("Ottengo l'ordine per visualizzare gli ordini");
				String order=request.getParameter("order");
				if(order==null || order.equals(""))
					order="nome";
			
				if(toDo.equals(GESTORE)) {
					session.setAttribute("Ordini", ordini);
				}
				else {
					UtenteBean utente=(UtenteBean) session.getAttribute("userLogged");

					LinkedHashSet<OrdineBean> ordiniUtente=(LinkedHashSet<OrdineBean>) 
							ServletUtilities.filtraOrdiniByUtente(utente, ordini);
					
					session.setAttribute("Ordini", ordiniUtente);
				}
			}
		}
		//Fine synchronized
		if(toDo.equals(GESTORE)) {
			RequestDispatcher view=request.getRequestDispatcher("OrdineGestore.jsp");
			view.forward(request, response);
		}
		else {
			RequestDispatcher view=request.getRequestDispatcher("OrdineUtente.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
