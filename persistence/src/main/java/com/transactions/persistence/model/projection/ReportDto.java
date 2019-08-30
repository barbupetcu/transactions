package com.transactions.persistence.model.projection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactions.persistence.model.TransactionActor;

import java.util.List;

public class ReportDto {

    @JsonProperty
    private String name;

    @JsonProperty
    private String cnp;

    @JsonProperty
    private String iban;

    @JsonProperty
    private List<TransactionTypeDto> transactions;

    public ReportDto(TransactionActor transactionActor) {
        this.name = transactionActor.getName();
        this.cnp = transactionActor.getCnp();
        this.iban = transactionActor.getIban();

    }

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

    public List<TransactionTypeDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionTypeDto> transactions) {
        this.transactions = transactions;
    }
}
