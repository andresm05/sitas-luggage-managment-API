package com.udea.sitas.infraestructure.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

    private String message;

    private String details;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message, String details) {
        this.message = message;
        this.details = details;
    }
    
}
