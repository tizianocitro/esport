package topdown;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utilities.ServletUtilities;
import beans.CatalogoBean;
import beans.ProdottoBean;
import beans.RecensioneBean;

@WebServlet("/SchedaProdottoStub")
public class SchedaProdottoStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("SchedaProdottoStubDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			String codiceProdotto=request.getParameter("codProd");
			
			log.info("Sono nello stub della scheda prodotto, ottengo i prodotti per simulare il DB");
			CatalogoBean prodotti=new CatalogoBean();
			prodotti.setCatalogo(ServletUtilities.simulateDB());
			
			ProdottoBean prodottoDaMostrare=ServletUtilities.searchProdottoByCodice(codiceProdotto, prodotti);
			if(prodottoDaMostrare!=null) {
				session.setAttribute("ProdottoDaMostrare", prodottoDaMostrare);
			}
			
			log.info("Sono nello stub della scheda prodotto, ottengo le recensioni per il prodotto da mostrare");
			HashSet<RecensioneBean> recensioni=(HashSet<RecensioneBean>) simulateRecensioni();
			if(recensioni.size()!=0) {
				prodottoDaMostrare.setRecensioni(filtraByProdotto(codiceProdotto, recensioni));
			}			
		}
		
		RequestDispatcher view=request.getRequestDispatcher("SchedaProdotto.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public Set<RecensioneBean> simulateRecensioni() {
		HashSet<RecensioneBean> recensioni=new HashSet<RecensioneBean>();
		String commento="Prodotto molto interessante che mi ha soddisfatto al massimo. Consiglio a tutti l'acquisto!";
		
		RecensioneBean recensioneOne=new RecensioneBean();
		recensioneOne.setProdotto("001");
		recensioneOne.setUsername("PaoloG");
		recensioneOne.setVoto(9);
		recensioneOne.setCommento(commento);
		recensioni.add(recensioneOne);
		
		return recensioni;
	}
	
	private Set<RecensioneBean> filtraByProdotto(String codiceProdotto, Set<RecensioneBean> recensioni) {
		HashSet<RecensioneBean> recensioniProdotto=new HashSet<RecensioneBean>();
		
		for(RecensioneBean recensione: recensioni) {
			if(recensione.getProdotto().equals(codiceProdotto))
				recensioniProdotto.add(recensione);
		}
		
		return recensioniProdotto;
	}
}
