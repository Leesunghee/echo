package com.ready2die.common.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualsPropertyValuesValidator implements ConstraintValidator<EqualsPropertyValues, Object> {

    private String property;
    private String comparingPropery;
    private String message;


    public void initialize(EqualsPropertyValues constraintAnnotation) {
        this.property = constraintAnnotation.property();
        this.comparingPropery = constraintAnnotation.comparingProperty();
        this.message = constraintAnnotation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 두 개의 프로퍼티 값을 가져와서 비교
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object propertyValue = beanWrapper.getPropertyValue(property);
        Object comparingProperyValue = beanWrapper.getPropertyValue(comparingPropery);
        boolean matched = ObjectUtils.nullSafeEquals(propertyValue, comparingProperyValue);

        if (matched) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(property).addConstraintViolation();
            return false;
        }

    }
}
