<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="beans.*" %>
<%@	page import="java.util.*" %>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		session.setAttribute("previousPage", "/Acquisto.jsp");
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
	else{
  		UtenteBean user=(UtenteBean) session.getAttribute("userLogged");
  		LinkedHashSet<IndirizzoBean> indirizzi=(LinkedHashSet<IndirizzoBean>) user.getIndirizzi();
  		LinkedHashSet<MetodoPagamentoBean> metodi=(LinkedHashSet<MetodoPagamentoBean>) user.getMetPag();
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
		<title>eSport - Dati acquisto</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link  rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="css/Form.css">
	</head>
	
	<body>
		<aside>
			<div id="Logo" class="login-main-text">
      			<img src="https://imgur.com/rssBTKs.png" alt="Logo" class="Logo">
         	</div>
      	</aside>
      	
      	<div class="main">
			<div class="col-md-6 col-sm-12">
            	<div class="login-form">
               		<form name='acquisto' action="SottomissioneOrdine" method="post">
						<h5>Indirizzo di spedizione</h5>
                   		<div class="input-group">
  							<select class="custom-select" name="scelta-indirizzo" id="inputGroupSelect04">
							    <option selected>Scegli un indirizzo di spedizione</option>
							    <% 
							    	for(IndirizzoBean indirizzo: indirizzi){
							    %>
							    <option value="<%= indirizzo.getCodice() %>"><%= indirizzo %></option>
							    <% } %>
  							</select>
						</div>
						<br>
						<h5>Metodo di pagamento</h5>
                   		<div class="input-group">
  							<select class="custom-select" name="scelta-metpag" id="inputGroupSelect04">
							    <option selected>Scegli un metodo di pagamento</option>
							    <% 
							    	for(MetodoPagamentoBean metodo: metodi){
							    %>
							    <option value="<%= metodo.getCodice() %>"><%= metodo %></option>
							    <% } %>
  							</select>
						</div>
                  		<br>
                  		<button type="submit" class="btn btn-black">Procedi</button>
                  		<button type="reset" class="btn btn-secondary">Annulla</button>
                  		<button class="btn btn-danger">
							<a class="text-light no-dec" href="Carrello.jsp" style="text-decoration: none">
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
  		<script src="js/AcquistoScript.js"></script>
	</body>
</html>
<%} %>