package com.rooflyn.account.annotations.classes;

import com.rooflyn.account.annotations.EnumValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumValueValidator implements ConstraintValidator<EnumValue,String> {

    private  Set<String> acceptedValues;


    @Override
    public void initialize(EnumValue annotation) {
        acceptedValues = Arrays.stream(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());


    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || acceptedValues.contains(value);
    }
}
