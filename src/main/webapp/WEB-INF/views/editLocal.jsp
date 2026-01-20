<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:dojoHead/>
<tags:dojoHeader title="Cadastrar local"/>
<tags:dojoBody>
    <a class="btn btn-warning mb-3" href="${pageContext.request.contextPath}/local">Voltar</a>
    <form:form modelAttribute="editLocalForm" method="post"
               action="${pageContext.request.contextPath}/local/editar/${id}">
        <form:input type="hidden" path="id"/>

        <label class="form-label">Nome:</label>
        <form:input cssClass="form-control" path="name"/>
        <form:errors path="name" cssStyle="color: red; display: block"/>

        <label class="form-label mt-2">Codigo:</label>
        <form:input cssClass="form-control" path="code"/>
        <form:errors path="code" cssStyle="color: red; display: block"/>

        <br/>
        <tags:cepSearch districtId="district" cityId="city"/>
        <br/>

        <label class="form-label mt-2">Bairro:</label>
        <form:input cssClass="form-control" path="district"/>
        <form:errors path="district" cssStyle="color: red; display: block"/>

        <label class="form-label mt-2">Cidade:</label>
        <form:input cssClass="form-control" path="city"/>
        <form:errors path="city" cssStyle="color: red; display: block"/>

        <button class="btn btn-primary mt-3">Editar</button>
    </form:form>
</tags:dojoBody>
