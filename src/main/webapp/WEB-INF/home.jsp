<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header class="header-container">
        <h2>Bem-vindo ao AutoBulls   </h2>
        <nav>
            <ul>
                <li><a href="index.jsp">Início</a></li>
                <li><a href="produtos.jsp">Veículos</a></li>
                <li><a href="servicos.jsp">Serviços</a></li>
                <li><a href="contato.jsp">Contato</a></li>
            </ul>
        </nav>
	</header>
	
	<main>
        <section class="destaques">
            <h2>Comprar peças</h2>
            <!-- Adicione os produtos em destaque aqui -->
            <div class="produto">
                <img src="caminho/para/imagem1.jpg" alt="Produto 1">
                <h3>Nome do Produto 1</h3>
                <p>Descrição breve do Produto 1.</p>
                <span>R$ 100,00</span>
                <a href="detalhes-produto.jsp?id=1">Detalhes</a>
            </div>
            <!-- Adicione mais produtos em destaque conforme necessário -->
        </section>

        <section class="servicos">
            <h2>Novo serviços</h2>
            <!-- Adicione os serviços oferecidos aqui -->
            <div class="servico">
                <h3>Serviço 1</h3>
                <p>Descrição do Serviço 1.</p>
                <a href="detalhes-servico.jsp?id=1">Detalhes</a>
            </div>
            <!-- Adicione mais serviços conforme necessário -->
        </section>
    </main>
    
    <footer>
        <p>&copy; 2024 Mais Lab - </p>
    </footer>

</body>
</html>