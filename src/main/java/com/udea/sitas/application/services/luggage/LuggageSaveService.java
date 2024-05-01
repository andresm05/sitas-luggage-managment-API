package com.udea.sitas.application.services.luggage;

import org.springframework.stereotype.Service;

import com.udea.sitas.domain.entities.LuggageEntity;
import com.udea.sitas.domain.entities.PlacementAreaEntity;
import com.udea.sitas.domain.mappers.luggage.LuggageRequestMapper;
import com.udea.sitas.domain.mappers.luggage.LuggageResponseMapper;
import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.domain.ports.luggage.ILuggageSavePort;
import com.udea.sitas.infraestructure.exceptions.LuggageLimitException;
import com.udea.sitas.infraestructure.exceptions.LuggageMeasurementException;
import com.udea.sitas.infraestructure.exceptions.NumberNotValidException;
import com.udea.sitas.infraestructure.exceptions.RestException;
import com.udea.sitas.infraestructure.repositories.LuggageRepository;
import com.udea.sitas.infraestructure.repositories.PlacementAreaRepository;
import com.udea.sitas.infraestructure.utils.validation.LuggageValidation;
import com.udea.sitas.infraestructure.utils.validation.PlacementAreaValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
// This class is the service for the luggage save use case
public class LuggageSaveService implements ILuggageSavePort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public LuggageResponse save(LuggageRequest luggageRequest) throws RestException {
        double[] decimals = {
                luggageRequest.getWeight(),
                luggageRequest.getHeight(),
                luggageRequest.getWidth(),
                luggageRequest.getLength()
        };

        if (!LuggageValidation.validatePositiveDecimals(decimals)) {
            throw new NumberNotValidException("Los valores numéricos deben ser mayores a 0");
        }

        if (!LuggageValidation.validateExtraCharge(luggageRequest.getExtraCharge())) {
            throw new NumberNotValidException("El valor del cargo extra debe ser mayor o igual a 0");
        }

        if (!LuggageValidation.validateQuantity(luggageRequest.getQuantity())) {
            throw new NumberNotValidException("La cantidad debe ser mayor a 0");
        }

        if (luggageRepository.findByUserId(luggageRequest.getUserId()).isPresent()) {
            throw new LuggageLimitException("El usuario ya tiene un equipaje asignado");
        }
        // search for the placement area
        PlacementAreaEntity placementArea = placementAreaRepository.findById(luggageRequest.getPlacementAreaId())
                .orElseThrow();

        if (!PlacementAreaValidation.validateMeasurements(luggageRequest.getHeight(), luggageRequest.getLength(),
                luggageRequest.getWidth(), luggageRequest.getPlacementAreaId())) {
            throw new LuggageMeasurementException(
                    "Las medidas del equipaje superan las permitidas en el área de ubicación seleccionada: "+ placementArea.getName() + ". Las medidas máximas permitidas son: "
                            + PlacementAreaValidation.getMeasurements(luggageRequest.getPlacementAreaId()));
        }

        // create the luggage
        LuggageEntity luggage = LuggageRequestMapper.builder()
                .withLuggageRequest(luggageRequest)
                .mapToEntity();

        // set the placement area to the luggage
        luggage.setPlacementArea(placementArea);

        // save the luggage and return the response
        return LuggageResponseMapper.builder()
                .withLuggageEntity(luggageRepository.save(luggage))
                .mapToResponse();
    }

}
