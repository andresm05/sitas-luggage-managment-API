package com.udea.sitas.infraestructure.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler extends RuntimeException {

    @ExceptionHandler(NumberNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNumberNotValidException(Exception e) {
        return new ErrorMessage(e.getMessage(), "el número no es válido");
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNoSuchElementException(Exception e) {
        return new ErrorMessage(e.getMessage(), "no se encontró el elemento");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNullPointerException(Exception e) {
        return new ErrorMessage(e.getMessage(), "el objeto no puede ser nulo");

    }

}
