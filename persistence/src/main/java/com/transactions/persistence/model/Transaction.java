package com.transactions.persistence.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_transactions_seq")
    @SequenceGenerator(name="id_transactions_seq", sequenceName = "id_transactions_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "TYPE")
    private String type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PAYER")
    private TransactionActor payer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PAYEE")
    private TransactionActor payee;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
