package com.transactions.validation.validators;

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IbanValidator implements ConstraintValidator<IbanConstraint, String> {

    @Override
    public void initialize(IbanConstraint ibanConstraint) {
    }

    /*
    * Metoda in care se face validarea, daca aceasta returneaza false atunci
    *  este aruncata exceptia MethodArgumentNotValidException cu mesajul din interfata IbanConstraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //in cazul in care ibanul este empty se va ocupa validatorul @Conditional
        if (StringUtils.isEmpty(value)){
            return true;
        }
        IBANCheckDigit ibanCheckDigit = new IBANCheckDigit();
        return ibanCheckDigit.isValid(value);
    }


}
