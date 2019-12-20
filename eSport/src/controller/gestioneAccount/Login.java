package controller.gestioneAccount;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UtenteBean;
import topdown.UtenteModelStub;

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
			try {
				log.info("Sono nella servlet di login");
				UtenteBean temp=new UtenteBean();
				temp.setUsername(username);
				temp.setPassword(password);
				
				UtenteModelStub utenteModel=new UtenteModelStub();
				UtenteBean user=utenteModel.verifica(temp);
				log.info("Sono nello servlet di login -> terminato metodo: verifica");
				if(user!=null) {
					log.info("utente loggato: " + user.getUsername() + ", " + user.getPassword());
					session.setAttribute("userAuth", true);
					session.setAttribute("ruolo", "Utente");
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
					session.setAttribute("ruolo", "Utente");
					session.setAttribute("userLogged", null);
					
					redirectedPage="/Login.jsp";
				}
			}
			catch(Exception e) {
				session.setAttribute("userAuth", false);
				session.setAttribute("ruolo", "Utente");
				session.setAttribute("userLogged", null);
								
				redirectedPage="/Login.jsp";
			}
		}
		
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}
}
