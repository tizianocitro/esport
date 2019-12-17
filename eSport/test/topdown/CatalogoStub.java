package topdown;

import java.io.IOException;
import java.util.LinkedHashSet;
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

@WebServlet("/CatalogoStub")
public class CatalogoStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("CatalogoStubDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		synchronized(session) {
			log.info("Sono nello stub del catalogo, ottengo i prodotti per simulare DB");
			CatalogoBean prodotti=new CatalogoBean();
			prodotti.setCatalogo(ServletUtilities.simulateDB());
			
			log.info("Ottengo il tipo dei prodotti per il catalogo");
			String tipo=(String) request.getParameter("tipo");
			log.info("Tipo: " + tipo);
			if(tipo==null || tipo.equals(""))
				tipo="Divisa";
			
			log.info("Secondo controllo su tipo: " + tipo);
			
			log.info("Ottengo i prodotti per il catalogo in base al tipo");
			CatalogoBean catalogo=new CatalogoBean();
			catalogo.setCatalogo(filtraByTipo(tipo, prodotti));
			
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


	
	public Set<ProdottoBean> filtraByTipo(String tipo, CatalogoBean catalogo){
		LinkedHashSet<ProdottoBean> temp=new LinkedHashSet<ProdottoBean>();
		
		log.info("Metodo filtraByTipo -> filtro i prodotti per il catalogo");
		for(ProdottoBean p: catalogo.getCatalogo()) {
			if(p.getTipo().equalsIgnoreCase(tipo))
				temp.add(p);
		}
		
		return temp;
	}
}
