package controller.gestioneOrdine;

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

import beans.OrdineBean;
import beans.UtenteBean;
import model.OrdineModel;

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
				log.info("Ordine -> stabilisco a quale pagina tornare");
				if(toDo.equals(GESTORE)) {
					String ord="sottomissione desc";
					session.setAttribute("previousPage", "/Ordine?toDo=gestore&order=" + ord);
				}
				else {
					String ord="sottomissione desc";
					session.setAttribute("previousPage", "/Ordine?toDo=utente&order=" + ord);
				}
				
				redirectedPage="/Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				OrdineModel ordineModel=new OrdineModel();
				LinkedHashSet<OrdineBean> ordini=new LinkedHashSet<OrdineBean>();

				log.info("Ordine -> ottengo l'ordine per visualizzare gli ordini");
				String order=request.getParameter("order");
				if(order==null || order.equals(""))
					order="sottomissione desc";
				
				if(toDo.equals(GESTORE)) {
					log.info("Ordine -> ottengo tutti gli ordini poichè l'utente è gestore degli ordini");
					try {
						ordini=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveAll(order);
					} 
					catch (SQLException eGestore) {
						log.info("Ordine -> errore ottenimento ordini gestore");
						eGestore.printStackTrace();
					}							
				}
				else {
					UtenteBean utente=(UtenteBean) session.getAttribute("userLogged");
					
					log.info("Ordine -> ottengo solo gli ordini dell'utente");
					try {
						ordini=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveByUtente(utente, order);
					} 
					catch (SQLException eUtente) {
						log.info("Ordine -> errore ottenimento ordini utente");
						eUtente.printStackTrace();
					}					
				}
				
				session.setAttribute("Ordini", ordini);
				
				if(toDo.equals(GESTORE)) {
					RequestDispatcher view=request.getRequestDispatcher("OrdineGestore.jsp");
					view.forward(request, response);
				}
				else {
					RequestDispatcher view=request.getRequestDispatcher("OrdineUtente.jsp");
					view.forward(request, response);
				}
			}
		}
		//Fine synchronized
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
