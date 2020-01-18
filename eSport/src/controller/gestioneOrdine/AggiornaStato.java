package controller.gestioneOrdine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OrdineBean;
import beans.RuoloBean;
import beans.UtenteBean;
import model.OrdineModel;

@WebServlet("/AggiornaStato")
public class AggiornaStato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("AggiornaStatoDebugger");
	String WRITE="write";
	String SAVE="save";
	
	String redirectedPage="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		log.info("AggiornaStato -> controllo l'azione da eseguire");
		String what=request.getParameter("what");
		log.info("AggiornaStato -> azione da eseguire: " + what);
		if(what==null || what.equals(""))
			what=WRITE;
		
		log.info("AggiornaStato -> controllo che l'utente sia autenticato");
		Boolean userAuth=(Boolean) session.getAttribute("userAuth");
		if((userAuth==null) || (!userAuth.booleanValue())) {
			String ord="sottomissione desc";
			session.setAttribute("previousPage", "/OrdiniAttivi?order=" + ord);
			
			redirectedPage="/Login.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		else {
			log.info("AggiornaStato -> controllo che l'utente autenticato sia un gestore degli ordini");
			UtenteBean utente=(UtenteBean) session.getAttribute("userLogged");
			if(!utente.getRuolo().containsKey(RuoloBean.ORDINI)){
				redirectedPage="/OnlyAdminPage.html";

				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				log.info("AggiornaStato -> se autenticato come gestore degli ordini procedo");
				String numero="";
				OrdineBean ordineDaModificare=new OrdineBean();
				OrdineModel ordineModel=new OrdineModel();

				if(what.equals(WRITE)) {
					numero=request.getParameter("numero");
					log.info("AggiornaStato -> numero dell'ordine da aggiornare: " + numero);
					
					try {
						ordineDaModificare=ordineModel.doRetrieveByNumero(numero);
						if(ordineDaModificare==null 
								|| ordineDaModificare.getStato().equals(OrdineBean.CONSEGNATO)) {
							redirectedPage="/Errore.html";
							response.sendRedirect(request.getContextPath() + redirectedPage);
						}
						else {
							log.info("AggiornaStato -> inserisco ordine nella sessione: " + ordineDaModificare.getNumero());
							session.setAttribute("OrdineDaModificare", ordineDaModificare);
							
							log.info("AggiornaStato -> vado alla pagina di aggiornamento");
							redirectedPage="/AggiornaStato.jsp";
							response.sendRedirect(request.getContextPath() + redirectedPage);
						}
					} 
					catch (SQLException e) {
						log.info("AggiornaStato -> errore ottenimento ordine");
						e.printStackTrace();
					}
				}
				else if(what.equals(SAVE)) {
					log.info("AggiornaStato -> ottengo il nuovo stato dell'ordine");
					String stato=request.getParameter("scelta-stato");
					ordineDaModificare=(OrdineBean) session.getAttribute("OrdineDaModificare");
					ordineDaModificare.setStato(stato);
					
					log.info("AggiornaStato -> se l'ordine è contrassegnato come consegnato, allora aggiorno la data di consegna");
					if(ordineDaModificare.getStato().equals(OrdineBean.CONSEGNATO)) {
						ordineDaModificare.setConsegna(ordineModel.generatoreSottomissione());
						log.info("AggiornaStato -> nuova data di consegna: " + ordineDaModificare.getConsegna());
					}
					
					try {
						ordineModel.aggiornaStato(ordineDaModificare);
					} catch (SQLException e) {
						log.info("AggiornaStato -> errore aggiornamento ordine");
						e.printStackTrace();
					}
					log.info("AggiornaStato -> ordine aggiornato: " + ordineDaModificare.getNumero() 
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
