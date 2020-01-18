<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		session.setAttribute("previousPage", "/GestioneCatalogo?tipo=Divisa&order=nome");
		response.sendRedirect("./Login.jsp");
	}
	else{
		UtenteBean userForRoleControl=(UtenteBean) session.getAttribute("userLogged");
		if(!userForRoleControl.getRuolo().containsKey(RuoloBean.CATALOGO)){
			response.sendRedirect("./OnlyAdminPage.html");
		}
		else{
			session.setAttribute("ruolo", RuoloBean.CATALOGO);
%>
<!DOCTYPE html>

<%@ page import="java.util.*" %> 
<%@ page import="beans.*" %>
 
<%! CatalogoBean ctlg; 
	HashSet<ProdottoBean> catalogo;
%>
<%
	ctlg=(CatalogoBean) session.getAttribute("CatalogoDaGestire");
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
		<title>e-Sport - Gestione catalogo <%= titolo %></title>
		
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
			<%@ include file="NavbarCatalogo.jsp" %>
		</header>
  
  		<!-- Page Content -->
  		<div class="container-fluid">

			<div class="row">
				
				<div class="col-lg-3 ord">
					<h1 class="my-4">Gestisci</h1>
	        			
	        		<div class="list-group">
	         	 			<a href="GestioneCatalogo?tipo=Divisa&order=nome" class="list-group-item bb">Divisa</a>
	         	 			<a href="GestioneCatalogo?tipo=Pantaloncini&order=nome" class="list-group-item bb">Pantaloncini</a>
	         	 			<a href="GestioneCatalogo?tipo=Scarpe&order=nome" class="list-group-item bb">Scarpe da gioco</a>
	        		</div>
	        			
					<h1 class="my-4">Ordina</h1>
        			
        			<%! String pasc="prezzo desc"; %>
        			<%
        				if(tp.equalsIgnoreCase("Divisa")){
        			%>
        			<div class="list-group">
          				<a href="GestioneCatalogo?tipo=Divisa&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="GestioneCatalogo?tipo=Divisa&order=marca" class="list-group-item bb">Marca</a>
          				<a href="GestioneCatalogo?tipo=Divisa&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="GestioneCatalogo?tipo=Divisa&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<%}
        				else if(tp.equalsIgnoreCase("Pantaloncini")){	
        			%>
        			<div class="list-group">
          				<a href="GestioneCatalogo?tipo=Pantaloncini&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="GestioneCatalogo?tipo=Pantaloncini&order=marca" class="list-group-item bb">Marca</a>
          				<a href="GestioneCatalogo?tipo=Pantaloncini&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="GestioneCatalogo?tipo=Pantaloncini&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<%} 
        				else{
        			%>
        			<div class="list-group">
          				<a href="GestioneCatalogo?tipo=Scarpe&order=nome" class="list-group-item bb">Nome</a>
         	 			<a href="GestioneCatalogo?tipo=Scarpe&order=marca" class="list-group-item bb">Marca</a>
          				<a href="GestioneCatalogo?tipo=Scarpe&order= <%= pasc %>"  class="list-group-item bb">Prezzo [alto-basso]</a>
          				<a href="GestioneCatalogo?tipo=Scarpe&order=prezzo" class="list-group-item bb">Prezzo [basso-alto]</a>
        			</div>
        			<% } %>
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
								</div>
									
              					<div class="card-footer">
              						<div align="center">
              							<button class="btn btn-secondary bg-dark text-white">
                              				<a class="text-light a-btt" href="#?cod=<%= p.getCodice() %>">
                              					Modifica prodotto
                              				</a>
                          				</button>
              						</div>
              						
              						<div align="center">
              							<button class="btn btn-secondary bg-dark text-white">
                              				<a class="text-light a-btt" href="#?cod=<%= p.getCodice() %>&tipo=<%= p.getTipo() %>">
                              					Rimuovi prodotto
                              				</a>
                          				</button>
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
<%
	}
	//Chiusura secondo else
}
//Chiusura primo else
%>