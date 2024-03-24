<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header class="header-container">
        <h2 class="welcome">Bem-vindo ao AutoBulls   </h2>
        <nav>
            <ul>
                <li><a href="index.jsp">Início</a></li>
                <li><a href="produtos.jsp">Veículos</a></li>
                <li><a href="servicos.jsp">Serviços</a></li>
                <li><a href="contato.jsp">Contato</a></li>
            </ul>
        </nav>
	</header>
	
	<main class="content-container">
        <h3>Em que podemos ajudar hoje?</h2>
        <div class="options-container">
			<!-- c:url var="exibirPecasURL" value="/exibirPecas.jsp" /-->
			<a href="${all_parts}" class="options">
				<h2>Comprar peças</h2>
			</a>
            <!-- Adicione mais produtos em destaque conforme necessário -->
            
            <a class="options">
                <h2>Novo serviços</h2>
                <!-- Adicione mais serviços conforme necessário -->
            </a>
        </div>
    </main>
    
    <footer class="footer-container">
        <p>&copy; 2024 Mais Lab - Daniel Artur front end developer</p>
    </footer>

</body>
</html>