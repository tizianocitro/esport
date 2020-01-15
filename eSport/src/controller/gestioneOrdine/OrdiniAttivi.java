package controller.gestioneOrdine;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OrdineBean;
import topdown.OrdineModelStub;

@WebServlet("/OrdiniAttivi")
public class OrdiniAttivi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("OrdiniAttiviDebugger");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("OrdiniAttivi -> sono nella servlet per gli ordini attivi");
		HttpSession session=request.getSession();
		
		log.info("OrdiniAttivi -> ottengo l'ordine di visualizzazione degli ordini attivi");
		String order=(String) request.getAttribute("order");
		if(order==null)
			order="sottomissione";
		
		synchronized(session) {
			OrdineModelStub ordineModel=new OrdineModelStub();
			
			log.info("OrdiniAttivi -> ottengo gli ordini attivi");
			LinkedHashSet<OrdineBean> ordiniAttivi=(LinkedHashSet<OrdineBean>) ordineModel.doRetrieveIfAttivi(order);
			
			log.info("OrdiniAttivi -> aggiungo ordini attivi alla sessione");
			session.setAttribute("OrdiniAttivi", ordiniAttivi);
		}
		//Finse synchronized
		RequestDispatcher view=request.getRequestDispatcher("OrdiniAttivi.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
