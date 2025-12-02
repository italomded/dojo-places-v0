package br.com.alura.dojoplaces.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class CreateLocalForm {
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
}

