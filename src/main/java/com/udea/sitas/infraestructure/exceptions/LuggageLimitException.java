package com.udea.sitas.infraestructure.exceptions;

public class LuggageLimitException extends RestException {

    public LuggageLimitException(String message) {
        super(message);
    }

    public LuggageLimitException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
    
}
