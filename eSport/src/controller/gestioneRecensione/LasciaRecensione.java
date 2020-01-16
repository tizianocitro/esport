package controller.gestioneRecensione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RecensioneBean;
import beans.UtenteBean;
import model.RecensioneModel;

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

		log.info("LasciaRecensione -> controllo l'azione da eseguire");
		String needTo=request.getParameter("needTo");
		log.info("LasciaRecensione -> azione: " + needTo);
		if(needTo==null || needTo.equals(""))
			needTo=WRITE;
		
		log.info("LasciaRecensione -> controllo che l'utente sia autenticato");
		Boolean userAuth=(Boolean) session.getAttribute("userAuth");
		if((userAuth==null) || (!userAuth.booleanValue())) {
			redirectedPage="/Login.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		else {
			log.info("LasciaRecensione -> se autenticato procedo");

			if(needTo.equals(WRITE)) {
				rewProd=request.getParameter("rewProd");
				session.setAttribute("rewProd", rewProd);
				
				redirectedPage="/LasciaRecensione.jsp";
				response.sendRedirect(request.getContextPath() + redirectedPage);
			}
			else if(needTo.equals(SAVE)) {
				log.info("LasciaRecensione -> ottengo l'utente che sta lasciando la recensione");
				UtenteBean user=(UtenteBean) session.getAttribute("userLogged");
				RecensioneModel recensioneModel=new RecensioneModel();
					
				log.info("LasciaRecensione -> ottengo il prodotto per cui si sta lasciando la recensione");
				rewProd=(String) session.getAttribute("rewProd");
					
				log.info("LasciaRecensione -> ottengo il commento e gestisco i caratteri speciali");
				String commento=request.getParameter("commento");
				commento=recensioneModel.correzione(commento);
					
				log.info("LasciaRecensione -> ottengo il voto");
				Integer voto=Integer.parseInt(request.getParameter("voto"));
					
				log.info("LasciaRecensione -> creo la recensione");
				RecensioneBean recensione=new RecensioneBean();
				recensione.setVoto(voto);
				recensione.setCommento(commento);
				recensione.setUsername(user.getUsername());
				recensione.setProdotto(rewProd);
					
				log.info("LasciaRecensione -> recensione da salvare: " + recensione.getVoto() 
				    + ", " + recensione.getProdotto() 
					+ ", " + recensione.getUsername()
					+ "\n" + recensione.getCommento());
					
				log.info("LasciaRecensione -> salvo la recensione");
				try {
					recensioneModel.doSave(recensione);
				} 
				catch (SQLException e) {
					log.info("LasciaRecensione -> errore salvataggio recensione");
					e.printStackTrace();
				}
					
				session.removeAttribute("rewProd");
					
				log.info("LasciaRecensione -> vado alla pagina della scheda del prodotto");
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
