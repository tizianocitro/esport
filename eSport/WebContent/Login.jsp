<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<title>eSport - Login</title>
		
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
               		<form name='accesso' action="Login" method="post">
               			<div class="error-msg" id="usrErr"></div>
               			<div class="form-group">
                     		<label><h2>Username</h2></label>
                     		<input type="text" name="username" class="form-control" placeholder="Username">
                  		</div>
                  
                  		<div class="error-msg" id="pwdErr"></div>
                  		<div class="form-group">
                     		<label><h2>Password</h2></label>
                     		<input type="password" name="pass" class="form-control" placeholder="Password">
                  		</div>
                  
                  		<button type="submit" class="btn btn-black">Accedi</button>
                  		<button class="btn btn-secondary">
                  			<a id="reg" class="text-white" href="RegisterForm.jsp" style="text-decoration: none">
                  				Registrati
                  			</a>
                  		</button>
                  		<button class="btn btn-danger">
							<a class="text-light no-dec" href="Index.jsp" style="text-decoration: none">
								Indietro
							</a>
						</button>
               		</form>
            	</div>
         	</div>
      	</div>
   
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>