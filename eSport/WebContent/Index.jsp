<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="beans.*" %>
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
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/BlackWhite.css">
        <link type="text/css" rel="stylesheet" href="css/BoxCatalogo.css">
        <link type="text/css" rel="stylesheet" href="css/Header.css">
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
		
		<!-- Page Content -->
		<!-- Da testare
		<section class="head-section"></section>
		
			
	        <div class="welcome-div">
	            <h1>Benvenuto su e-Sport - soddisfa la tua passione</h1>
	        </div>
			
			
	        <div class="bw-box">
	            <section class="sec-box">
	                <div class="pointer"></div>
	                <span class="box-wh">
	                    <h1 class="white-box">Believe <br> your</h1>
	                </span>
	                    
	                <span class="box-bl">
	                    <h1 class="black-box">in <br> passion</h1>
	                </span>
	            </section>
	        </div>
			-->
			
			<div id="notfound">
				<div class="notfound">
				<div class="notfound-404">
					<h1><span id="not-up">e</span>Sport</h1>
					<h2>Soddisfa la tua passione</h2>
				</div>
				</div>
			</div>
			
			<div class="cat-box">
            <div class="cat-container">
                <div class="cat-card">
                    <div class="imgBx">
                        <img src="images/design.png">
                    </div>

                    <div class="cat-title">
                        <h2>Divise</h2>
                        <a href="#"><span>Visualizza</span></a>
                    </div>
                </div>
            </div>

            <div class="cat-container">
                <div class="cat-card">
                    <div class="imgBx">
                        <img src="images/design.png">
                    </div>

                    <div class="cat-title">
                        <h2>Pantaloncini</h2>
                        <a href="#"><span>Visualizza</span></a>
                    </div>
                </div>
            </div>

            <div class="cat-container">
                <div class="cat-card">
                    <div class="imgBx">
                        <img src="images/design.png">
                    </div>

                    <div class="cat-title">
                        <h2>Scarpe</h2>
                        <a href="#"><span>Visualizza</span></a>
                    </div>
                </div>
            </div>
        </div>
	
			<!--Some product cards
	        <div class="">
	            <div class="titled-h1">
	                <h1>Novità</h1>
	            </div>
	
	            <div class="row">
	                <span class="card">
	                    <input class="npt" type="checkbox" name="">
	                    <div id="t1" class="toggle">+</div>
	                    <div class="imgBx">
	                        <img src="images/001.jpg" class="imgcard">
	                    </div>
	                    <div class="details">
	                        <p>
	                            <h3 class="nameP">
	                            	<a id="nm1" href="ProdottoServlet?codProd=001" class="text-light"></a>
	                            </h3>
	                        </p>
	                    
	                        <div class="descDiv">
	                            <p id="desc1"></p>
	                        </div>
	                    </div>
	                </span>
	
	                <span class="card">
	                    <input class="npt" type="checkbox" name="">
	                    <div id="t2" class="toggle">+</div>
	                    <div class="imgBx">
	                        <img src="images/005.jpg" class="imgcard">
	                    </div>
	                    <div class="details">
	                        <p>
	                            <h3 class="nameP">
	                            	<a id="nm2" href="ProdottoServlet?codProd=005" class="text-light"></a>
	                            </h3>
	                        </p>
	                        
	                        <div class="descDiv">
	                            <p id="desc2"></p>
	                        </div>
	                    </div>
	                </span>
	
	                <span class="card">
	                    <input class="npt" type="checkbox" name="">
	                    <div id="t3" class="toggle">+</div>
	                    <div class="imgBx">
	                        <img src="images/004.jpg" class="imgcard">
	                    </div>
	                    <div class="details">
	                        <p>
	                            <h3 class="nameP">
									<a id="nm3" href="ProdottoServlet?codProd=004" class="text-light"></a>
								</h3>
	                        </p>
	                        
	                        <div class="descDiv">
	                            <p id="desc3"></p>
	                        </div>
	                    </div>
	                </span>
	
	                <span class="card">
	                    <input class="npt" type="checkbox" name="">
	                    <div id="t4" class="toggle">+</div>
	                    <div class="imgBx">
	                        <img src="images/003.jpg" class="imgcard">
	                    </div>
	                    <div class="details">
	                        <p>
	                            <h2 class="nameP">
	                            	<a id="nm4" href="ProdottoServlet?codProd=003" class="text-light"></a>
	                            </h1>
	                        </p>
	                        
	                        <div class="descDiv">
	                            <p id="desc4"></p>
	                        </div>
	                    </div>
	                </span>
	            </div>
	        </div>
			-->
		<!-- Footer -->
 		 <footer class="bg-dark">
    		<%@ include file="Footer.jsp" %>
  		 </footer>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  		
  		<script type="text/javascript">
            $('.sec-box').mousemove(function(e){
                $('.pointer').css({
                    left: e.pageX,
                    top: e.pageY
                })
            })

            $('.sec-box').mouseenter(function(){
                $('.pointer').css({
                    width: 150,
                    height: 150
                })
            })

            $('.sec-box').mouseleave(function(){
                $('.pointer').css({
                    width: 0,
                    height: 0
                })
            })
        </script>
        
        <script type="text/javascript">
        	$(document).ready(
        		$('#t1').mouseenter($.get("ProdottiMomentoServlet?cod=001", function(data){
        			var p=JSON.parse(data);
        			$('#desc1').html(p.descrizione);
        			$('#nm1').html(p.nome);

        		}))
        	);
        </script>
        
        <script type="text/javascript">
        	$(document).ready(
        		$('#t2').mouseenter($.get("ProdottiMomentoServlet?cod=005", function(data){
        			var p=JSON.parse(data);
        			$('#desc2').html(p.descrizione);
        			$('#nm2').html(p.nome);

        		}))
        	);
        </script>
        
        <script type="text/javascript">
        	$(document).ready(
        		$('#t3').mouseenter($.get("ProdottiMomentoServlet?cod=004", function(data){
        			var p=JSON.parse(data);
        			$('#desc3').html(p.descrizione);
        			$('#nm3').html(p.nome);

        		}))
        	);
        </script>
        
        <script type="text/javascript">
        	$(document).ready(
        		$('#t4').mouseenter($.get("ProdottiMomentoServlet?cod=003", function(data){
        			var p=JSON.parse(data);
        			$('#desc4').html(p.descrizione);
        			$('#nm4').html(p.nome);

        		}))
        	);
        </script>
	</body>
</html>