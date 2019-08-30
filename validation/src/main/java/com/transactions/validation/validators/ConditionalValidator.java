package com.transactions.validation.validators;

import com.transactions.validation.producer.TransactionSender;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.springframework.util.StringUtils.isEmpty;

public class ConditionalValidator implements ConstraintValidator<Conditional, Object> {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionSender.class);


    private String selected;
    private String[] required;
    private String message;
    private String[] values;

    @Override
    public void initialize(Conditional requiredIfChecked) {
        selected = requiredIfChecked.selected();
        required = requiredIfChecked.required();
        message = requiredIfChecked.message();
        values = requiredIfChecked.values();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Boolean valid = true;
        try {
            Object checkedValue = BeanUtils.getProperty(object, selected);
            if (Arrays.asList(values).contains(checkedValue)) {
                for (String propName : required) {
                    Object requiredValue = BeanUtils.getProperty(object, propName);
                    valid = requiredValue != null && !isEmpty(requiredValue);
                    System.out.println("value: " + "" + requiredValue);
                    if (!valid) {
                        context.disableDefaultConstraintViolation();
                        context.buildConstraintViolationWithTemplate(message).addPropertyNode(propName).addConstraintViolation();
                        //returnam false pentru a nu continua cu membrii obiectului null
                        return false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            LOG.error("Accessor method is not available for class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        } catch (NoSuchMethodException e) {
            LOG.error("Field or method is not present on class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        } catch (InvocationTargetException e) {
            LOG.error("An exception occurred while accessing class : {}, exception : {}", object.getClass().getName(), e);
            return false;
        }
        return valid;
    }
}
