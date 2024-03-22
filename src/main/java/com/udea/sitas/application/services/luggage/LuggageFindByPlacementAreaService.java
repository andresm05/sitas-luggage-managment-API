package com.udea.sitas.application.services.luggage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udea.sitas.domain.entities.PlacementAreaEntity;
import com.udea.sitas.domain.mappers.luggage.LuggageResponseMapper;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.domain.ports.luggage.ILuggageFindByPlacementAreaPort;
import com.udea.sitas.infraestructure.repositories.LuggageRepository;
import com.udea.sitas.infraestructure.repositories.PlacementAreaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LuggageFindByPlacementAreaService implements ILuggageFindByPlacementAreaPort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public List<LuggageResponse> findByPlacementArea(Long placementAreaId) {

        // search for the placement area in the database
        PlacementAreaEntity placementArea = placementAreaRepository.findById(placementAreaId).orElseThrow();

        // search for the luggage in the database by the placement area
        return luggageRepository.findByPlacementArea(placementArea).stream()
                .map(luggage -> LuggageResponseMapper.builder()
                        .withLuggageEntity(luggage)
                        .mapToResponse())
                .collect(Collectors.toList());
    }

}
