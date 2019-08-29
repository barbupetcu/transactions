package com.transactions.validation.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/*
Crearea adnotare pentru validarea ibanului
 */
@Documented
@Constraint(validatedBy = TransactionTypeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionTypeContraint {
    String message() default "Tipul tranzactiei nu este valid nu este valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
