<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.*" %> 
<%@ page import="beans.*" %>
 
<%! 
	CarrelloBean carrello;
	HashSet<CarrelloItem> items;
	double costoTotale=0, tasse=0, costoSenzaTasse=0;
	float ct=0, tss=0, cst=0;
%>

<%
	String UTENTE="Utente";
	session.setAttribute("ruolo", UTENTE);
	carrello=(CarrelloBean) session.getAttribute("Carrello");
	if(carrello!=null)
		items=(HashSet<CarrelloItem>) carrello.getCarrello();
%>
		
<html>
	<head>
		<meta charset="utf-8">
		<title>e-Sport - Carrello</title>
		
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
				
				<h1>Riepilogo</h1>
				
        		<div class="data-prod">
        			<%
        				costoTotale=0;
        				tasse=0;
        				
        				if(carrello!=null && !carrello.isEmpty()){	
        					double iva=items.iterator().next().getProdotto().getIva();
        					
        					for(CarrelloItem i: items){
        						ProdottoBean tp=i.getProdotto();
        						double initprezzo=tp.getPrezzo();
        						double prezzo=0;
        						
        						prezzo=initprezzo*i.getQt();
        						costoTotale+=prezzo;
        					}
        					
        					tasse=(costoTotale/100)*iva;
        					costoSenzaTasse=costoTotale-tasse;
        					
        					ct=(float) costoTotale;
        					tss=(float) tasse;
        					cst=(float) costoSenzaTasse;
        				}
        				else{
        					costoTotale=0;
        					tasse=0;
        					costoSenzaTasse=0;
        					ct=0;
        					tss=0;
        					cst=0;
        				}
        				
        				session.setAttribute("costoTotale", ct);
        			%>
            		<table>
              			<tr>
			                <td><h6>Costo prodotti:</h6></td>
			                <td><h6><%= cst %> $</h6></td>
			            </tr>
			            <tr>
                			<td><h6>Tasse:</h6></td>
                			<td><h6><%= tss %> $</h6></td>
              			</tr>
              			<tr>
                			<td><h6>Costo totale:</h6></td>
                			<td><h6><%= ct %> $</h6></td>
              			</tr>
          			</table>
        		</div>

        		<div id="opt-cart" class="list-group">
          			<a href="AcquistoForm.jsp" class="list-group-item bb">
            			<span class="a-sp">Procedi al pagamento</span>
          			</a>
          			<br>
          			<a href="CatalogoStub?tipo=Divisa&order=nome" class="list-group-item bb">
            			<span class="a-nsp">Compra altre divise</span>
          			</a>
          			<a href="CatalogoStub?tipo=Pantaloncini&order=nome" class="list-group-item bb">
            			<span class="a-nsp">Compra altri pantaloncini</span>
          			</a>
          			<a href="CatalogoStub?tipo=Scarpe&order=nome" class="list-group-item bb">
            			<span class="a-nsp">Compra altre scarpe da gioco</span>
          			</a>
         	 		<a href="SvuotaCarrello" class="list-group-item bb">
              			<span class="a-nsp">Svuota il carrello</span>
          			</a>
        		</div>

      		</div>
      		<!-- /.col-lg-3 -->

      		<div class="col-lg-9">
		        <% 
		        	if(carrello==null ||carrello.isEmpty()){
		        %>
		        	
		        	<div class="not-cart">
		        		<h1>Carrello vuoto</h1>
		        	</div>
		        	
		        <% }
		           else{		        
					String imgString="";
					for(CarrelloItem i: items){
						ProdottoBean p=i.getProdotto();
						imgString="images/" + p.getCodice() + ".jpg"; 
				%>
        		<div class="row">
          			<div class="col-12 col-md-12 col-lg-12">
              			<div class="card bg-light card-body mb-3 card bg-faded p-1 mb-3">
                  			<div class="row">
                      			<div id="prodImg" class="col-md-6 col-lg-4">
                          			<img src=<%= imgString %> alt="Immagine prodotto" class="rounded img-fluid">
                     		 	</div>
                      			<div class="col-md-6 col-lg-8 card-body">
                          		<h4>
                            		<a class="title-prod" href="SchedaProdottoStub?codProd=<%= p.getCodice()%>">
                              			<%= p.getNome() %> <%= i.getTaglia() %>
                            		</a>
                          		</h4>
                          		<h6 id="marca-prod"><%= p.getMarca() %></h6>
                          		<p>
                              		<%= p.getDescrizione() %>
                          		</p> 
                          		
                          		<h6 id="taglia-prod">Taglia scelta <%= i.getTaglia() %></h6>
                          		
                          		<h4>Prezzo <%= p.getPrezzo() + "&euro;" %></h4>
                          		<p>
                          			<span id="sp-qt">Quantità acquisto <%= i.getQt() %></span>
                          			&nbsp;
                          			<% if(i.getQt()<i.getProdotto().getQt()){ %>
                          			
									<a href="ModificaQtStub?action=plus&prodotto=<%= p.getCodice()%>&taglia=<%= i.getTaglia() %>">
										<i id="icn-plus" class="fas fa-plus-circle text-dark"></i>
									</a>
									<% }
                          			
                          			   if(i.getQt()!=1){ %>
										<a href="ModificaQtStub?action=minus&prodotto=<%= p.getCodice()%>&taglia=<%= i.getTaglia() %>">
											<i id="icn-minus" class="fas fa-minus-circle text-dark"></i>
										</a>
									<% } %>
                          		</p>
                          
                          		<button id="carrello-button" class="btn btn-secondary bg-dark text-white">
                              		<a class="text-light a-btt" href="RemoveProdottoCarrelloStub?prodotto=<%= p.getCodice()%>">
                              			Rimuovi dal carrello
                              		</a>
                          		</button>
                      		</div>
                  		</div>
              		</div>
          		</div>
        	</div>
			<% } %>
		<% } %>
     	</div>
     	<!-- /.col-lg-9 -->

    	</div>
    	<!-- /.row -->

  		</div>
  		<!-- /.container -->
  
  		<!-- Footer -->
 		<footer class="bg-dark">
    		<%@ include file="Footer.jsp" %>
  		</footer>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>