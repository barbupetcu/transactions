package com.transactions.validation.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactions.validation.validators.CnpConstraint;
import com.transactions.validation.validators.IbanConstraint;

import javax.validation.constraints.NotBlank;

public class TransactionActor {

    @NotBlank(message = "Numele este obligatoriu")
    @JsonProperty
    private String name;

    @NotBlank(message = "CNP-ul este obligatoriu")
    @CnpConstraint
    @JsonProperty
    private String cnp;

    @IbanConstraint
    @JsonProperty
    private String iban;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
