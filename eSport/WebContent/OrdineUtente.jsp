<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<% 
	String ELABORAZIONE="In elaborazione";
	String SPEDIZIONE="In spedizione";
	String CONSEGNATO="Consegnato";

	String UTENTE="Utente";
	session.setAttribute("ruolo", UTENTE);

	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		String ord="sottomissione desc";
		session.setAttribute("previousPage", "/Ordine?toDo=utente&order=" + ord);
		response.sendRedirect("./Login.jsp");
	}
	else{
		boolean areAttivi=false;
		boolean areChiusi=false;
		LinkedHashSet<OrdineBean> ordini=(LinkedHashSet<OrdineBean>) session.getAttribute("Ordini");
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eSport - I tuoi ordini</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/Carrello.css">
		<link rel="stylesheet" type="text/css" href="css/ButtonWhite.css">
		<link rel="stylesheet" type="text/css" href="css/Button.css">
		<link rel="stylesheet" type="text/css" href="css/Nav.css">
		<link rel="stylesheet" type="text/css" href="css/Footer.css">
	</head>
	
	<body class="py-0">
		<!-- Navigation -->
		<header>
			<%@ include file="NavbarUtente.jsp" %>
		</header>
		
		<!-- Page Content -->
  		<div class="container">

    		<div class="row py-4">

	      	 	  <div class="col-lg-3">
					<h1 class="my-4">Ordina</h1>
	        			
	        			<%! String totale="totale desc"; %>
	        			<%! String sottomissione="sottomissione desc"; %>
	        			<%! String consegna="consegna desc"; %>
	        			
	        			<div class="list-group">
	         	 			<a href="Ordine?toDo=utente&order=<%= sottomissione %>" class="list-group-item bb">Data [più recente]</a>
	         	 			<a href="Ordine?toDo=utente&order=sottomissione" class="list-group-item bb">Data [meno recente]</a>
	         	 			<a href="Ordine?toDo=utente&order=<%= consegna %>" class="list-group-item bb">Consegna [più recente]</a>
	         	 			<a href="Ordine?toDo=utente&order=consegna" class="list-group-item bb">Consegna [meno recente]</a>
	          				<a href="Ordine?toDo=utente&order= <%= totale %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
	          				<a href="Ordine?toDo=utente&order=totale" class="list-group-item bb">Prezzo [basso-alto]</a>
	        			</div>
	      			</div> 
	      			<!-- /.col-lg-3 -->
	      			
	      			<div class="col-lg-9">
						<h1 class="my-4">Ordini attivi</h1>
	      				
	      				<%
	      					for(OrdineBean o: ordini){
	      						if(o.getStato().equals(ELABORAZIONE) || o.getStato().equals(SPEDIZIONE) && ordini.size()!=0){
	      							areAttivi=true;
	      				%>
	      				<div class="row">
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card bg-light card-body mb-3 card bg-faded p-1 mb-3">
                                        <div class="row">
                                            <div class="col-md-6 col-lg-8 card-body">
                                                <h4>
                                                  <a class="title-prod" href="#">
                                                     Ordine <%= o.getNumero() %>
                                                  </a>
                                                </h4>
                                                <h5> <%= o.getStato() %> </h5>
                                                <h6>Sottomesso il <%= o.getSottomissione() %></h6>
                                                <h6>Consegna prevista il <%= o.getConsegna() %></h6>
                                                
                                                <h4>Totale <%= (float) o.getTotale() + "&euro;" %></h4>
                                                
                                                <button id="carrello-button" class="btn btn-secondary bg-dark text-white">
				                              		<a class="text-light a-btt" href="Fattura?numeroOrdine=<%= o.getNumero() %>">
				                              			Visualizza dettagli
				                              		</a>
				                          		</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </div>
                        <%
                        		}
	      					}
	      				
	      					if(!areAttivi){
	      				%>
								<h4 class="my-4">Nessun ordine attivo</h4>
	      				<%
	      					}		
	      				%>
	      				
	      				<h1 class="my-4">Ordini chiusi</h1>
	      				
	      				<%
	      					for(OrdineBean o: ordini){
	      						if(o.getStato().equals(CONSEGNATO) && ordini.size()!=0){
	      							areChiusi=true;
	      				%>
	      				<div class="row">
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card bg-light card-body mb-3 card bg-faded p-1 mb-3">
                                        <div class="row">
                                            <div class="col-md-6 col-lg-8 card-body">
                                                <h4>
                                                  <a class="title-prod" href="#">
                                                     Ordine <%= o.getNumero() %>
                                                  </a>
                                                </h4>
                                                <h5> <%= o.getStato() %> </h5>
                                                <h6>Sottomesso il <%= o.getSottomissione() %></h6>
                                                <h6>Consegnato il <%= o.getConsegna() %></h6>
                                                
                                                <h4>Totale <%= (float) o.getTotale() + "&euro;" %></h4>
                                                
                                                <button id="carrello-button" class="btn btn-secondary bg-dark text-white">
				                              		<a class="text-light a-btt" href="Fattura?numeroOrdine=<%= o.getNumero() %>">
				                              			Visualizza dettagli
				                              		</a>
				                          		</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </div>
                        <%
                        		}
	      					}
	      				
	      					if(!areChiusi){
	      				%>
								<h4 class="my-4">Nessun ordine chiuso</h4>
	      				<%	} %>
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