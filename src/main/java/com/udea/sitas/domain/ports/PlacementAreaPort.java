package com.udea.sitas.domain.ports;

import java.util.List;

import com.udea.sitas.domain.models.placementArea.PlacementAreaResponse;

public interface PlacementAreaPort {

    List<PlacementAreaResponse> findAll();

    PlacementAreaResponse findById(Long id);
    
}
