package com.adaytanitim.cvhavuzu.validation;

import com.adaytanitim.cvhavuzu.exception.CustomEmailException;
import com.adaytanitim.cvhavuzu.model.Candidate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class EmailValidator implements ConstraintValidator<ValidEmail, Candidate> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {    //başlat
    }

    @Override
    public boolean isValid(Candidate candidate, ConstraintValidatorContext constraintValidatorContext) {
        if (candidate.getEmail() == null || !candidate.getEmail().contains("@")) {     //null değilse veya @ işareti yoksa
            throw new CustomEmailException("Geçersiz e-posta adresi: '@' işareti eksik.");    //custom email exception fırlat
        }
        return true;
    }
/*


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || !email.contains("@")) {     //null değilse veya @ işareti yoksa
            throw new CustomEmailException("Geçersiz e-posta adresi: '@' işareti eksik.");    //custom email exception fırlat
        }
        return true;
    }

 */
}


