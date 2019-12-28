package controller.gestioneOrdine;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OrdineBean;
import beans.UtenteBean;
import topdown.OrdineModelStub;

@WebServlet("/AggiornaStato")
public class AggiornaStato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("AggiornaStatoDebugger");
	String WRITE="write";
	String SAVE="save";
	
	String redirectedPage="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		log.info("Controllo l'azione da eseguire");
		String what=request.getParameter("what");
		log.info("Azione da eseguire: " + what);
		if(what==null || what.equals(""))
			//sostituire con pagina d'errore
			what=WRITE;
		
		log.info("Controllo che l'utente sia autenticato");
		Boolean userAuth=(Boolean) session.getAttribute("userAuth");
		if((userAuth==null) || (!userAuth.booleanValue())) {
			redirectedPage="/Login.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		else {
			log.info("Controllo che l'utente autenticato sia un gestore degli ordini");
			UtenteBean utente=(UtenteBean) session.getAttribute("userLogged");
			if(!utente.getRuolo().containsKey("Ordini")){
				response.sendRedirect("/OnlyAdminPage.html");
			}
			else {
				log.info("Se autenticato come gestore degli ordini procedo");
				String numero="";
				OrdineBean ordineDaModificare=new OrdineBean();
				OrdineModelStub ordineModel=new OrdineModelStub();

				if(what.equals(WRITE)) {
					numero=request.getParameter("numero");
					log.info("numero dell'ordine da aggiornare: " + numero);
					
					ordineDaModificare=ordineModel.doRetrieveByNumero(numero);
					if(ordineDaModificare.getStato().equals(OrdineBean.CONSEGNATO))
						//Sostutuire con pagina di errore
						redirectedPage="/OnlyAdminPage.html";
					
					log.info("Inserisco ordine nella sessione: " + ordineDaModificare.getNumero());
					session.setAttribute("OrdineDaModificare", ordineDaModificare);
					
					log.info("Vado alla pagina di aggiornamento");
					redirectedPage="/AggiornaStato.jsp";
					response.sendRedirect(request.getContextPath() + redirectedPage);
				}
				else if(what.equals(SAVE)) {
					String stato=request.getParameter("scelta-stato");
					ordineDaModificare=(OrdineBean) session.getAttribute("OrdineDaModificare");
					ordineDaModificare.setStato(stato);
					
					log.info("Se l'ordine è contrassegnato come consegnato, allora aggiorno la data di consegna");
					if(ordineDaModificare.getStato().equals(OrdineBean.CONSEGNATO)) {
						ordineDaModificare.setConsegna(ordineModel.generatoreSottomissione());
						log.info("Nuova data di consegna: " + ordineDaModificare.getConsegna());
					}
					
					ordineModel.aggiornaStato(ordineDaModificare, stato);
					log.info("Ordine aggiornato: " + ordineDaModificare.getNumero() 
						+ ", stato: " + ordineDaModificare.getStato());
					
					redirectedPage="/OrdiniAttivi?order=sottomissione";
					response.sendRedirect(request.getContextPath() + redirectedPage);		
				}
			}
		}
		//Fine controllo autenticazione
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
