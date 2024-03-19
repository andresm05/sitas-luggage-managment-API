package com.udea.sitas.domain.ports.luggage;

import java.util.List;

import com.udea.sitas.domain.models.luggage.LuggageResponse;

public interface LuggageFindByPlacementAreaPort {

    List<LuggageResponse> findByPlacementArea(Long placementAreaId);
    
}
