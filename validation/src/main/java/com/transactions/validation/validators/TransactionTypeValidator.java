
package com.transactions.validation.validators;

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransactionTypeValidator implements ConstraintValidator<TransactionTypeConstraint, String> {
  
  private final static List<String> transactionsTypes = Arrays.asList("IBAN_TO_IBAN","IBAN_TO_WALLET","WALLET_TO_IBAN","WALLET_TO_WALLET");

    @Override
    public void initialize(TransactionTypeConstraint TransactionTypeConstraint) {
    }

    /*
    * Metoda in care se face validarea, daca aceasta returneaza false atunci
    *  este aruncata exceptia MethodArgumentNotValidException cu mesajul din interfata TransactionTypeConstraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return transactionsTypes.contains(value);
    }


}
