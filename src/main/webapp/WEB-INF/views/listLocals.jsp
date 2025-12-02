<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Listar locais</h1>

<a href="local/cadastro">Cadastrar local</a>

<br/>
<br/>

<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Código</th>
            <th>Data de criação</th>
            <th>Dias desde a última atualização</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${locals}" var="local">
            <tr>
                <td>${local.id}</td>
                <td>${local.name}</td>
                <td>${local.code}</td>
                <td>${local.creationDate}</td>
                <td>${local.daysSinceLastUpdate}</td>
                <td><a href="/local/editar/${local.id}">Editar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>