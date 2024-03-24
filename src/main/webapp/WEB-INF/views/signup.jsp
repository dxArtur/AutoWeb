<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar - Loja de Autopeças</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>

<div class="container">
    <header>
        <h1>Registrar</h1>
    </header>

    <div class="welcome-text">
        <p>Crie sua conta para explorar nossos produtos e serviços.</p>
    </div>

    <form action="UserServlet" method="post" class="login-container">
        <div class="input-group">
            <input type="text" id="cpf" name="cpf" placeholder="CPF" required>
        </div>
        <div class="input-group">
            <input type="text" id="name" name="name" placeholder="Nome Completo" required>
        </div>
        <div class="input-group">
            <input type="email" id="email" name="email" placeholder="Email" required>
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" placeholder="Senha" required>
        </div>
        <div class="form-action">
            <button type="submit" class="btn">Registrar</button>
        </div>
    </form>

    <div class="signup-link">
        Já tem uma conta? <a href="<%=request.getContextPath()%>/signin">Entrar</a>
    </div>
</div>

</body>
</html>
