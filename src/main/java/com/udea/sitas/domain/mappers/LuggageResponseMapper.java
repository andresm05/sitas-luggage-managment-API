package com.udea.sitas.domain.mappers;

import com.udea.sitas.domain.entities.LuggageEntity;
import com.udea.sitas.domain.models.luggage.LuggageResponse;

public class LuggageResponseMapper {

    private LuggageEntity luggageEntity;

    private LuggageResponseMapper() {

    }

    public static LuggageResponseMapper builder() {
        return new LuggageResponseMapper();
    }

    public LuggageResponseMapper withLuggageEntity(LuggageEntity luggageEntity) {
        this.luggageEntity = luggageEntity;
        return this;
    }

    public LuggageResponse mapToResponse() {
        return LuggageResponse.builder()
                .id(luggageEntity.getId())
                .luggageType(luggageEntity.getLuggageType())
                .extraCharge(luggageEntity.getExtraCharge())
                .quantity(luggageEntity.getQuantity())
                .width(luggageEntity.getWidth())
                .height(luggageEntity.getHeight())
                .length(luggageEntity.getLength())
                .weight(luggageEntity.getWeight())
                .description(luggageEntity.getDescription())
                .userId(luggageEntity.getUserId())
                .flightId(luggageEntity.getFlightId())
                .bookingId(luggageEntity.getBookingId())
                .placementArea(PlacementAreaResponseMapper.builder()
                        .withPlacementAreaEntity(luggageEntity.getPlacementArea())
                        .mapToResponse())
                .build();
    }

}