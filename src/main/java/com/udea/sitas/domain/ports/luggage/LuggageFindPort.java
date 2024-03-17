package com.udea.sitas.domain.ports.luggage;

import java.util.List;
import java.util.Optional;

import com.udea.sitas.domain.models.luggage.LuggageResponse;

public interface LuggageFindPort {

    List<LuggageResponse> findAll();

    Optional<LuggageResponse> findById(Long id);

}
