<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Funcionários</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="mb-4">Funcionários</h1>
    <a href="<c:url value='/AddEmployeeServlet'/>" class="btn btn-success mb-3">Adicionar Funcionário</a>
    <!-- Botão para ir para a página Admin.jsp -->
    <a href="<c:url value='/adminAccess'/>" class="btn btn-info mb-3">Página Admin</a>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
                <th>Cargo</th>
                <th>Salário</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.email}"/></td>
                    <td><c:out value="${employee.cpf}"/></td>
                    <td><c:out value="${employee.position}"/></td>
                    <td><c:out value="${employee.salary}"/></td>                
                    <td>        
                        <a href="<c:url value='/EmployeeServlet?action=edit&id=${employee.id}'/>" class="btn btn-primary">Editar</a>           
                        <a href="<c:url value='/EmployeeServlet?action=delete&id=${employee.id}'/>" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja deletar este funcionário?');">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>