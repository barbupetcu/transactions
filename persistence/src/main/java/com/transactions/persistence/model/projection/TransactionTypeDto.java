package com.transactions.persistence.model.projection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDto {

    @JsonProperty
    private String type;

    @JsonProperty
    private String count;

    @JsonProperty
    private BigDecimal total;

    @JsonProperty
    private List<TransactionDetailsDto> details;

    public TransactionTypeDto(String type, String count) {
        this.type = type;
        this.count = count;
    }

    public TransactionTypeDto(String type, String count, BigDecimal total) {
        this.type = type;
        this.count = count;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionDetailsDto> getDetails() {
        return details;
    }

    public void setDetails(List<TransactionDetailsDto> details) {
        this.details = details;
    }

}
