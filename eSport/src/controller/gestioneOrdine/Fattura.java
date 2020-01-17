package controller.gestioneOrdine;

import java.io.IOException;
import java.sql.SQLException;
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
import model.UtenteModel;

@WebServlet("/Fattura")
public class Fattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("FatturaDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String redirectedPage="";
		
		synchronized(session) {
			log.info("Fattura -> controllo che l'utente si sia autenticato");
			Boolean userAuth=(Boolean) session.getAttribute("userAuth");
			if((userAuth==null) || (!userAuth.booleanValue())) {
				String ord="sottomissione desc";
				session.setAttribute("previousPage", "/Ordine?toDo=utente&order=" + ord);
				
				redirectedPage="/Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				log.info("Fattura -> recupero il numero identificativo dell'ordine dalla richiesta");
				String numeroOrdine=request.getParameter("numeroOrdine");
				
				OrdineModel ordineModel=new OrdineModel();
				
				log.info("Fattura -> ottengo l'ordine in base al numero");
				OrdineBean ordine=new OrdineBean();
				try {
					ordine=ordineModel.doRetrieveByNumero(numeroOrdine);
					if(ordine!=null) {
						session.setAttribute("Ordine", ordine);
					
						UtenteModel utenteModel=new UtenteModel();
	
						log.info("Fattura -> ottengo l'utente per la fattura");
						UtenteBean utente=new UtenteBean();
						try {
							utente=utenteModel.doRetrieveByUsername(ordine.getUsername());
							if(utente!=null)
								session.setAttribute("UtenteFattura", utente);
						} 
						catch (SQLException eUtente) {
							log.info("Fattura -> errore ottenimento utente");
							eUtente.printStackTrace();
						}
						
						RequestDispatcher view=request.getRequestDispatcher("Fattura.jsp");
						view.forward(request, response);
					}
					else {
						response.sendRedirect(request.getContextPath() + "/Errore.html");
					}
				} 
				catch (SQLException eOrdine) {
					log.info("Fattura -> errore ottenimento ordine");
					eOrdine.printStackTrace();
				}
			}
		}
		//Fine synchronized
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
