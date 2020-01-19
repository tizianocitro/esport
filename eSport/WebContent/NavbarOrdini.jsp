<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.*"%>

<%
	Boolean userAuth = (Boolean) session.getAttribute("userAuth");
	String ruoloToChange = (String) session.getAttribute("ruolo");
	
	UtenteBean user = (UtenteBean) session.getAttribute("userLogged");
%>

<%! String sttDsc="sottomissione desc"; %>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#myNavbar">
		<i class="fas fa-bars"></i>
	</button>

	<a class="navbar-brand mr-auto ml-auto" href="Index.jsp">eSport</a>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav">
			<li class="hvr nav-item"><a href="Index.jsp" class="nav-link">Home</a></li>

			<li class="dropdown nav-item" id="hvr3"><a
				class="dropdown-toggle nav-link" data-toggle="dropdown" href="#">Gestione
					ordini</a>
				<ul class="dropdown-menu bg-dark">
					<li class="dropdown-item"><a href="OrdiniAttivi?order=<%= sttDsc %>">Gestisci ordini
							attivi</a></li>
					<li class="dropdown-item"><a href="Ordine?toDo=gestore&order=<%= sttDsc %>">Visualizza ordini</a></li>
				</ul></li>
				
			<%
				if (user.getRuolo().containsKey(RuoloBean.CATALOGO) || user.getRuolo().containsKey(RuoloBean.ORDINI)) {
			%>

			<li class="dropdown nav-item" id="hvr3"><a
				class="dropdown-toggle nav-link" data-toggle="dropdown" href="#">
					Permessi: Gestore <%=ruoloToChange%></a>
				<ul class="dropdown-menu bg-dark">
					<%
						for (RuoloBean r : user.getRuolo().values()) {
					%>
					<li class="dropdown-item">
						<% if(r.getPermesso().equals(RuoloBean.CATALOGO) || r.getPermesso().equals(RuoloBean.ORDINI)) { %>
							<a href="Ruolo?permesso=<%=r.getPermesso()%>">Gestore <%=r.getPermesso()%></a></li>
						<%}
						   else{
						%>
							<a href="Ruolo?permesso=<%=r.getPermesso()%>"><%=r.getPermesso()%></a></li>
						<% 
						   }
						}
					%>
				</ul></li>
			<%
				}
			%>
		</ul>

		<ul class="nav navbar-nav ml-auto">
			<form id="searchForm" class="form-inline" action="InCostruzione.html" method="post">
				<div id="searchDiv" class="input-group">
					<input type="text" name="nameToSearch" class="form-control"
						placeholder="Cerca">
					<div class="input-group-btn">
						<button id="btt" class="btn btn-secondary" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>
			<%
				if ((userAuth == null) || (!userAuth.booleanValue())) {
			%>
			<li class="hvr nav-item"><a href="InCostruzione.html" class="nav-link"> <i
					class="fas fa-edit"></i> Registrati
			</a></li>
			<li class="hvr nav-item"><a href="Login.jsp" class="nav-link">
					<i class="fas fa-sign-in-alt"></i> Login
			</a></li>
			<%
				} else {
			%>

			<li class="dropdown nav-item" id="hvr2"><a
				class="dropdown-toggle nav-link" data-toggle="dropdown" href="#">
					<i class="fas fa-user-circle"></i> <%=user.getNome()%> <%=user.getCognome()%>
			</a>
				<ul class="dropdown-menu bg-dark">
					<li class="dropdown-item"><a href="Profilo.jsp"> <i
							class="fas fa-user"></i> Profilo
					</a></li>
					<li class="dropdown-item"><a href="Logout"> <i
							class="fas fa-sign-out-alt"></i> Logout
					</a></li>
				</ul></li>
			<%
				}
			%>

		</ul>
	</div>
</nav>
