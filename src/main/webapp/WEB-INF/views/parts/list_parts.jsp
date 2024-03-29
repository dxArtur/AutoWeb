<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Peças</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Autobulls</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Início</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Serviços</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contato</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 class="mt-4 mb-4">Lista de Peças</h1>
            </div>
            <div class="col-md-6 text-right d-flex align-items-center justify-content-end">
                <a href="${pageContext.request.contextPath}/page/parts/add_part" class="btn btn-success">Adicionar Nova Peça</a>
            </div>
        </div>
        <table class="table">
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
                <c:if test="${empty parts}">
                    <tr>
                        <td colspan="5">Nenhuma peça encontrada.</td>
                    </tr>
                </c:if>
                <c:forEach items="${parts}" var="part">
                    <tr>
                        <td>${part.id}</td>
                        <td>${part.description}</td>
                        <td>${part.value}</td>
                        <td>${part.quantity}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/page/parts/edit_part?id=${part.id}" class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/PartServlet?action=delete&id=${part.id}" onclick="return confirm('Tem certeza que deseja deletar esta peça?');" class="btn btn-sm btn-danger">Deletar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

</body>
</html>
