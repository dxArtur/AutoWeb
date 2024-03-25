<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Editar Cliente</h1>
    <form action="${pageContext.request.contextPath}/UserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}">
        
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${user.cpf}" required readonly> <!-- CPF como um campo somente leitura -->
        </div>
        
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" value="${user.name}" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
        </div>
        
        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" value="${user.password}" required>
        </div>
        
        <button type="submit">Atualizar</button>
    </form>
</div>

</body>
</html>
