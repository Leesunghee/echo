package com.ready2die.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Pattern(regexp = "[a-zA-Z0-9]*") //영숫자일 것
public @interface AlphaNumeric {
    String message() default "{com.ready2die.validation.AlpahNumeric.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        AlphaNumeric[] value();
    }
}
