<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="districtId" required="true" type="java.lang.String" %>
<%@ attribute name="cityId" required="true" type="java.lang.String" %>

<section class="card">
    <div class="card-body">
        <h5 class="card-title">ViaCEP</h5>
        <h6 class="card-subtitle mb-2 text-body-secondary">Busque pelo CEP para preencher o bairro e cidade.</h6>
        <div class="col-md-4">
            <div class="input-group has-validation">
                <label for="cep-field" class="input-group-text" id="cep-field-label">CEP</label>
                <input id="cep-field" type="number" class="form-control" onfocusout="cepSearch(this.value)">
                <div id="cep-error" class="invalid-feedback"></div>
            </div>
        </div>
    </div>
</section>

<script>
    const cepFieldMsg = document.querySelector("#cep-error");
    const cepField = document.querySelector("#cep-field");

    async function cepSearch(cep) {
        clearCepError();
        if (!cep) return;
        if (cep.length !== 8) {
            setCepError("O CEP deve conter 8 dígitos.");
            return;
        }

        cepField.disabled = true;
        const response = await fetch("https://viacep.com.br/ws/" + cep + "/json/");
        cepField.disabled = false;

        if (!response.ok) {
            setCepError("Ocorreu um erro ao buscar o CEP informado.");
            return;
        }

        const data = await response.json();
        if (data["erro"] === "true") {
            setCepError("O CEP informado não existe.");
            return;
        }

        document.querySelector("#${districtId}").value = data["bairro"];
        document.querySelector("#${cityId}").value = data["localidade"];
    }

    function setCepError(message) {
        cepFieldMsg.textContent = message;
        cepFieldMsg.style.display = "block";
    }

    function clearCepError() {
        cepFieldMsg.textContent = null;
        cepFieldMsg.style.display = "none";
    }
</script>