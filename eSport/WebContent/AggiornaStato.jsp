<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		String ord="sottomissione desc";
		session.setAttribute("previousPage", "/OrdiniAttivi?order=" + ord);
		
		response.sendRedirect("./Login.jsp");
	}
	else{
		UtenteBean userForRoleControl=(UtenteBean) session.getAttribute("userLogged");
		if(!userForRoleControl.getRuolo().containsKey("Ordini")){
			response.sendRedirect("./OnlyAdminPage.html");
		}
		else{
			String ORDINI_RUOLO="Ordini";
			session.setAttribute("ruolo", ORDINI_RUOLO);
			
			OrdineBean ordineDaModificare=(OrdineBean) session.getAttribute("OrdineDaModificare");
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Aggiorna stato</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link  rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="css/Form.css"  >
	</head>

	<body>
		<aside>
			<div id="Logo" class="login-main-text">
      			<img src="images/LogoNero.png" alt="Logo" class="Logo">
         	</div>
      	</aside>
      
      	<div class="main">
			<div class="col-md-6 col-sm-12">
            	<div class="login-form">
               		<form name='modifica-stato' action="AggiornaStato" method="post">
               		    <input type="hidden" name="what" value="save" />
               		
               			<h3>Ordine n° <%= ordineDaModificare.getNumero() %></h3>
               			<h5>Sottomesso il <%= ordineDaModificare.getSottomissione() %></h5>
               			<h5>Consegna prevista il <%= ordineDaModificare.getConsegna() %></h5>
               			
               			<h5>Stato attuale dell'ordine</h5>
                   		<div class="input-group">
  							<select class="custom-select" name="scelta-stato" id="inputGroupSelect04">
  								<option selected><%= ordineDaModificare.getStato() %></option>
  								<% 
  									String statoAttuale=ordineDaModificare.getStato(); 
  									if(statoAttuale.equals(OrdineBean.ELABORAZIONE)){
  								%>
							    <option value="<%= OrdineBean.SPEDIZIONE %>"><%= OrdineBean.SPEDIZIONE %></option>
							    <option value="<%= OrdineBean.CONSEGNATO %>"><%= OrdineBean.CONSEGNATO %></option>
							    <%
  									}
  									else if(statoAttuale.equals(OrdineBean.SPEDIZIONE)){
							    %>
							    <option value="<%= OrdineBean.CONSEGNATO %>"><%= OrdineBean.CONSEGNATO %></option>
							    <%
  									}
							    %>
  							</select>
						</div>
						<br>
                  		<button type="submit" class="btn btn-black">Modifica</button>
                  		<button type="reset" class="btn btn-secondary">Annulla</button>
                  		<button class="btn btn-danger">
                  			<%! String sttmDsc="sottomissione desc"; %>
							<a class="text-light no-dec" href="OrdiniAttivi?order=<%= sttmDsc %>" style="text-decoration: none">
								Indietro
							</a>
						</button>
               		</form>
            	</div>
         	</div>
      	</div>
   
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
<%
	}
	//Chiusura secondo else
}
//Chiusura primo else
%>