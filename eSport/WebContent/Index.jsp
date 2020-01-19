<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="beans.*"%>
<%
	String ruolo=(String) session.getAttribute("ruolo");
	String CATALOGO="Catalogo";
	String ORDINI="Ordini";
	String UTENTE="Utente";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>eSport - Home Page</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/BlackWhite.css">
<link type="text/css" rel="stylesheet" href="css/BoxCatalogo.css">
<link rel="stylesheet" type="text/css" href="css/HomePage.css">
<link rel="stylesheet" type="text/css" href="css/Nav.css">
<link rel="stylesheet" type="text/css" href="css/Footer.css">
<link rel="stylesheet" type="text/css" href="css/Presentation.css">
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

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>
					<span id="not-up">e</span>Sport
				</h1>
				<h2>Soddisfa la tua passione</h2>
			</div>
		</div>
	</div>

	<div class="cat-box">
		<div class="cat-container">
			<div class="cat-card">
				<div class="imgBx">
					<img src="images/divisa.png">
				</div>

				<div class="cat-title">
					<h2>Divise</h2>
					<a href="Catalogo?tipo=Divisa&order=nome"><span>Visualizza</span></a>
				</div>
			</div>
		</div>

		<div class="cat-container">
			<div class="cat-card">
				<div class="imgBx">
					<img src="images/pantaloncini.png">
				</div>

				<div class="cat-title">
					<h2>Pantaloncini</h2>
					<a href="Catalogo?tipo=Pantaloncini&order=nome"><span>Visualizza</span></a>
				</div>
			</div>
		</div>

		<div class="cat-container">
			<div class="cat-card">
				<div class="imgBx">
					<img src="images/scarpe.png">
				</div>

				<div class="cat-title">
					<h2>Scarpe</h2>
					<a href="Catalogo?tipo=Scarpe&order=nome"><span>Visualizza</span></a>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="bg-dark">
		<%@ include file="Footer.jsp"%>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>