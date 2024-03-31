<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Peças</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Peças</h1>
    <a href="<c:url value='/AddPartServlet'/>" class="btn btn-success mb-3">Adicionar Nova Peça</a>
    <!-- Botão para ir para a página Admin.jsp -->
    <a href="<c:url value='/adminAccess'/>" class="btn btn-info mb-3">Página Admin</a>
    <div class="search-container mb-3">
        <form action="<c:url value='/AllPartsServlet'/>" method="get" class="form-inline">
            <input type="hidden" name="action" value="search">
            <input type="text" id="searchQuery" name="searchQuery" class="form-control mr-2" placeholder="Buscar peça pelo nome...">
            <button type="submit" class="btn btn-outline-primary">Buscar</button>
        </form>
    </div>
    <c:if test="${not empty parts}">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Quantidade</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${parts}" var="part">
                <tr>
                    <td><c:out value="${part.id}"/></td>
                    <td><c:out value="${part.description}"/></td>
                    <td><c:out value="${part.value}"/></td>
                    <td><c:out value="${part.quantity}"/></td>
                    <td>        
                        <a href="<c:url value='/AllPartsServlet?action=edit&id=${part.id}'/>" class="btn btn-primary">Editar</a>           
                        <a href="<c:url value='/AllPartsServlet?action=delete&id=${part.id}'/>" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja deletar essa peça?');">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </c:if>
	<c:if test="${empty parts}">
	    <p>Nenhuma peça encontrada.</p>
	</c:if>
</div>

<!-- Bootstrap JS e dependências -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>