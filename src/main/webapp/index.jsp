<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bem-vindo à Loja de Autopeças</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>

<div class="container">
    <header>
        <h1>Loja de Autopeças</h1>
    </header>

    <div class="welcome-text">
        <p>Bem-vindo à nossa loja de autopeças. Aqui você encontra tudo o que precisa para o seu veículo!</p>
    </div>

    <div class="action-buttons">
        <a href="<%=request.getContextPath()%>/signin" class="btn">Login</a>
        <a href="<%=request.getContextPath()%>/signup" class="btn btn-secondary">Registrar</a>
    </div>
</div>

</body>
</html>
