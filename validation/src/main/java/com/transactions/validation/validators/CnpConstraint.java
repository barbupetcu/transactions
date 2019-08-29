package com.transactions.validation.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/*
Crearea adnotare pentru validarea cnpuluui
 */
@Documented
@Constraint(validatedBy = CnpValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CnpConstraint {
    String message() default "CNP-ul nu este valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}