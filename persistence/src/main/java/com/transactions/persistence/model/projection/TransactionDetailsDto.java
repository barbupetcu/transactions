package com.transactions.persistence.model.projection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionDetailsDto {

    @JsonProperty
    private String description;

    @JsonProperty
    private BigDecimal amount;

    @JsonProperty
    private String payeeName;

    @JsonProperty
    private String payeeCnp;

    @JsonProperty
    private String payeeIban;

    public TransactionDetailsDto(String description, BigDecimal amount, String payeeName, String payeeCnp, String payeeIban) {
        this.description = description;
        this.amount = amount;
        this.payeeName = payeeName;
        this.payeeCnp = payeeCnp;
        this.payeeIban = payeeIban;
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

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeCnp() {
        return payeeCnp;
    }

    public void setPayeeCnp(String payeeCnp) {
        this.payeeCnp = payeeCnp;
    }

    public String getPayeeIban() {
        return payeeIban;
    }

    public void setPayeeIban(String payeeIban) {
        this.payeeIban = payeeIban;
    }
}
