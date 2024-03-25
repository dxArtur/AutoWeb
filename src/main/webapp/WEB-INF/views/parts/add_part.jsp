<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Nova Peça</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<h2>Adicionar Nova Peça</h2>

<form action="${pageContext.request.contextPath}/PartServlet" method="post">
    <div>
        <label for="description">Descrição:</label>
        <input type="text" id="description" name="description" required>
    </div>
    <div>
        <label for="value">Valor:</label>
        <input type="number" id="value" name="value" step="0.01" required>
    </div>
    <div>
        <label for="quantity">Quantidade:</label>
        <input type="number" id="quantity" name="quantity" required>
    </div>
    <button type="submit">Adicionar Peça</button>
</form>

</body>
</html>
