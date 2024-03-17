package com.udea.sitas.application.services.placementArea;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udea.sitas.domain.mappers.placementarea.PlacementAreaResponseMapper;
import com.udea.sitas.domain.models.placementArea.PlacementAreaResponse;
import com.udea.sitas.domain.ports.placementarea.PlacementAreaFindPort;
import com.udea.sitas.infraestructure.repositories.PlacementAreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlacementAreaFindService implements PlacementAreaFindPort {

    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public List<PlacementAreaResponse> findAll() {

        return placementAreaRepository.findAll().stream()
                .map(placementArea -> PlacementAreaResponseMapper.builder()
                        .withPlacementAreaEntity(placementArea)
                        .mapToResponse())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlacementAreaResponse> findById(Long id) {
        
        return placementAreaRepository.findById(id).map(placementArea -> PlacementAreaResponseMapper.builder()
                .withPlacementAreaEntity(placementArea)
                .mapToResponse());
    }

}