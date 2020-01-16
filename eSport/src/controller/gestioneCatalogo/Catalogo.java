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

@WebServlet("/Catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("CatalogoDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		log.info("Catalogo -> ottengo l'ordine di visualizzazione dei prodotti del catalogo");
		String order=request.getParameter("order");
		if(order==null || order.equals(""))
			order="nome";
		
		synchronized(session) {
			ProdottoModel prodottoModel=new ProdottoModel();
			
			log.info("Catalogo -> ottengo il tipo dei prodotti per il catalogo");
			String tipo=(String) request.getParameter("tipo");
			log.info("Catalogo -> tipo: " + tipo);
			if(tipo==null || tipo.equals(""))
				tipo="Divisa";
			
			log.info("Catalogo -> secondo controllo su tipo: " + tipo);
			
			log.info("Catalogo -> ottengo i prodotti per il catalogo in base al tipo");
			CatalogoBean catalogo=new CatalogoBean();
			try {
				catalogo.setCatalogo(prodottoModel.doRetrieveByTipo(tipo, order));
			} 
			catch (SQLException e) {
				log.info("Catalogo -> errore ottenimento prodotti del catalogo");
				e.printStackTrace();
			}
			
			session.setAttribute("Catalogo", catalogo);
			session.setAttribute("tp", tipo);
			
			CatalogoBean cdf=(CatalogoBean) session.getAttribute("CatalogoDaFiltrare");
			if(cdf!=null)
				session.removeAttribute("CatalogoDaFiltrare");
		}
		
		RequestDispatcher view=request.getRequestDispatcher("Catalogo.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
