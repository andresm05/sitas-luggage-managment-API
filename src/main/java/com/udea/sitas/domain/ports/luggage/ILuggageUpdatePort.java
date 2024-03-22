package com.udea.sitas.domain.ports.luggage;

import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.infraestructure.exceptions.RestException;

public interface ILuggageUpdatePort {
    
    LuggageResponse update(LuggageRequest luggageRequest, Long id) throws RestException;
}
