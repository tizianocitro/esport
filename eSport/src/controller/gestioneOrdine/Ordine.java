package controller.gestioneOrdine;

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

import beans.OrdineBean;
import beans.UtenteBean;
import topdown.OrdineModelStub;

@WebServlet("/Ordine")
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("OrdineDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String GESTORE="gestore";
		
		String redirectedPage="";
		
		log.info("Ordine -> distinguo tra utente e gestore degli ordini");
		String toDo=request.getParameter("toDo");
		if(toDo==null || toDo.equals(""))
			toDo="utente";
		
		synchronized(session) {
			log.info("Ordine -> verifico che l'utente si sia autenticato");
			Boolean userAuth=(Boolean) session.getAttribute("userAuth");
			if((userAuth==null) || (!userAuth.booleanValue())) {
				redirectedPage="/Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				OrdineModelStub ordineModel=new OrdineModelStub();
				LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();

				log.info("Ordine -> ottengo l'ordine per visualizzare gli ordini");
				String order=request.getParameter("order");
				if(order==null || order.equals(""))
					order="nome";
				
				if(toDo.equals(GESTORE)) {
					log.info("Ordine -> ottengo tutti gli ordini poichè l'utente è gestore degli ordini");
					ordini=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveAll();							
				}
				else {
					UtenteBean utente=(UtenteBean) session.getAttribute("userLogged");
					
					log.info("Ordine -> ottengo solo gli ordini dell'utente");
					ordini=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveByUtente(utente);					
				}
				
				session.setAttribute("Ordini", ordini);
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
