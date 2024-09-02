package com.adaytanitim.cvhavuzu.validation;

import com.adaytanitim.cvhavuzu.exception.CustomEmailException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || !email.contains("@")) {
            throw new CustomEmailException("Geçersiz e-posta adresi: '@' işareti eksik.");
        }
        return true;
    }
}
