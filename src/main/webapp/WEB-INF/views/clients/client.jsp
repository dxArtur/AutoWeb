<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Clientes</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-dark text-light">
    
    <div class="container-fluid">
        <h1 class="mt-4 mb-3 text-light">Clientes</h1>
    
        <!-- Botão para adicionar nova peça -->
        <button class="btn btn-primary mb-3" data-toggle="modal" data-target="#novaPecaModal">Adicionar Nova Peça</button>
        <table class="table text-light">
            <thead>
                <tr>
                    
                    <th>Cpf</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="costumer" items="${costumers}"></c:forEach>
                <!-- Exemplo de linha da tabela -->
                <tr>
                    
                    <td>123.456.789-00 <c:out value="${costumer.cpf}" /></td>
                    <td>john doe<c:out value="${costumer.name}" /></td>
                    <td>johndoe@user.com <c:out value="${costumer.email}" /></td>
                    <td>
                        <!-- Botões de ação -->
                        <button class="btn btn-primary btn-sm mr-2">Editar</button>
                    </td>
                </tr>
                <!-- Adicione mais linhas conforme necessário -->
            </tbody>
        </table>
    </div>
    
    <!-- Modal para adicionar nova peça -->
    <div class="modal fade" id="novaPecaModal" tabindex="-1" role="dialog" aria-labelledby="novaPecaModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="novaPecaModalLabel">Adicionar Nova Peça</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Formulário para adicionar nova peça -->
                    <form action="/AutoWeb/PartServlet" method="post">
                        <div class="form-group">
                            <label for="descricao">Descrição:</label>
                            <input type="text" class="form-control" id="descricao" placeholder="Digite a descrição da peça">
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor:</label>
                            <input type="text" class="form-control" id="valor" placeholder="Digite o valor da peça">
                        </div>
                        <div class="form-group">
                            <label for="quantidade">Quantidade:</label>
                            <input type="number" class="form-control" id="quantidade" placeholder="Digite a quantidade disponível">
                        </div>
                        <button type="submit" class="btn btn-primary">Adicionar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Adicione o link para o arquivo JavaScript do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
    </html>