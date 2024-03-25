<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Funcionários</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<div class="container">
    <h1>Funcionários</h1>
    <a href="${pageContext.request.contextPath}/page/employees/add_employee" class="btn">Adicionar Funcionário</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.email}"/></td>
                    <td>        
                        <a href="${pageContext.request.contextPath}/page/employees/edit_employee?id=${employee.id}" class="btn">Editar</a>
                        <a href="${pageContext.request.contextPath}/deleteEmployee?id=${employee.id}" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja deletar este funcionário?');">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
