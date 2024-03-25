<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Funcionário</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">
</head>
<body>

<div class="container">
    <h1>Adicionar Novo Funcionário</h1>
     <form action="${pageContext.request.contextPath}/EmployeeServlet" method="post">
        <div class="input-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="input-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required>
        </div>
        <div class="input-group">
            <label for="position">Cargo:</label>
            <input type="text" id="position" name="position" required>
        </div>
        <div class="input-group">
            <label for="salary">Salário:</label>
            <input type="number" step="0.01" id="salary" name="salary" required>
        </div>
        <div class="form-action">
            <button type="submit" class="btn">Adicionar</button>
        </div>
    </form>
</div>

</body>
</html>
