package controller.gestioneCarrello;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CarrelloBean;

@WebServlet("/SvuotaCarrello")
public class SvuotaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("SvuotaCarrelloDebugger");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		log.info("SvuotaCarrello -> recupero il carrello");
		CarrelloBean carrello=(CarrelloBean) session.getAttribute("Carrello");
		if(carrello!=null)
			carrello.svuotaCarrello();
		
		log.info("SvuotaCarrello -> carrello svuotato");
		response.sendRedirect(request.getContextPath() + "/Carrello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
