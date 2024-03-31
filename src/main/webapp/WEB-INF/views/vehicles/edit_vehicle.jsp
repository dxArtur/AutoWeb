<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Veículo</title>
    <!-- Inclua o Bootstrap para estilizar a página -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Editar Veículo</h2>
    <form action="${pageContext.request.contextPath}/VehicleServlet" method="post">
        <input type="hidden" name="action" value="updateVehicle">
        <input type="hidden" name="originalPlate" value="${vehicle.plate}">

        <div class="form-group">
            <label for="plate">Placa:</label>
            <input type="text" class="form-control" id="plate" name="plate" value="${vehicle.plate}" required>
        </div>

        <div class="form-group">
            <label for="model">Modelo:</label>
            <input type="text" class="form-control" id="model" name="model" value="${vehicle.model}" required>
        </div>

        <div class="form-group">
            <label for="manufactureYear">Ano de Fabricação:</label>
            <input type="number" class="form-control" id="manufactureYear" name="manufactureYear" value="${vehicle.manufactureYear}" required>
        </div>

        <button type="submit" class="btn btn-primary">Atualizar</button>
        <a href="${pageContext.request.contextPath}/VehicleServlet" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<!-- Bootstrap JS e dependências -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
