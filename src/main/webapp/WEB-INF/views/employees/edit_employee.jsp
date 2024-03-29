<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Funcionário</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Autobulls</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Início</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Serviços</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contato</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="mt-4 mb-4">Editar Funcionário</h1>
    <form action="${pageContext.request.contextPath}/EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">
        
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" value="${employee.name}" class="form-control shadow-sm" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${employee.email}" class="form-control shadow-sm" required>
        </div>
        
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${employee.cpf}" class="form-control shadow-sm" required>
        </div>
        
        <div class="form-group">
            <label for="position">Cargo:</label>
            <input type="text" id="position" name="position" value="${employee.position}" class="form-control shadow-sm" required>
        </div>
        
        <div class="form-group">
            <label for="salary">Salário:</label>
            <input type="number" step="0.01" id="salary" name="salary" value="${employee.salary}" class="form-control shadow-sm" required>
        </div>
        
        <div class="form-group">
            <button type="submit" class="btn btn-success shadow-sm">Atualizar</button>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
