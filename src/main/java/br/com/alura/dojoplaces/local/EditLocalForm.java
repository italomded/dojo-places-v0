package br.com.alura.dojoplaces.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class EditLocalForm {
    @NotBlank
    @Length(max = 100)
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "não é permitido espaços e caracteres especiais")
    private String code;
    @NotBlank
    @Length(max = 100)
    private String district;
    @NotBlank
    @Length(max = 100)
    private String city;

    public EditLocalForm() {}

    public EditLocalForm(Local local) {
        this.name = local.getName();
        this.code = local.getCode();
        this.district = local.getDistrict();
        this.city = local.getCity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Local toModel() {
        return new Local(name, code, district, city);
    }

    public boolean isClear() {
        return name == null && code == null && district == null && city == null;
    }
}

