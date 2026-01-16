<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:dojoHead>
    <script>
        async function deleteLocal(id) {
            const deleteConfirmed = window.confirm("Tem certeza que deseja deletar o Local de ID [" + id + "]?");
            if (!deleteConfirmed) return;
            await fetch(
                "${pageContext.request.contextPath}/local/deletar/" + id,
                {
                    method: "POST"
                }
            ).then(_ => { window.location = "/local"})
        }
    </script>
</tags:dojoHead>
<tags:dojoHeader title="Listar locais"/>
<tags:dojoBody>
    <a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/local/cadastro">Cadastrar local</a>
    <table class="table table-striped-columns table-hover table-bordered align-middle">
        <thead>
        <tr class="table-secondary">
            <th>Id</th>
            <th>Nome</th>
            <th>Código</th>
            <th>Data de criação</th>
            <th>Dias desde a última atualização</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach items="${locals}" var="local">
            <tr>
                <td>${local.id}</td>
                <td>${local.name}</td>
                <td>${local.code}</td>
                <td>${local.creationDate}</td>
                <td>${local.daysSinceLastUpdate}</td>
                <td>
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/local/editar/${local.id}">Editar</a>
                    <a class="btn btn-danger" href="#" onclick="deleteLocal(${local.id})" data-local-id="${local.id}">Deletar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</tags:dojoBody>
