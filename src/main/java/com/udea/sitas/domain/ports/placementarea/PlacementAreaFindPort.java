package com.udea.sitas.domain.ports.placementarea;

import java.util.List;
import java.util.Optional;

import com.udea.sitas.domain.models.placementArea.PlacementAreaResponse;

public interface PlacementAreaFindPort {

    List<PlacementAreaResponse> findAll();

    Optional<PlacementAreaResponse> findById(Long id);
    
}
