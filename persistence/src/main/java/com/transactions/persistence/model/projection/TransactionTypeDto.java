package com.transactions.persistence.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({"type","count","total","details"})
public class TransactionTypeDto {

    @JsonProperty
    private String type;

    @JsonIgnore
    private String count;

    @JsonIgnore
    private BigDecimal total;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TransactionDetailsDto> details;

    public TransactionTypeDto(String type) {
        this.type = type;
    }

    public TransactionTypeDto(String type, Long count, BigDecimal total) {
        this.type = type;
        this.count = count.toString();
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

    @JsonProperty("total")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAmountAsString() {
        if (this.total != null)
            return this.total.toString() + " RON";
        else return null;
    }

    @JsonProperty("count")
    private String adjustTransCount (){
        if (StringUtils.isEmpty(this.count)){
            return "fara tranzactii";
        }
        else{
            if (Integer.parseInt(this.count) == 1){
                return this.count + " tranzactie";
            }
            else{
                return this.count + " tranzactii";
            }
        }
    }
}
