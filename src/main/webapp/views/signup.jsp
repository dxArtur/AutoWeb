<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Adicionar Novo Usuário</h1>
    <form action="/servlet/UserServlet" method="post">
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required><br>
        
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" required><br>
        
        <input type="submit" value="Adicionar Usuário">
    </form>
</body>
</html>