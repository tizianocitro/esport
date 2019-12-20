package controller.gestioneCatalogo;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CatalogoBean;
import topdown.ProdottoModelStub;

@WebServlet("/Catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("CatalogoDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			ProdottoModelStub prodottoModel=new ProdottoModelStub();
			
			log.info("Ottengo il tipo dei prodotti per il catalogo");
			String tipo=(String) request.getParameter("tipo");
			log.info("Tipo: " + tipo);
			if(tipo==null || tipo.equals(""))
				tipo="Divisa";
			
			log.info("Secondo controllo su tipo: " + tipo);
			
			log.info("Ottengo i prodotti per il catalogo in base al tipo");
			CatalogoBean catalogo=new CatalogoBean();
			catalogo.setCatalogo(prodottoModel.doRetrieveByTipo(tipo));
			
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
