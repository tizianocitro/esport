package controller.gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RuoloBean;
import beans.UtenteBean;
import model.UtenteModel;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("LoginDebugger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		String redirectedPage="";
		
		HttpSession session=request.getSession();
		synchronized(session) {
			log.info("Login -> creo l'utente da loggare");
			UtenteBean toLog=new UtenteBean();
			toLog.setUsername(username);
			toLog.setPassword(password);
				
			UtenteModel utenteModel=new UtenteModel();
			UtenteBean user=new UtenteBean();
			try {
				user=utenteModel.validate(toLog);
			} 
			catch (SQLException e) {
				log.info("Login -> errore validazione utente");
				e.printStackTrace();
			}
			
			log.info("Login -> terminato metodo: verifica");
			if(user!=null) {
				log.info("Login -> utente loggato: " + user.getUsername() + ", " + user.getPassword());
				session.setAttribute("userAuth", true);
				session.setAttribute("ruolo", RuoloBean.UTENTE);
				session.setAttribute("userLogged", user);

				String pp=(String) session.getAttribute("previousPage");
				if(pp!=null && !pp.equals("")) {
					redirectedPage=pp;
					session.removeAttribute("previousPage");
				}
				else
					redirectedPage="/Index.jsp";
			}
			else {
				session.setAttribute("userAuth", false);
				session.setAttribute("ruolo", RuoloBean.UTENTE);
				session.setAttribute("userLogged", null);
					
				session.setAttribute("errore", "errore");
				redirectedPage="/Login.jsp";
			}
		}
		
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}
}
