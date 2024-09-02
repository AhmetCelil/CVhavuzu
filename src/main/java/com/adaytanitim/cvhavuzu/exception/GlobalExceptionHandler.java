package com.adaytanitim.cvhavuzu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomEmailException.class)  //custom olan exceptionları yaklar işler
    @ResponseStatus(HttpStatus.BAD_REQUEST) //istekte hata varsa 400 kodu üretir
    public ResponseEntity<String> handleCustomEmailException(CustomEmailException ex) { //yakalanan hata burada bulunur
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}