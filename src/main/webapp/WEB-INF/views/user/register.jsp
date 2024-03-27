<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Cadastro</h2>
    <form action="UserServlet" method="post">
    	<% if (request.getAttribute("errorMessage") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("errorMessage") %>
                <p class="mt-3">Já tem uma conta registrada? <a href="${pageContext.request.contextPath}/LoginServlet">Login</a></p>
            </div>
        <% } %>
    	<div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" id="cpf" name="cpf" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
