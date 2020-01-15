<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	Boolean userIn=(Boolean) session.getAttribute("userAuth"); 
	if((userIn==null) || (!userIn.booleanValue())){
		response.sendRedirect("./Login.jsp");
	}
	else{
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Lascia una recensione</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link  rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="css/Form.css"  >
	</head>
	
	<body>
		<aside>
			<div id="Logo" class="login-main-text">
      			<img src="images/LogoNero.png" alt="Logo" class="Logo">
         	</div>
      	</aside>
      	
      	<div class="main">
			<div class="col-md-6 col-sm-12">
            	<div class="login-form">
               		<form name='rec' action="LasciaRecensione" method="get" onSubmit="recensioneFormValidation();">
               			<input type="hidden" name="needTo" value="save" />
               			
               			<div class="error-msg" id="vtErr"></div>
               			<div class="form-group">
                     		<label>Voto</label>
                     		<input type="number" name="voto" min="1" max="10" class="form-control" placeholder="Voto (1-10)">
                  		</div>
                  		
                  		<div class="error-msg" id="cmmErr"></div>
                  		<div class="form-group">
                  			<label>Recensione</label>
                  			<textarea name="commento" rows="10" class="form-control" placeholder="Scrivi qui la tua recensione di minimo 12 e massimo 512 caratteri"></textarea>
                  		</div>
                  
                  		<button type="submit" class="btn btn-black">Salva</button>
                  		<button type="reset" class="btn btn-secondary">Annulla</button>
               		</form>
            	</div>
         	</div>
      	</div>
      	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  		<script src="js/RecensioneScript.js"></script>
	</body>
</html>
<%} %>