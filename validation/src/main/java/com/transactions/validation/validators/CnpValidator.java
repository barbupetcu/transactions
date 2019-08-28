package com.transactions.validation.validators;

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CnpValidator implements ConstraintValidator<CnpConstraint, String> {

    @Override
    public void initialize(CnpConstraint cnpConstraint) {
    }

    /*
    * Metoda in care se face validarea, daca aceasta returneaza false atunci
    *  este aruncata exceptia MethodArgumentNotValidException cu mesajul din interfata IbanConstraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkCnp(value);
    }

    //todo completat metoda de validare a cnpului
    private boolean checkCnp(String cnp){
        return true;
    }




}
