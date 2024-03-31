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
                        <td><button data-toggle="modal" data-target="#comprarPecaModal" class="btn btn-success shadow-sm" data-id="${part.id}" data-descricao="${part.description}" data-valor="${part.value}" data-quantidade="${part.quantity}">Comprar</button></td>
                    
                        <div class="modal fade" id="comprarPecaModal" tabindex="-1" role="dialog" aria-labelledby="comprarPecaModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content text-dark">
            <div class="modal-header">
                <h5 class="modal-title" id="comprarPecaModal">Comprar Nova Peça</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-dark">
                <!-- Formulário para comprar peça -->
                <form class="text-dark" action="${pageContext.request.contextPath}/SaleServlet" method="post">
                    <input type="hidden" name="action" value="addSale">
                    <input type="hidden" name="id" value="${part.id}">
					<input type="hidden" name="value" value="${part.value}">
                    
                    <div class="form-group">
                        <label for="descricao">Descrição: ${part.description}</label>
                        <!-- <input type="text" class="form-control" id="descricao" placeholder="Digite a descrição da peça"> -->
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor: ${part.value}</label>
                        <!-- <input type="text" class="form-control" id="valor" placeholder="Digite o valor da peça"> -->
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantidade: </label>
                        <input type="number" class="form-control" name="quantity" id="quantity" placeholder="Digite a quantidade disponível">
                    </div>
                    <button type="submit"  class="btn btn-success" >Confirmar</button>
                    
                </form>
            </div>
        </div>
    </div>
</div>
                    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    
   <!--  <script>
    document.addEventListener('DOMContentLoaded', function() {
        var formCompraPeca = document.getElementById('formCompraPeca');

        formCompraPeca.addEventListener('submit', function(event) {
            var quantidadeInput = document.getElementById('quantidade');
            var quantidadeDisponivel = document.getElementById('quantity');
            console.log(quantidadeDisponivel)
            var quantidade = parseInt(quantidadeInput.value);

            if (isNaN(quantidade) || quantidade <= 0 || quantidade <= quantidadeDisponivel) {
                alert('Por favor, insira uma quantidade válida.');
                event.preventDefault(); // Impede o envio do formulário
            }
        });
    	});
	</script> -->
    

    
    <!-- Scripts do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

</body>
</html>