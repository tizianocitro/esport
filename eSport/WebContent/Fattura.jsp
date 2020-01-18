<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		String ord="sottomissione desc";
		session.setAttribute("previousPage", "/Ordine?toDo=utente&order=" + ord);
		
		response.sendRedirect("./Login.jsp");
	}
	else{
		String ruolo=(String) session.getAttribute("ruolo");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Fattura</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/Nav.css">
		<link rel="stylesheet" type="text/css" href="css/Footer.css">
		<link rel="stylesheet" type="text/css" href="css/Composizione.css">
	</head>
	
	<body class="py-0">
		<!-- Navigation -->
		<header>
			<% 
				String pg="";
			
				if(ruolo==null || ruolo.equals(RuoloBean.UTENTE) || ruolo.equals(RuoloBean.CATALOGO))
					pg="NavbarUtente.jsp";
				else if(ruolo.equals(RuoloBean.ORDINI))
					pg="NavbarOrdini.jsp";			
			%>
			
			<jsp:include page="<%= pg %>" />		
		</header>
  
  		<!-- Page Content -->
  		<%
  			OrdineBean ordine=(OrdineBean) session.getAttribute("Ordine");
  			LinkedHashSet<ComposizioneBean> comp=(LinkedHashSet<ComposizioneBean>) ordine.getComposizione();
  		%>
  		<div class="container py-4">
  		<div class="invoice-box">
	        <table cellpadding="0" cellspacing="0">
	            <tr class="top">
	                <td colspan="4">
	                    <table>
	                        <tr>
	                            <td class="title">
	                                <img src="images/LogoSfondoBianco.png" style="width:60%; max-width:180px;">
	                            </td>
	                            
	                            <td>
	                                <b>eSport<br>
	                                Università degli studi di Salerno</b>
	                            </td>
	                        </tr>
	                    </table>
	                </td>
	            </tr>
	            
	            <tr class="information">
	                <td colspan="4">
	                    <table>
	                        <tr>
	                            <td>
	                                <b>Fattuna n° <%= ordine.getNumero() %></b><br>
	                                Data sottomissione <%= ordine.getSottomissione() %><br>

	                                Data consegna <%= ordine.getConsegna() %>
	                            </td>
	                            
	                            <td>
	                            	<%
	                            		UtenteBean user=(UtenteBean) session.getAttribute("UtenteFattura");
	                            		IndirizzoBean indirizzo=user.getIndirizzo(ordine.getIndirizzo());
	                            		MetodoPagamentoBean metodo=user.getMetPag(ordine.getPagamento());
	                            	%>
	                                <b>Cliente</b><br>
	                                <%= user.getNome() + " " + user.getCognome() %> <br>
	                                <%= indirizzo %><br>
	                                <%= metodo %><br>
	                                <%= user.getEmail() %><br>
	                            </td>
	                        </tr>
	                    </table>
	                </td>
	            </tr>
	            
	            <tr class="heading">
	                <td>Prodotto</td>
	                <td>Quantità</td>
	                <td>Prezzo</td>
	                <td>IVA</td>
	            </tr>
	            <%
	            	int iva=22;
	            	boolean done=false;
	            	for(ComposizioneBean c: comp){
	            		if(!done){
	            			iva=c.getIvaVen();
	            			done=true;
	            		}
	            %>
	            <tr class="item">
	                <td><%= c.getNomeProdotto() %></td>
	                <td><%= c.getQt() %></td>
	                <td><%= c.getPrezzoVen() %></td>
	                <td><%= c.getIvaVen() %></td>
	            </tr>
	            <%} %>
	            
	            <tr class="total">
	                <td></td>
	                
	                <td colspan="4">
	                    <br>
	                    <%
	                    	float ct=(float) ordine.getTotale();
	                    	float tss=(ct/100)*iva;
	                    	float cst=ct-tss;
	                    %>
	                    Totale senza tasse: <%= cst + "&euro;" %> <br>
	                    Imposta IVA: <%= tss + "&euro;" %><br>
	                    <b>Totale fattura: <%= (float) ordine.getTotale() + "&euro;" %></b>
	                </td>
	            </tr>
	        </table>
	    </div>
  		<!-- End Page Content -->
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