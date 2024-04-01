<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de serviços</title>
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
</nav>

<div class="container">
    <div class="row">        
        <div class="col-md-6">
            <h1 class="mt-4 mb-4">Ordens de serviço</h1>
        </div>
        <div class="col-md-6 mt-4 mb-4 text-right d-flex align-items-center justify-content-end">
            <div class="form-group mr-2">
                <input type="text" id="searchQuery" name="searchQuery" class="form-control shadow-sm" placeholder="Buscar peça pelo nome...">
            </div>
            <button type="submit" class="btn btn-primary shadow-sm">Buscar</button>
        </div>
    </div>
    <table class="table">
        <thead >
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${servicesOrder}" var="serviceOrder" >
                    <tr>
                        <td><c:out value="${serviceOrder.id}"/></td>
                        <td><c:out value="${serviceOrder.description}"/></td>
                        <td><c:out value="${serviceOrder.value}"/></td>
                        <td><button data-toggle="modal" data-target="#contratarOrdemServico${serviceOrder.id}" class="btn btn-success shadow-sm" data-id="${serviceOrder.id}" data-descricao="${serviceOrder.description}" data-valor="${serviceOrder.value}" >Contratar</button></td>
                    
                    
                    
                    
                    
                    
                        <div class="modal fade" id="contratarOrdemServico${serviceOrder.id}" tabindex="-1" role="dialog" aria-labelledby="contratarOrdemServicoModalLabel" aria-hidden="true">
    <div class="modal-dialog" id="contratarOrdemServicoModal${serviceOrder.id}" role="document">
        <div class="modal-content text-dark">
            <div class="modal-header">
                <h5 class="modal-title" id="contratarOrdemServicoModal${serviceOrder.id}">Contratar ordem de serviço</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-dark">
                <!-- Formulário para comprar peça -->
                <form class="text-dark" action="${pageContext.request.contextPath}/ServiceOrderVehicleServlet" method="post">
                    <input type="hidden" name="action" value="addServiceOrderVehicle">
                    <input type="hidden" name="id" value="${serviceOrder.id}">
                    <input type="hidden" name="description" value="${serviceOrder.description}">
					<input type="hidden" name="value" value="${serviceOrder.value}">
                    
                    <div class="form-group">
                        <label for="descricao">Descrição: ${serviceOrder.description}</label>
                        <!-- <input type="text" class="form-control" id="descricao" placeholder="Digite a descrição da peça"> -->
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor: ${serviceOrder.value}</label>
                        <!-- <input type="text" class="form-control" id="valor" placeholder="Digite o valor da peça"> -->
                    </div>
                    <div class="form-group">
                        <label for="quantity">Placa: </label>
                        <input type="text" class="form-control" name="plate" id="plate" placeholder="Digite a placa do seu carro">
                    </div>
                    
                    <div class="form-group">
                        <label for="quantity">Ano: </label>
                        <input type="number" class="form-control" name="manufactureYear" id="manufactureYear" placeholder="Digite o ano do seu carro">
                    </div>
                    <div class="form-group">
                        <label for="quantity">modelo: </label>
                        <input type="text" class="form-control" name="model" id="model" placeholder="Digite o modelo do seu carro">
                    </div>
                    <button type="submit"  class="btn btn-success" >Confirmar</button>
                    
                </form>
            </div>
        </div>
    </div>

                    
                </div>
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
