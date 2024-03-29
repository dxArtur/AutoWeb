<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Painel Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Painel Admin</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarAdmin" aria-controls="navbarAdmin" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarAdmin">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/EmployeeServlet'/>">Gerenciar Funcionários</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/PartServlet'/>">Gerenciar Peças</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/VehicleServlet'/>">Gerenciar Veículos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/UserServlet'/>">Gerenciar Usuários</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Conteúdo Principal -->
    <div class="container mt-3">
        <h1>Bem-vindo ao Painel Admin</h1>
        <p>Utilize a barra de navegação para acessar as funcionalidades disponíveis.</p>
    </div>
</body>
</html>
