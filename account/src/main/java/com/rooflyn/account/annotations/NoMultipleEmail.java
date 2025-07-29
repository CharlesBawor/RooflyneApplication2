package com.rooflyn.account.annotations;

import com.rooflyn.account.annotations.classes.MultipleEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipleEmailValidator.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoMultipleEmail {
    String message() default "No multiple emails";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
