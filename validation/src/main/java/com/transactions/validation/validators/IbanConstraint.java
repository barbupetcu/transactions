package com.transactions.validation.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/*
Crearea adnotare pentru validarea ibanului
 */
@Documented
@Constraint(validatedBy = IbanValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IbanConstraint {
    String message() default "Ibanul nu este valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}