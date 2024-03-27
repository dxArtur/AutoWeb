<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Peças</title>
</head>
<body>
	<h1>Peças disponíveis</h1>
    
    <%-- Loop para exibir todas as peças --%>
    <ul>
        <%-- Supondo que você tenha uma lista de peças chamada "listaPecas" --%>
        <% for (Peca peca : listaPecas) { %>
            <li>
                <a href="detalhesPeca.jsp?id=<%= peca.getId() %>">
                    <%= peca.getNome() %> - <%= peca.getValue %>
                </a>
            </li>
        <% } %>
    </ul>
</body>
</html>