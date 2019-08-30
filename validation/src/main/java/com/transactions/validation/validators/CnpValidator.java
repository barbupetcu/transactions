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
       if(cnp!=null && cnp.length() == 13){
            int[] cnpArray = new int[13];

            for(int i=0; i<cnp.length(); i++){
                cnpArray[i] = Integer.parseInt(String.valueOf(cnp.charAt(i)));
            }

            long sum = cnpArray[0] * 2 + cnpArray[1] * 7 + cnpArray[2] * 9 + cnpArray[3] * 1 + cnpArray[4] * 4 + cnpArray[5] * 6
                    + cnpArray[6] * 3 + cnpArray[7] * 5 + cnpArray[8] * 8 + cnpArray[9] * 2 + cnpArray[10] * 7 + cnpArray[11] * 9;

            long rest = sum % 11;

            if(((rest < 10) && (rest == cnpArray[12])) || ((rest == 10) && (cnpArray[12] == 1))){
                return true;
            }
        }
        
        return false;
    }




}
