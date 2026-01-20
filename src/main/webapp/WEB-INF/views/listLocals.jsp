<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:dojoHead>
    <script src="${pageContext.request.contextPath}/js/listLocals.js"></script>
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
                    <a class="btn btn-danger" href="#" onclick="showDeleteModal(${local.id})">Deletar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirmar ação</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Tem certeza que deseja deletar o local?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button id="confirmDeleteButton" type="button" class="btn btn-danger">Confirmar</button>
                </div>
            </div>
        </div>
    </div>
</tags:dojoBody>
