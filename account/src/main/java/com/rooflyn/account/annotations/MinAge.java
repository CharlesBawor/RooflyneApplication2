package com.rooflyn.account.annotations;

import com.rooflyn.account.annotations.classes.MinAgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinAgeValidator.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinAge {
    String message() default "You must be at least {value} ";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    int value();
}
