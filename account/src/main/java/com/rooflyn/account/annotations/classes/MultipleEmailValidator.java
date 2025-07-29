package com.rooflyn.account.annotations.classes;

import com.rooflyn.account.annotations.NoMultipleEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Arrays;
import java.util.regex.Pattern;

public class MultipleEmailValidator implements ConstraintValidator<NoMultipleEmail,String> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) return true;

        return Arrays.stream(value.split(","))
                .map(String::trim)
                .allMatch(email -> EMAIL_PATTERN.matcher(email).matches());

    }
}
