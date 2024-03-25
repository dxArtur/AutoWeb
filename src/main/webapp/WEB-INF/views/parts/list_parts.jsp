<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Peças</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Lista de Peças</h1>
    <a href="${pageContext.request.contextPath}/page/parts/add_part" class="btn">Adicionar Nova Peça</a>
    <table>
        <thead>
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
                    <td>${part.id}</td>
                    <td>${part.description}</td>
                    <td>${part.value}</td>
                    <td>${part.quantity}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/page/parts/edit_part?id=${part.id}" class="btn">Editar</a>
                        <a href="${pageContext.request.contextPath}/PartServlet?action=delete&id=${part.id}" onclick="return confirm('Tem certeza que deseja deletar esta peça?');" class="btn btn-danger">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
