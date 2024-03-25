<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Peças</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Lista de Peças</h1>
    <div class="search-container">
    <form action="<c:url value='/AllParts'/>" method="get">
        <input type="text" id="searchQuery" name="searchQuery" placeholder="Buscar peça pelo nome...">
        <button type="submit">Buscar</button>
    </form>
</div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${parts}" var="part">
                <tr>
                    <td><c:out value="${part.id}"/></td>
                    <td><c:out value="${part.description}"/></td>
                    <td><c:out value="${part.value}"/></td>
                    <td><c:out value="${part.quantity}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
