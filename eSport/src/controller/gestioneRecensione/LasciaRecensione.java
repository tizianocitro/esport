package controller.gestioneRecensione;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RecensioneBean;
import beans.UtenteBean;
import topdown.RecensioneModelStub;

@WebServlet("/LasciaRecensione")
public class LasciaRecensione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("LasciaRecensioneDebugger");
	String WRITE="write";
	String SAVE="save";
	
	String redirectedPage="";
	String rewProd="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		log.info("Controllo l'azione da eseguire");
		String needTo=request.getParameter("needTo");
		log.info("Azione: " + needTo);
		if(needTo==null || needTo.equals(""))
			//Sostituire con pagina d'errore
			needTo=WRITE;
		
		log.info("Controllo che l'utente sia autenticato");
		Boolean userAuth=(Boolean) session.getAttribute("userAuth");
		if((userAuth==null) || (!userAuth.booleanValue())) {
			redirectedPage="/Login.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		else {
			log.info("Se autenticato procedo");

			if(needTo.equals(WRITE)) {
				rewProd=request.getParameter("rewProd");
				session.setAttribute("rewProd", rewProd);
				
				redirectedPage="/LasciaRecensione.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else if(needTo.equals(SAVE)) {
				log.info("Ottengo l'utente che sta lasciando la recensione");
				UtenteBean user=(UtenteBean) session.getAttribute("userLogged");
				RecensioneModelStub recensioneModel=new RecensioneModelStub();
					
				log.info("Ottengo il prodotto per cui si sta lasciando la recensione");
				rewProd=(String) session.getAttribute("rewProd");
					
				log.info("Ottengo il commento e gestisco i caratteri speciali");
				String commento=request.getParameter("commento");
				commento=recensioneModel.correzzione(commento);
					
				log.info("Ottengo il voto");
				Integer voto=Integer.parseInt(request.getParameter("voto"));
					
				log.info("Creo la recensione");
				RecensioneBean recensione=new RecensioneBean();
				recensione.setVoto(voto);
				recensione.setCommento(commento);
				recensione.setUsername(user.getUsername());
				recensione.setProdotto(rewProd);
					
				log.info("Recensione da salvare: " + recensione.getVoto() + ", " + recensione.getProdotto() 
					+ ", " + recensione.getUsername()
					+ "\n" + recensione.getCommento());
					
				log.info("Salvo la recensione");
				recensioneModel.doSave(recensione);
					
				session.removeAttribute("rewProd");
					
				log.info("Vado alla pagina del prodotto");
				redirectedPage="/SchedaProdotto?codProd=" + rewProd;
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
		}
		//Fine controllo autenticazione
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
