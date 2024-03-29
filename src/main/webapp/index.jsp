<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Landing Page - Loja de Peças e Reparos Automotivos</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css"> -->
<link rel="stylesheet" href="assets/css/style.css">
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
        <section id="banner" class="py-5">
            <div id="welcome-container" class="container text-center">
                <h1 class="display-4 text-white">Bem-vindo à Loja de Peças e Reparos Automotivos</h1>
                <p class="lead text-white">Encontre as melhores peças e serviços para o seu veículo.</p>
            </div>
        </section>
    
        <!-- Seção de Destaques -->
        <section id="features" class="py-5 bg-warning text-white ">
            <div  id="features-container" class="container">
                <div class="row">
                    <div class="col-md-4 text-center shadow-lg  mb-4">
                        <i class="fas fa-tools feature-icon"></i>
                        <h3 class="text-shadow">Peças de Qualidade</h3>
                        <p>Oferecemos uma ampla variedade de peças automotivas de alta qualidade.</p>
                    </div>
                    <div class="col-md-4 text-center shadow-lg  mb-4">
                        <i class="fas fa-wrench feature-icon"></i>
                        <h3>Serviços Profissionais</h3>
                        <p>Nossa equipe especializada oferece serviços profissionais para manutenção e reparo de veículos.</p>
                    </div>
                    <div class="col-md-4 text-center shadow-lg  mb-4">
                        <i class="fas fa-car feature-icon"></i>
                        <h3>Atendimento</h3>
                        <p>Proporcionamos um melhor atendimento para garantir a satisfação de nossos clientes.</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Sign in and sign up -->
        <section id="form" class="py-5">
            <div class="container text-center">
                <h1 class="display-4 font-weight-normal text-white mb-4">Já é cadastrado em nossa loja?</h1>
                <a href="${pageContext.request.contextPath}/UserServlet" class="btn btn-outline-light btn-lg font-weight-bold mr-3">Ainda não, gostaria de me registrar</a>
                <a href="${pageContext.request.contextPath}/LoginServlet" class="btn btn-outline-warning btn-lg ">Já sou cadastrado</a>
            </div>
        </section>
    
        <!-- Rodapé -->
        <footer class="bg-dark text-white py-4 text-center">
            <div class="container text-center">
                <div class="row">
                    <!-- <div class="col-md-6 col-lg-3 mb-4 text-left">
                        <h3>Sobre Nós</h3>
                        <p>Somos uma empresa especializada em soluções de automação residencial. Nossa missão é tornar a vida das pessoas mais confortável e eficiente.</p>
                    </div>
                    <div class="col-md-6 col-lg-3 mb-4 text-left">
                        <h3>Contato</h3>
                        <p>Email: contato@empresa.com</p>
                        <p>Telefone: (00) 1234-5678</p>
                        <p>Endereço: Av. Principal, 123 - Centro, Cidade - Estado</p>
                    </div> -->
                </div>
                
                <p>&copy; 2024 Loja de Peças Automotivas - AutoBulls - Daniel artur front-end developer</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Sobre</a></li>
                    <li class="list-inline-item"><a href="#">Contato</a></li>
                    <li class="list-inline-item"><a href="#">Política de Privacidade</a></li>
                </ul>
                <div class="">
                    <a href="https://github.com/dxArtur" target="_blank" class="social-link"><i class="fab fa-github"></i> GitHub</a>
                    <a href="https://www.linkedin.com/in/daniel-artur-28a410219" target="_blank" class="social-link"><i class="fab fa-linkedin"></i> LinkedIn</a>
                </div>
            </div>
        </footer>
    
        <!-- Scripts do Bootstrap e jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>