package com.transactions.validation.utils;

public enum TransactionType {

    IBAN_TO_IBAN("IBAN_TO_IBAN"),
    IBAN_TO_WALLET("IBAN_TO_WALLET"),
    WALLET_TO_IBAN("WALLET_TO_IBAN"),
    WALLET_TO_WALLET("WALLET_TO_WALLET");

    private String type;

    TransactionType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
