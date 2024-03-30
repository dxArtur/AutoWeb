<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Peça</title>
    <!-- Inclusão do CSS do Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Editar Peça</h2>

    <!-- Substitua a ação e os métodos conforme necessário -->
    <form action="${pageContext.request.contextPath}/AllPartsServlet?action=update" method="post">
        <!-- Campo oculto para passar o ID da peça que está sendo editada -->
        <input type="hidden" name="id" value="${part.id}">

        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" id="description" name="description" value="${part.description}" required class="form-control">
        </div>
        <div class="form-group">
            <label for="value">Valor:</label>
            <input type="number" id="value" name="value" value="${part.value}" step="0.01" required class="form-control">
        </div>
        <div class="form-group">
            <label for="quantity">Quantidade:</label>
            <input type="number" id="quantity" name="quantity" value="${part.quantity}" required class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Atualizar</button>
        <a href="${pageContext.request.contextPath}/AllPartsServlet" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<!-- Scripts necessários para o Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.9/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
