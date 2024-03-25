<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Funcionário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Editar Funcionário</h1>
    <form action="${pageContext.request.contextPath}/EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">
        
        <div class="input-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" value="${employee.name}" required>
        </div>
        
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${employee.email}" required>
        </div>
        
        <div class="input-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${employee.cpf}" required>
        </div>
        
        <div class="input-group">
            <label for="position">Cargo:</label>
            <input type="text" id="position" name="position" value="${employee.position}" required>
        </div>
        
        <div class="input-group">
            <label for="salary">Salário:</label>
            <input type="number" step="0.01" id="salary" name="salary" value="${employee.salary}" required>
        </div>
        
        <div class="form-action">
            <button type="submit" class="btn">Atualizar</button>
        </div>
    </form>
</div>

</body>
</html>
