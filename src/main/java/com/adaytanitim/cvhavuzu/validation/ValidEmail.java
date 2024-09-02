package com.adaytanitim.cvhavuzu.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = EmailValidator.class)     //email validatorde çalışacak
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})    //alanda çalışacak
@Retention(RetentionPolicy.RUNTIME)      //çalışma esnasında
public @interface ValidEmail {                //anotasyon oluşut adı ValidEmail
    String message() default "Geçersiz e-posta adresi, '@' işareti eksik";           //default mesajı belirle

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
