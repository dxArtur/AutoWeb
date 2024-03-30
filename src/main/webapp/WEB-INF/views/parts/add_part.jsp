<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Nova Peça</title>
    <!-- Inclusão do CSS do Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Adicionar Nova Peça</h2>

    <form action="${pageContext.request.contextPath}/AllPartsServlet" method="post">
         <input type="hidden" name="action" value="insert">
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" id="description" name="description" required class="form-control">
        </div>
        <div class="form-group">
            <label for="value">Valor:</label>
            <input type="number" id="value" name="value" step="0.01" required class="form-control">
        </div>
        <div class="form-group">
            <label for="quantity">Quantidade:</label>
            <input type="number" id="quantity" name="quantity" required class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Adicionar Peça</button>
    </form>
</div>

<!-- Scripts necessários para o Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.9/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
