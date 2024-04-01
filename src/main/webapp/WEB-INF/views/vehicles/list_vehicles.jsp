<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Veículos</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Veículos</h1>
    <a href="<c:url value='/AddVehicleServlet'/>" class="btn btn-success mb-3">Adicionar Novo Veículo</a>
    <!-- Botão para ir para a página Admin.jsp -->
    <a href="<c:url value='/adminAccess'/>" class="btn btn-info mb-3">Página Admin</a>
    <c:if test="${not empty vehicles}">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>Placa</th>
                <th>Modelo</th>
                <th>Ano de Fabricação</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${vehicles}" var="vehicle">
                <tr>
                    <td><c:out value="${vehicle.plate}"/></td>
                    <td><c:out value="${vehicle.model}"/></td>
                    <td><c:out value="${vehicle.manufactureYear}"/></td>
                    <td>        
                        <a href="<c:url value='/VehicleServlet?action=edit&plate=${vehicle.plate}'/>" class="btn btn-primary">Editar</a>           
                        <a href="<c:url value='/VehicleServlet?action=delete&plate=${vehicle.plate}'/>" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja deletar este veículo?');">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </c:if>
    <c:if test="${empty vehicles}">
	    <p>Nenhum veículo encontrado.</p>
	</c:if>
</div>

<!-- Bootstrap JS e dependências -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
