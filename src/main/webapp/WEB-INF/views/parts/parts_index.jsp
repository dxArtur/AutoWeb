<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Inicial de Peças</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Gerenciamento de Peças</h1>
    <div>
        <a href="${pageContext.request.contextPath}/PartServlet">Ver Lista de Peças</a>
		<a href="<c:url value='/page/parts/add_part'/>" class="btn">Adicionar Nova Peça</a>
		<a href="${pageContext.request.contextPath}/Admin.jsp">Listar Peças</a>
    </div>
</div>

</body>
</html>
