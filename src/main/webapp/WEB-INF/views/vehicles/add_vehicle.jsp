<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Veículo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Adicionar Novo Veículo</h2>
    <form action="${pageContext.request.contextPath}/VehicleServlet" method="post">
    	<input type="hidden" name="action" value="addVehicle">
        <div class="form-group">
            <label for="plate">Placa:</label>
            <input type="text" id="plate" name="plate" required class="form-control">
        </div>
        <div class="form-group">
            <label for="model">Modelo:</label>
            <input type="text" id="model" name="model" required class="form-control">
        </div>
        <div class="form-group">
            <label for="manufactureYear">Ano de Fabricação:</label>
            <input type="number" id="manufactureYear" name="manufactureYear" required class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Adicionar</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.9/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
