<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	String ruolo=(String) session.getAttribute("ruolo");
	String CATALOGO="Catalogo";
	String ORDINI="Ordini";
	String UTENTE="Utente";

	ProdottoBean p=(ProdottoBean) session.getAttribute("ProdottoDaMostrare");
	HashSet<RecensioneBean> recensioni=(HashSet<RecensioneBean>) p.getRecensioni();
	HashSet<TagliaBean> taglie=(HashSet<TagliaBean>) p.getTaglie();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - <%= p.getNome() %></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/SchedaProdotto.css">
		<link rel="stylesheet" type="text/css" href="css/Button.css">
		<link rel="stylesheet" type="text/css" href="css/Nav.css">
		<link rel="stylesheet" type="text/css" href="css/Footer.css">
	</head>
	
	<body>
		<header>
			<% 
				String pg="";
			
				if(ruolo==null || ruolo.equals(UTENTE) || ruolo.equals(ORDINI)){
					session.setAttribute("ruolo", UTENTE);
					pg="NavbarUtente.jsp";
				}
				else if(ruolo.equals(CATALOGO))
					pg="NavbarCatalogo.jsp";		
			%>
			
			<jsp:include page="<%= pg %>" />
		</header>
    	<div class="container py-4">
            <div class="row">
                <div class="col-12 col-md-12 col-lg-12">
                    <div class="card bg-light card-body mb-3 card bg-faded p-1 mb-3">
                        <div class="row">
                        	<%! String imgString="";%>
                        	
                            <div id="prodImg" class="col-md-6 col-lg-4">
                            	<% imgString="images/" + p.getCodice() + ".jpg"; %>
                                <img src=<%= imgString %> alt="Immagine prodotto" class="rounded img-fluid">
                            </div>
                            <div class="col-md-6 col-lg-8 card-body">
                                <h4 id="title-prod"><%= p.getNome() %></h4>
                                <h6 id="marca-prod"><%= p.getMarca() %></h5>
                                <p>
                                    <%= p.getDescrizione()%>
                                </p> 
                                
                                <h4><%= p.getPrezzo() + "&euro;" %></h4>
                                <h6>Disponibili <%= p.getQt()%></h6>
                                
                                <form class="form-inline" action="AddProdottoCarrello?prodotto=<%= p.getCodice()%>" method="post">
									<div class="input-group">
									  <select class="custom-select" name="selectTaglia" id="inputGroupSelect04">
									    <option selected>Scegli la taglia</option>
									    <%
									    	for(TagliaBean taglia: taglie){
									    %>
									    <option value="<%= taglia.getMisura() %>"><%= taglia.getMisura() %></option>
									    
									    <% } %>
									  </select>
	
									  <div class="input-group-append">
									  	<button class="btn btn-secondary bg-dark">
	                                    		Aggiungi al carrello
	                                	</button>
									  </div>
									</div>
								</form>
									                                

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
            <div class="row">
                <div class="col-lg-12">
                    <div class="order">
                    	<%! String pasc="voto desc"; %>
                        <a class="bb" href="SchedaProdotto?order=<%= pasc %>&codProd=<%= p.getCodice()%>">
                          <span class="a-sp">Ordina recensioni per voto[alto-basso]</span>
                        </a>
                        
                        <a class="bb" href="SchedaProdotto?order=voto&codProd=<%= p.getCodice()%>">
                          <span class="a-sp">Ordina recensioni per voto[basso-alto]</span>
                        </a>
                    </div>

                    <div class="card card-outline-secondary my-4">
                        <div id="rev-h" class="card-header bg-dark">
                          Recensioni per <%= p.getNome() %>
                        </div>
                        <div class="card-body">
	                        <% if(recensioni.size()!=0){ %>
	                        	<% for(RecensioneBean temp: recensioni){ %>
	                            	<div class="card-title">Voto: <%= temp.getVoto() %></div>   
	                            	<p>
	                            		<%= temp.getCommento() %>
	                            	</p>
	                            	<small class="text-muted">Postato da <%= temp.getUsername() %></small>
	                            	<hr>
	                            <% } %>
	                         <%}
	                           else{
	                         %>
	                         	<p>Nessuna recensione disponibile per questo prodotto</p>
	                         <% } %>
	                         
                            <a href="LasciaRecensione?needTo=write&rewProd=<%= p.getCodice() %>" class="btn btn-secondary bg-dark">
                            	Scrivi una recensione
                            </a>
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