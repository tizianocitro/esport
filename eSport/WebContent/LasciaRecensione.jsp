<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="beans.*" %>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		response.sendRedirect("./Login.jsp");
	}
	else{
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Lascia una recensione</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link  rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="css/Form.css"  >
	</head>
	
	<body>
		<aside>
			<div id="Logo" class="login-main-text">
      			<img src="images/LogoSfondoNero.png" alt="Logo" class="Logo">
         	</div>
      	</aside>
      	
      	<div class="main">
			<div class="col-md-6 col-sm-12">
            	<div class="login-form">
               		<form name='rececensione' action="LasciaRecensione" method="get" onSubmit="recensioneFormValidation();">
               			<input type="hidden" name="needTo" value="save" />
               			<div class="error-msg" id="vtErr"></div>
               			<div class="form-group">
                     		<label>Voto</label>
                     		<%
                     			String vt=(String) session.getAttribute("voto");
                     			if(vt!=null){
                     		%>
                     			<input type="number" name="voto" min="1" max="10" class="form-control" placeholder="Voto (1-10)" value="<%= vt %>">
                     		<% } 
                     			else{
                     		%>
                     			<input type="number" name="voto" min="1" max="10" class="form-control" placeholder="Voto (1-10)" value="Voto (1-10)">
                     		<% } %>
                  		</div>
                  		
                  		<%
               			String erroreCommento=(String) session.getAttribute("erroreCommento");
               			if(erroreCommento!=null && erroreCommento.equals("errore")){ 
               			%>
                  		<div class="error-msg" id="cmmErr" style="text-color: red">Recensione troppo corta (minimo 12 caratteri)</div>
                  		<%} %>
                  		<div class="form-group">
                  			<label>Recensione</label>
                  			<%
                  			String cmmnt=(String) session.getAttribute("commento");
                 			%>
                  			<textarea id="cmmnt" name="commento" rows="10" class="form-control" placeholder="Scrivi qui la tua recensione di minimo 12 e massimo 512 caratteri" maxlength="512"><%if(cmmnt!=null && !cmmnt.equals("")){%><%= cmmnt %><%}%></textarea>
                  		</div>
                  		<%
                  			session.removeAttribute("voto");
              				session.removeAttribute("commento");
                  			session.removeAttribute("erroreCommento");
                  			ProdottoBean p=(ProdottoBean) session.getAttribute("ProdottoDaMostrare");
                  		%>
                  
                  		<button type="submit" class="btn btn-black">Salva</button>
                  		<button class="btn btn-danger">
							<a class="text-light no-dec" href="SchedaProdotto?codProd=<%= p.getCodice() %>" style="text-decoration: none">
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
  		<script src="js/RecensioneScript.js"></script>
	</body>
</html>
<%} %>