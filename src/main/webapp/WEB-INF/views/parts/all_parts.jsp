<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Peças</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
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
            <div class="col-md-6 mt-4 mb-4 text-right d-flex align-items-center justify-content-end">
                <form action="<c:url value='/AllParts'/>" method="get" class="form-inline">
                    <div class="form-group mr-2">
                        <input type="text" id="searchQuery" name="searchQuery" class="form-control shadow-sm" placeholder="Buscar peça pelo nome...">
                    </div>
                    <button type="submit" class="btn btn-primary shadow-sm">Buscar</button>
                </form>
            </div>
        </div>
        <table class="table">
            <thead >
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
    
    <!-- Scripts do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

</body>
</html>