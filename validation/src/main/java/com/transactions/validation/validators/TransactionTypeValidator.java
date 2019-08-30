package com.transactions.validation.validators;

import com.transactions.validation.model.Transaction;
import com.transactions.validation.utils.TransactionType;
import org.apache.commons.lang3.EnumUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TransactionTypeValidator implements ConstraintValidator<TransactionTypeContraint, String> {

    @Override
    public void initialize(TransactionTypeContraint TransactionTypeConstraint) {
    }

    /*
    * Metoda in care se face validarea, daca aceasta returneaza false atunci
    *  este aruncata exceptia MethodArgumentNotValidException cu mesajul din interfata TransactionTypeConstraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return EnumUtils.isValidEnum(Transaction.TransactionType.class, value);
    }


}
