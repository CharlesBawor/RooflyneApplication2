package com.rooflyn.account.annotations;

import com.rooflyn.account.annotations.classes.BadWordsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BadWordsValidator.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoBadWords {
    String message() default "Contains inappropriate language";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
