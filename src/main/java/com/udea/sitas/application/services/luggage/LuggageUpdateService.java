package com.udea.sitas.application.services.luggage;

import org.springframework.stereotype.Service;

import com.udea.sitas.domain.entities.LuggageEntity;
import com.udea.sitas.domain.entities.PlacementAreaEntity;
import com.udea.sitas.domain.mappers.luggage.LuggageResponseMapper;
import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.domain.ports.luggage.ILuggageUpdatePort;
import com.udea.sitas.infraestructure.exceptions.NumberNotValidException;
import com.udea.sitas.infraestructure.exceptions.RestException;
import com.udea.sitas.infraestructure.repositories.LuggageRepository;
import com.udea.sitas.infraestructure.repositories.PlacementAreaRepository;
import com.udea.sitas.infraestructure.utils.validation.LuggageValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
// This class is the service for the luggage update use case
public class LuggageUpdateService implements ILuggageUpdatePort {

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;

    @Override
    public LuggageResponse update(LuggageRequest luggageRequest, Long id) throws RestException {

        // validate if the luggage exists
        LuggageEntity luggage = luggageRepository.findById(id).orElseThrow();

        // validate the fields of the luggage request
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

        // search for the placement area
        PlacementAreaEntity placementArea = placementAreaRepository.findById(luggageRequest.getPlacementAreaId())
                .orElseThrow();

        // update the luggage
        luggage.setLuggageType(luggageRequest.getLuggageType());
        if (luggageRequest.getExtraCharge() != null) {
            luggage.setExtraCharge(luggageRequest.getExtraCharge());
        }
        if (luggageRequest.getQuantity() != null) {
            luggage.setQuantity(luggageRequest.getQuantity());
        }
        luggage.setQuantity(luggageRequest.getQuantity());
        luggage.setWidth(luggageRequest.getWidth());
        luggage.setHeight(luggageRequest.getHeight());
        luggage.setLength(luggageRequest.getLength());
        luggage.setWeight(luggageRequest.getWeight());
        luggage.setDescription(luggageRequest.getDescription());
        luggage.setPlacementArea(placementArea);
        luggage.setUserId(luggageRequest.getUserId());
        luggage.setFlightId(luggageRequest.getFlightId());
        luggage.setBookingId(luggageRequest.getBookingId());

        // save the luggage and return the response
        return LuggageResponseMapper.builder()
                .withLuggageEntity(luggageRepository.save(luggage))
                .mapToResponse();
    }

}
