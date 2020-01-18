<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.*" %> 
<%@ page import="beans.*" %>
 
<%! CatalogoBean ctlg; 
	HashSet<ProdottoBean> catalogo;
%>

<%
	String UTENTE="Utente";
	session.setAttribute("ruolo", UTENTE);
	ctlg=(CatalogoBean) session.getAttribute("Catalogo");
	catalogo=(HashSet<ProdottoBean>) ctlg.getCatalogo();
	
	String titolo="";
	String tp=(String) session.getAttribute("tp");
	if(tp.equals(CatalogoBean.DIVISA))
		titolo="divise";
	else if(tp.equals(CatalogoBean.PANTALONCINI))
			titolo="pantaloncini";
	else
		titolo="scarpe da gioco";
%>
		
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Catalogo <%= titolo %></title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/Catalogo.css">
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
  		<div class="container-fluid">

			<div class="row">
				
				<div class="col-lg-3 ord">
					<h1 class="my-4">Ordina</h1>
        			
        			<%! String pasc="prezzo desc"; %>
        			<%
        				if(tp.equalsIgnoreCase(CatalogoBean.DIVISA)){
        			%>
        			<div class="list-group">
          				<a href="Catalogo?tipo=Divisa&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="Catalogo?tipo=Divisa&order=marca" class="list-group-item bb">Marca</a>
          				<a href="Catalogo?tipo=Divisa&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="Catalogo?tipo=Divisa&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<%}
        				else if(tp.equalsIgnoreCase(CatalogoBean.PANTALONCINI)){	
        			%>
        			<div class="list-group">
          				<a href="Catalogo?tipo=Pantaloncini&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="Catalogo?tipo=Pantaloncini&order=marca" class="list-group-item bb">Marca</a>
          				<a href="Catalogo?tipo=Pantaloncini&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="Catalogo?tipo=Pantaloncini&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<%} 
        				else{
        			%>
        			<div class="list-group">
          				<a href="Catalogo?tipo=Scarpe&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="Catalogo?tipo=Scarpe&order=marca" class="list-group-item bb">Marca</a>
          				<a href="Catalogo?tipo=Scarpe&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="Catalogo?tipo=Scarpe&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<% } %>
        			
        			<h1 class="my-4">Filtra</h1>
	        		<form class="form-inline" action="#">
		                    <div class="input-group">
		                        <input id="nm-fil" type="text" name="nm" class="form-control" placeholder="Nome prodotto" style="background: white; margin-bottom: 5px; border: 1px solid gray;">
		                        <div class="input-group-btn">
		                            <button id="btt" class="btn btn-secondary" type="submit"> 
		                                <i class="fas fa-search"></i>
		                            </button>
		                        </div>
		                    </div>
		             </form>
		                
	        		 <form class="form-inline" action="#">
		                    <div class="input-group">
		                        <input id="mrc-fil" type="text" name="mrc" class="form-control" placeholder="Marca prodotto" style="background: white; margin-bottom: 5px; border: 1px solid gray;">
		                        <div class="input-group-btn">
		                            <button id="btt" class="btn btn-secondary" type="submit"> 
		                                <i class="fas fa-search"></i>
		                            </button>
		                        </div>
		                    </div>
		              </form>
      			</div> <!-- /.col-lg-3 -->
			
			<div class="col-lg-9">
				
        		<div id="rowDx" class="row py-5">
					<%! String imgString="";%>
		
					<% for(ProdottoBean p: catalogo){%>
        				<div class="col-lg-4 col-md-6 mb-4">
        				<% imgString="images/" + p.getCodice() + ".jpg"; %>
        		
            				<div class="card text-white bg-dark h-100">
              					<a href="SchedaProdotto?codProd=<%= p.getCodice()%>" class="card-link">
              						<img class="card-img-top" src=<%= imgString %> alt="Immagine prodotto">
              					</a>
              		
              					<div class="card-body">
                					<h4 class="card-header">
                  						<a href="SchedaProdotto?codProd=<%= p.getCodice()%>" class="card-link text-white"><%= p.getNome() %></a>
                					</h4>
         		
									<div class="card-header">
										<p><%= p.getMarca() %></p>
										<p class="prezzo"><%= p.getPrezzo() + "&euro;" %></p>
									</div>            		
								</div>
            				</div>
          				</div>
	    			<% } %>
          
        		</div> <!-- /.row -->

      		</div> <!-- /.col-lg-9 -->
		
		</div> <!-- Chiusura row -->
		
		</div> <!-- Chiusura container -->

  		<!-- Footer -->
 		 <footer class="bg-dark">
    		<%@ include file="Footer.jsp" %>
  		 </footer>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>