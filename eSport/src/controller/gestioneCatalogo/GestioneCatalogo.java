package controller.gestioneCatalogo;

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

import beans.CatalogoBean;
import model.ProdottoModel;

@WebServlet("/GestioneCatalogo")
public class GestioneCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("GestioneCatalogoDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		log.info("GestioneCatalogo -> ottengo l'ordine di visualizzazione dei prodotti del catalogo");
		String order=request.getParameter("order");
		if(order==null || order.equals(""))
			order="nome";
		
		synchronized(session) {
			ProdottoModel prodottoModel=new ProdottoModel();
			
			log.info("GestioneCatalogo -> ottengo il tipo dei prodotti per il catalogo");
			String tipo=(String) request.getParameter("tipo");
			log.info("GestioneCatalogo -> tipo: " + tipo);
			if(tipo==null || tipo.equals(""))
				tipo="Divisa";
			
			log.info("GestioneCatalogo -> secondo controllo su tipo: " + tipo);
			
			log.info("GestioneCatalogo -> ottengo i prodotti per il catalogo in base al tipo");
			CatalogoBean catalogo=new CatalogoBean();
			try {
				catalogo.setCatalogo(prodottoModel.doRetrieveByTipo(tipo, order));
			} 
			catch (SQLException e) {
				log.info("GestioneCatalogo -> errore ottenimento prodotti per gestione catalogo");
				e.printStackTrace();
			}
			
			session.setAttribute("CatalogoDaGestire", catalogo);
			session.setAttribute("tp", tipo);
			
			log.info("GestioneCatalogo -> controllo che il catalogo non sia filtrato");
			CatalogoBean cdf=(CatalogoBean) session.getAttribute("CatalogoDaFiltrare");
			if(cdf!=null)
				session.removeAttribute("CatalogoDaFiltrare");
		}
		
		RequestDispatcher view=request.getRequestDispatcher("GestioneCatalogo.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
