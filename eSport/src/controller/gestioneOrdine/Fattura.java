package controller.gestioneOrdine;

import java.io.IOException;
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
import topdown.UtenteModelStub;

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
				redirectedPage="/Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				log.info("Fattura -> recupero il numero identificativo dell'ordine dalla richiesta");
				String numeroOrdine=request.getParameter("numeroOrdine");
				
				OrdineModelStub ordineModel=new OrdineModelStub();
				
				log.info("Fattura -> ottengo l'ordine in base al numero");
				OrdineBean ordine=ordineModel.doRetrieveByNumero(numeroOrdine);
				if(ordine!=null)
					session.setAttribute("Ordine", ordine);

				UtenteModelStub utenteModel=new UtenteModelStub();

				log.info("Fattura -> ottengo l'utente per la fattura");
				UtenteBean utente=utenteModel.doRetrieveByUsername(ordine.getUsername());
				if(utente!=null)
					session.setAttribute("UtenteFattura", utente);
			}
		}
		//Fine synchronized
		RequestDispatcher view=request.getRequestDispatcher("Fattura.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
