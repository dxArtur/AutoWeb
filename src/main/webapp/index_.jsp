<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<div class="image-container">
        <img src="assets\team.jpg" alt="team red bull in pitstop">
        <h2 class="welcome">Bem-vindo ao AutoBulls   </h2>

        <!-- <nav>
            <ul>
                <li><a href="index.jsp">Início</a></li>
                <li><a href="produtos.jsp">Veículos</a></li>
                <li><a href="servicos.jsp">Serviços</a></li>
                <li><a href="contato.jsp">Contato</a></li>
            </ul>
        </nav> -->
	</div>

    <div class="services-container">
        <h2>Aqui você encontra:</h2>
        <nav>
            <ul>
                <li><a>Seriços</a></li>
                <li><a>Peças</a></li>
                <li><a>Reparos</a></li>
                <li><a>Manuntenções</a></li>
            </ul>
        </nav>
    </div>

    <div class="advantages-container">
        <h2>Nossa vantagens:</h2>
        <hr class="hr">
        <ul class="advantages">
            <li>Equipe especializada</li>
            <li>Atendimento rápido</li>
            <li>Peças de qualidade</li>
            <li>Baixo custo</li>
        </ul>
    </div>

	
	<main class="content-container">
        <h3>Em que podemos ajudar hoje?</h2>
        <div class="options-container">
			<!-- c:url var="exibirPecasURL" value="/exibirPecas.jsp" /-->
			<a href="${signup}" class="options">
				<h2>Registrar</h2>
			</a>
            <!-- Adicione mais produtos em destaque conforme necessário -->
            
            <a href="${signin}" class="options">
                <h2>Login</h2>
                <!-- Adicione mais serviços conforme necessário -->
            </a>
        </div>
    </main>
    <footer>
        <div class="footer-container">

        
                <div class="footer-content">
                    <div class="footer-column">
                        <h3>Sobre Nós</h3>
                        <p>Somos uma empresa especializada em soluções de automação residencial. Nossa missão é tornar a vida das pessoas mais confortável e eficiente.</p>
                    </div>
                    <div class="footer-column">
                        <h3>Contato</h3>
                        <p>Email: contato@empresa.com</p>
                        <p>Telefone: (00) 1234-5678</p>
                        <p>Endereço: Av. Principal, 123 - Centro, Cidade - Estado</p>
                    </div>
                </div>
                <hr>
                <div class="copyright">
                    <p>&copy; 2024 Mais Lab - Daniel Artur front end developer. Todos os direitos reservados.</p>
                   
                </div>
                <div class="social-links">
                    <a href="https://github.com/seuusuario" target="_blank" class="social-link"><i class="fab fa-github"></i> GitHub</a>
                    <a href="https://www.linkedin.com/in/seuperfil" target="_blank" class="social-link"><i class="fab fa-linkedin"></i> LinkedIn</a>
                </div>
            </div>
        </div>
    </footer>

</body>
</html>