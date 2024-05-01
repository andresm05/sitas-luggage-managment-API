package com.udea.sitas.infraestructure.exceptions;

public class LuggageMeasurementException extends RestException {

    public LuggageMeasurementException(String message) {
        super(message);
    }

    public LuggageMeasurementException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
    
}
