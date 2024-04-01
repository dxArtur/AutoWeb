<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Landing Page - Loja de Peças e Reparos Automotivos</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Autobulls</a>
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
    
        <!-- Banner -->
        <section id="banner" class="py-5 bg-primary text-white text-center">
            <div class="container">
                <h1 class="display-4">Bem-vindo à Loja de Peças e Reparos Automotivos</h1>
                <p class="lead">Encontre as melhores peças e serviços para o seu veículo.</p>
            </div>
        </section>
    
        <!-- Sign in and sign up -->
        <section id="form" class="py-5">
            <div class="container text-center">
                <h1 class="display-4 font-weight-normal">Como podemos te ajudar hoje?</h1>
                <a href="${pageContext.request.contextPath}/SaleServlet" class="btn btn-primary btn-lg font-weight-bold mr-3">Comprar peças</a>
                <a href="${pageContext.request.contextPath}/ServiceOrderServlet" class="btn btn-warning btn-lg">Contratar serviços</a>
            </div>
        </section>
    
        <!-- Rodapé -->
        <footer class="bg-dark text-white py-4">
            <div class="container text-center">
                <p>&copy; 2024 Loja de Peças Automotivas - AutoBulls - Daniel artur front-end developer</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Sobre</a></li>
                    <li class="list-inline-item"><a href="#">Contato</a></li>
                    <li class="list-inline-item"><a href="#">Política de Privacidade</a></li>
                </ul>
                <div>
                    <a href="https://github.com/dxArtur" target="_blank" class="btn btn-outline-light"><i class="fab fa-github"></i> GitHub</a>
                    <a href="https://www.linkedin.com/in/daniel-artur-28a410219" target="_blank" class="btn btn-outline-light"><i class="fab fa-linkedin"></i> LinkedIn</a>
                </div>
            </div>
        </footer>
</body>
</html>
