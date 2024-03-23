<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body class="signup-page-container">
	<div class="form-container">
		<h1>Seja bem-vindo!</h1>
		<hr>
    	<form action="servlet/UserServlet" method="post">
        	<label for="cpf">CPF:</label><br>
        	<input class= "input" type="text" id="cpf" name="cpf" required><br>
        
        	<label for="name">Nome:</label><br>
        	<input class= "input" type="text" id="name" name="name" required><br>
        
        	<label for="email">Email:</label><br>
        	<input class= "input" type="email" id="email" name="email" required><br>
        
        	<label for="password">Senha:</label><br>
        	<input class= "input" type="password" id="password" name="password" required><br>
        
        	<input class="bttn" type="submit" value="Registre-se">
    	</form>
	</div>
</body>
</html>