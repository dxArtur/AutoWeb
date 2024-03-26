<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Loja de Autopeças</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>

<div class="login-container">
    <h1>Login</h1>
    <p>Acesse sua conta:</p>
    <form action="LoginServlet" method="post">
        <div class="input-group">
            <input type="email" id="email" name="email" placeholder="Digite seu email" required>
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" placeholder="Digite sua senha" required>
        </div>
        <div class="form-action">
            <button type="submit" class="btn">Entrar</button>
        </div>
    </form>
    <div class="signup-link">
        Não tem uma conta? <a href="<%=request.getContextPath()%>/signup">Registre-se</a>
    </div>
</div>

</body>
</html>