package com.transactions.validation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactions.validation.validators.CnpConstraint;
import com.transactions.validation.validators.IbanConstraint;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Transaction {

    @NotBlank(message = "Tipul tranzactiei este obligatoriu")
    @TransactionTypeContraint
    @JsonProperty
    private String type;
    @NotBlank(message = "Ibanul este obligatoriu")
    @IbanConstraint
    @JsonProperty
    private String iban;
    @NotBlank(message = "CNP-ul este obligatoriu")
    @CnpConstraint
    @JsonProperty
    private String cnp;
    @NotBlank(message = "Numele este obligatoriu")
    @JsonProperty
    private String name;
    @NotBlank(message = "Descrierea este obligatorie")
    @JsonProperty
    private String description;
    @DecimalMin(value = "0.01", message = "Suma minima transactionata este 0.01")
    @JsonProperty
    private BigDecimal amount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
