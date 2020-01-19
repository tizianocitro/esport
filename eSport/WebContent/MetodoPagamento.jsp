<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	String ruolo=(String) session.getAttribute("ruolo");
	String CATALOGO="Catalogo";
	String ORDINI="Ordini";
	String UTENTE="Utente";
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		session.setAttribute("previousPage", "/MetodoPagamento.jsp");
		response.sendRedirect("./Login.jsp");
	}
	else{
		UtenteBean user=(UtenteBean) session.getAttribute("userLogged");
		LinkedHashSet<MetodoPagamentoBean> metodi=(LinkedHashSet<MetodoPagamentoBean>) user.getMetPag();
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eSport - I tuoi metodi di pagamento</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/Carrello.css">
		<link rel="stylesheet" type="text/css" href="css/Indirizzo.css">
		<link rel="stylesheet" type="text/css" href="css/ButtonWhite.css">
		<link rel="stylesheet" type="text/css" href="css/Button.css">
		<link rel="stylesheet" type="text/css" href="css/Nav.css">
		<link rel="stylesheet" type="text/css" href="css/Footer.css">
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
  		<div class="container">

    		<div class="row py-4">

	      	 	  <div class="col-lg-3">
					<h1 class="my-4">I tuoi metodi di pagamento</h1>
					<a id="add-indirizzo" href="#">	
	        			<div class="ind-prod">
							<i class="fas fa-plus text-dark"></i>
							<h3 class="text-dark">Aggiungi <br> metodo di pagamento</h3>
	        			</div>
					</a>
	        			
	      			</div> 
	      			<!-- /.col-lg-3 -->
	      			
	      			<div class="col-lg-9">
	      				<%
	      					if(metodi.size()==0){
	      				%>	
	      					<div class="not-cart">
		        				<h1>Nessun metodo di pagamento aggiunto</h1>
		        			</div>	
	      				<%
	      				}
	      				else {		
	      					for(MetodoPagamentoBean metodo: metodi){
	      				%>
	      				<div class="row">
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card bg-light card-body mb-3 card bg-faded p-1 mb-3">
                                        <div class="row">
                                            <div class="col-md-6 col-lg-8 card-body">
                                                <h4>
                                                	<%= metodo.getTipo() %> <%= metodo.getNumero() %>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </div>
                        <% }
                        } %>
	      			</div>
	        		<!-- /.col-lg-9 -->
	        		
        	</div>
        	<!-- /.row -->
        	
        </div>
        <!-- Container -->
        
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