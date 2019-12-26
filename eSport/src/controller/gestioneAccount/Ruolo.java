package controller.gestioneAccount;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ruolo")
public class Ruolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("RuoloDebugger");  
	String CATALOGO="Catalogo";
	String ORDINI="Ordini";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String permesso="";
		String redirectedPage="";
		
		HttpSession session=request.getSession();
		synchronized(session) {	
			log.info("Sono nella servlet Ruolo");
			
			permesso=request.getParameter("permesso");
			log.info("ruolo: " + permesso);
			
			session.setAttribute("ruolo", permesso);

			log.info("Se gestore degli ordini vado alla pagina di gestione degli ordini attivi");
			if(permesso.equals(ORDINI))
				redirectedPage="/OrdiniAttivi";
			else if(permesso.equals(CATALOGO)) {
				log.info("Vado alla pagina di gestione del catalogo");
				redirectedPage="/GestioneCatalogo?tipo=Divisa&order=nome";
			}
			else {
				log.info("Vado alla Home Page");
				redirectedPage="/Index.jsp";
			}
		}
		
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
