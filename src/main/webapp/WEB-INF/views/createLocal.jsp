<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<h1>Cadastrar local</h1>
<a href="/local">Voltar</a>

<br/>
<br/>

<form:form modelAttribute="createLocalForm" method="post" action="/local/cadastro">

    <label>Nome:</label>
    <form:input path="name"/>
    <br/>
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Codigo:</label>
    <form:input path="code"/>
    <br/>
    <form:errors path="code" cssStyle="color: red"/>

    <br/>
    <br/>

    <tags:cepSearch distrinctId="district" cityId="city"/>

    <br/>
    <br/>

    <label>Bairro:</label>
    <form:input path="district"/>
    <br/>
    <form:errors path="district" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Cidade:</label>
    <form:input path="city"/>
    <br/>
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>