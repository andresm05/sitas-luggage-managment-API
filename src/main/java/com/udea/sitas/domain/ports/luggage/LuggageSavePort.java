package com.udea.sitas.domain.ports.luggage;


import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.infraestructure.exceptions.RestException;

public interface LuggageSavePort {
    
    LuggageResponse save(LuggageRequest luggageRequest) throws RestException;
}
