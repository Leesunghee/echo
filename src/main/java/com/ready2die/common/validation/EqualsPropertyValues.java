package com.ready2die.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EqualsPropertyValuesValidator.class})
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualsPropertyValues {

    String message() default "{com.ready2die.common.validation.EqualsPropertyValues.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String property();
    String comparingProperty();

    @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        EqualsPropertyValues[] value();
    }
}
