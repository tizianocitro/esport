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

import beans.CarrelloBean;
import beans.CarrelloItem;
import beans.ComposizioneBean;
import beans.OrdineBean;
import beans.UtenteBean;
import topdown.OrdineModelStub;

@WebServlet("/SottomissioneOrdine")
public class SottomissioneOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("SottomissioneOrdineDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String redirectedPage="";
		
		synchronized(session) {
			log.info("Sottomissione ordine -> controllo che l'utente sia autenticato");
			Boolean userAuth=(Boolean) session.getAttribute("userAuth");
			if((userAuth==null) || (!userAuth.booleanValue())) {
				redirectedPage="/Login.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else {
				log.info("Sottomissione ordine -> ottengo l'utente che sta sottomettendo l'ordine");
				UtenteBean user=(UtenteBean) session.getAttribute("userLogged");
				
				log.info("Sottomissione ordine -> ottengo il carrello dalla sessione");
				CarrelloBean carrello=(CarrelloBean)session.getAttribute("Carrello");
				
				log.info("Sottomissione ordine -> controllo che non sia vuoto, altrimenti ritorno alla pagina del carrello");
				if(carrello==null || carrello.isEmpty()) {
					redirectedPage="/Carrello.jsp";
					response.sendRedirect(request.getContextPath() + redirectedPage);
				}
				else {
					log.info("Sottomissione ordine -> ottengo i dati dalla richiesta");
					String indirizzo=request.getParameter("scelta-indirizzo");
					log.info("Indirizzo: " + indirizzo);
					String metodo=request.getParameter("scelta-metpag");
					log.info("Metodo di pagamento: " + metodo);
					if(indirizzo.equalsIgnoreCase("Scegli un indirizzo di spedizione")
							|| metodo.equalsIgnoreCase("Scegli un metodo di pagamento")) {
						redirectedPage="/Acquisto.jsp";
						response.sendRedirect(request.getContextPath() + redirectedPage);
					}
					else {
						OrdineModelStub ordineModel=new OrdineModelStub();
						
						log.info("Sottomissione ordine -> creo l'ordine");
						OrdineBean ordine=new OrdineBean();
						ordine.setNumero(ordineModel.generatoreNumero());
						ordine.setUsername(user.getUsername());
						ordine.setStato(OrdineModelStub.ELABORAZIONE);
						ordine.setSottomissione(ordineModel.generatoreSottomissione());
						ordine.setConsegna(ordineModel.generatoreConsegna());
						ordine.setIndirizzo(Integer.parseInt(indirizzo));
						ordine.setPagamento(Integer.parseInt(metodo));
						
						double totale=0;
						log.info("Sottomissione ordine -> uso i prodotti nel carrello per creare la composizione dell'ordine");
						for(CarrelloItem item: carrello.getCarrello()) {
							log.info("Sottomissione ordine -> creo la composizone dell'ordine");
							ComposizioneBean cb=new ComposizioneBean();
							cb.setOrdine(ordine.getNumero());
							cb.setProdotto(item.getProdotto().getCodice());
							cb.setNomeProdotto(item.getProdotto().getNome());
							cb.setIvaVen(item.getProdotto().getIva());
							cb.setPrezzoVen(item.getProdotto().getPrezzo());
							cb.setQt(item.getQt());
							cb.setTaglia(item.getTaglia());
							
							totale+=item.getProdotto().getPrezzo();
	
							log.info("Sottomissione ordine -> aggiungo composizione all'ordine");
							ordine.addProdotto(cb);
						}
						
						log.info("Sottomissione ordine -> aggiorno totale dell'ordine");
						ordine.setTotale(totale);
						log.info("Sottomissione ordine -> salvo l'ordine per completare la sottomissione");
						ordineModel.doSave(ordine);
						
						log.info("Sottomissione ordine -> svuoto il carrello dopo la sottomissione");
						carrello.svuotaCarrello();
						
						log.info("Sottomissione ordine -> imposto il numero dell'ordine per la fattura");
						session.setAttribute("Riepilogo", ordine.getNumero());
						
						RequestDispatcher view=request.getRequestDispatcher("Riepilogo.jsp");
						view.forward(request, response);
					}
					//Fine else di controllo su indirizzo e pagamento
				}
				//Fine secondo else
			}
			//Fine primo else
		}
		//Fine synchronized
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
