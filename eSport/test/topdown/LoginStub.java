package topdown;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RuoloBean;
import beans.UtenteBean;

@WebServlet("/LoginStub")
public class LoginStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("LoginStubDebugger");

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
				log.info("Sono nello stub di login");
				UtenteBean temp=new UtenteBean();
				temp.setUsername(username);
				temp.setPassword(password);
				
				UtenteBean user=verifica(temp);
				log.info("Sono nello stub di login -> terminato metodo: verifica");
				if(user!=null) {
					log.info("utente loggato: " + user.getUsername() + ", " + user.getPassword());
					session.setAttribute("userAuth", true);
					session.setAttribute("ruolo", "utente");
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
					session.setAttribute("ruolo", "utente");
					session.setAttribute("userLogged", null);
					
					redirectedPage="/LoginPage.jsp";
				}
			}
			catch(Exception e) {
				session.setAttribute("userAuth", false);
				session.setAttribute("ruolo", "utente");
				session.setAttribute("userLogged", null);
								
				redirectedPage="/Login.jsp";
			}
		}
		
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	public UtenteBean verifica(UtenteBean user) {
		log.info("Sono nello stub di login -> metodo: verifica");

		HashMap<String, UtenteBean> users=(HashMap<String, UtenteBean>) simulateUtente();
		log.info("Sono nello stub di login -> metodo: verifica -> terminato metodo: simulateUtente");

		log.info("Comincio scorrimento");
		for(UtenteBean u: users.values()) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				log.info("utente restituito: " + u.getUsername() + ", pwd: " + u.getPassword());
				
				return u;
			}
		}
		
		return null;
	}
	
	public Map<String, UtenteBean> simulateUtente(){
		log.info("Sono nello stub di login -> metodo: simulateUtente");

		HashMap<String, UtenteBean> users=new HashMap<String, UtenteBean>();
		String pIva="11111111111";
		String tel="3391771608";
		
		//Creo l'utente Paolo
		UtenteBean paolo=new UtenteBean();
		paolo.setUsername("PaoloG");
		paolo.setPassword("paolopwd");
		paolo.setNome("Paolo");
		paolo.setCognome("Gioconda");
		paolo.setEmail("paolog@gmail.com");
		paolo.setPiva(pIva);
		paolo.setTelefono(tel);
		
		HashMap<String, RuoloBean> ruoli=(HashMap<String, RuoloBean>) simulateRuolo(paolo);
		paolo.addRuolo(ruoli.get("utente"));

		log.info("Inserisco: " + paolo.getUsername() + ", " + paolo.getPassword());
		users.put("" + paolo.getUsername(), paolo);
		
		//Cro l'utente root
		UtenteBean root=new UtenteBean();
		root.setUsername("root");
		root.setPassword("root");
		root.setNome("root");
		root.setCognome("admin");
		root.setEmail("root@esport.com");
		root.setPiva(pIva);
		root.setTelefono(tel);
		
		HashMap<String, RuoloBean> ruoliRoot=(HashMap<String, RuoloBean>) simulateRuolo(root);
		root.addRuolo(ruoliRoot.get("utente"));
		root.addRuolo(ruoliRoot.get("catalogo"));
		root.addRuolo(ruoliRoot.get("ordini"));
		
		log.info("Inserisco: " + root.getUsername() + ", " + root.getPassword());
		users.put("" + root.getUsername(), root);

		return users;
	}
	
	public Map<String, RuoloBean> simulateRuolo(UtenteBean user){
		log.info("Sono nello stub di login -> metodo: simulateRuolo");

		HashMap<String, RuoloBean> ruoli=new HashMap<String, RuoloBean>();
		
		RuoloBean utente=new RuoloBean();
		utente.setUsername(user.getUsername());
		utente.setPermesso("utente");
		
		log.info("Inserisco ruolo: " + utente.getPermesso());
		ruoli.put(utente.getPermesso(), utente);
		
		RuoloBean catalogo=new RuoloBean();
		catalogo.setUsername(user.getUsername());
		catalogo.setPermesso("catalogo");
	
		log.info("Inserisco ruolo: " + catalogo.getPermesso());
		ruoli.put(catalogo.getPermesso(), catalogo);
		
		RuoloBean ordini=new RuoloBean();
		ordini.setUsername(user.getUsername());
		ordini.setPermesso("ordini");
		
		log.info("Inserisco ruolo: " + ordini.getPermesso());
		ruoli.put(ordini.getPermesso(), ordini);
		
		return ruoli;
	}
}
