<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Funcionário</title>
    <!-- Inclui o Bootstrap via CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Editar Funcionário</h1>
    <form action="${pageContext.request.contextPath}/EmployeeServlet" method="post" class="mt-3">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">
        
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" value="${employee.name}" class="form-control" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${employee.email}" class="form-control" required>
        </div>
        
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${employee.cpf}" class="form-control" required>
        </div>
        
        <div class="form-group">
            <label for="position">Cargo:</label>
            <input type="text" id="position" name="position" value="${employee.position}" class="form-control" required>
        </div>
        
        <div class="form-group">
            <label for="salary">Salário:</label>
            <input type="number" step="0.01" id="salary" name="salary" value="${employee.salary}" class="form-control" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Atualizar</button>
        <a href="<c:url value='/EmployeeServlet'/>" class="btn btn-secondary">Voltar</a>
    </form>
</div>

<!-- Inclui o JS do Bootstrap via CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
