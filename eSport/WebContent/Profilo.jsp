<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="beans.UtenteBean" %>

<% 
	String ruolo=(String) session.getAttribute("ruolo");
	String CATALOGO="Catalogo";
	String ORDINI="Ordini";
	String UTENTE="Utente";

	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		session.setAttribute("previousPage", "/Profilo.jsp");
		response.sendRedirect("./Login.jsp");
	}
	else{
		UtenteBean user=(UtenteBean) session.getAttribute("userLogged");

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - <%= user.getUsername() %></title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/Nav.css">
		<link rel="stylesheet" type="text/css" href="css/Footer.css">
		<link rel="stylesheet" type="text/css" href="css/Profilo.css">
	</head>
	
	<body class="py-0">
		<!-- Navigation -->
		<header>
			<% 
				String pg="";
			
				if(ruolo==null || ruolo.equals(UTENTE))
					pg="NavbarUtente.jsp";
				else if(ruolo.equals(CATALOGO))
					pg="NavbarCatalogo.jsp";
				else if(ruolo.equals(ORDINI))
					pg="NavbarOrdini.jsp";
			
			%>
			
			<jsp:include page="<%= pg %>" />		
		</header>
  
  		<!-- Page Content -->
		<div class="container py-3 ">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title mb-4">
                            <div class="d-flex justify-content-start">
                                <div class="image-container">
                                    <img src="images/Avatar.jpg" id="imgProfile" class="img-thumbnail" />
                                    <div class="middle">
                                        <input type="button" class="btn btn-secondary" id="btnChangePicture" value="Modifica" />
                                    </div>
                                </div>
                                <div class="userData ml-3">
                                    <h2 id="nmut" class="d-block"><b><%= user.getUsername() %></b></h2>
                                    <% if(ruolo.equals(CATALOGO) || ruolo.equals(ORDINI)){ %>
                                    	<h4 id="clt" class="d-block"> Gestore <%= ruolo %></h4>
                                    <% }
                                    	else {
                                    %>
                                        <h4 id="clt" class="d-block"><%= ruolo %></h4>
                                    <% } %>
                                </div>
                                <div class="ml-auto">
                                    <input type="button" class="btn btn-primary d-none" id="btnDiscard" value="Discard Changes" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12">
                                <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                                    <li class="nav-item">
                                        <span class="nav-link active" id="infutn" data-toggle="tab" role="tab" aria-controls="basicInfo" aria-selected="true">
                                        <b>Informazioni utente</b>
                                        </span>
                                    </li>
                                </ul>
                                <div class="tab-content ml-1" id="myTabContent">
                                    <div class="tab-pane fade show active" id="basicInfo" role="tabpanel" aria-labelledby="basicInfo-tab">
                                        

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Username</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getUsername() %>
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Nome</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getNome() %>
                                            </div>
                                        </div>
                                        <hr />
                                        
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Cognome</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getCognome() %>
                                            </div>
                                        </div>
                                        <hr />
                                        
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Telefono</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getTelefono() %>
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>e-mail</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getEmail() %>
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Password</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getPassword() %>
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Partita IVA</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <%= user.getPiva() %>
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Indirizzi</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <a class="text-dark ind-link" href="Indirizzo.jsp" target="_blanc" style="text-decoration: none">
                                                	Visualizza indirizzi aggiunti
                                                </a>
                                            </div>
                                        </div>
                                        <hr />
                                        
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label><b>Metodo di pagamento</b></label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <a class="text-dark metpag-link" href="MetodoPagamento.jsp" target="_blanc" style="text-decoration: none">
                                                	Visualizza metodi di pagamento aggiunti
                                                </a>
                                            </div>
                                        </div>
                                        <hr />
                                        
                                    </div>
                                	</div>
                            	</div>
                        	</div>
                    	</div>
                	</div>
            	</div>
        	</div>
    	</div>
		
		 <!-- Footer -->
 		 <footer class="bg-dark">
    		<%@ include file="Footer.jsp" %>
  		 </footer>
  		 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
<%} %>