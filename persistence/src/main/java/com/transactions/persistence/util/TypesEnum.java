package com.transactions.persistence.util;

public enum TypesEnum {

    IBAN_TO_IBAN("IBAN_TO_IBAN"),
    IBAN_TO_WALLET("IBAN_TO_WALLET"),
    WALLET_TO_IBAN("WALLET_TO_IBAN"),
    WALLET_TO_WALLET("WALLET_TO_WALLET");

    private String type;

    TypesEnum(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
