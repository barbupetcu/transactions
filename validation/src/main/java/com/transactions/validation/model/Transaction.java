package com.transactions.validation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactions.validation.validators.TransactionTypeContraint;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Transaction {

    @NotBlank(message = "Tipul tranzactiei este obligatoriu")
    @TransactionTypeContraint
    @JsonProperty
    private String type;
    @NotBlank(message = "Descrierea este obligatorie")
    @JsonProperty
    private String description;
    @DecimalMin(value = "0.01", message = "Suma minima transactionata este 0.01")
    @JsonProperty
    private BigDecimal amount;
    @Valid
    @JsonProperty
    private TransactionActor payer;
    @Valid
    @JsonProperty
    private TransactionActor payee;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public TransactionActor getPayer() {
        return payer;
    }

    public void setPayer(TransactionActor payer) {
        this.payer = payer;
    }

    public TransactionActor getPayee() {
        return payee;
    }

    public void setPayee(TransactionActor payee) {
        this.payee = payee;
    }


}
