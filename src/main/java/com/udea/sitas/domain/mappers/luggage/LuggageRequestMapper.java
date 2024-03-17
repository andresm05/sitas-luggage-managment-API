package com.udea.sitas.domain.mappers.luggage;

import com.udea.sitas.domain.entities.LuggageEntity;
import com.udea.sitas.domain.models.luggage.LuggageRequest;

// This class maps the luggage request to the luggage entity
public class LuggageRequestMapper {

    private LuggageRequest luggageRequest;

    private LuggageRequestMapper() {

    }

    public static LuggageRequestMapper builder() {
        return new LuggageRequestMapper();
    }

    public LuggageRequestMapper withLuggageRequest(LuggageRequest luggageRequest) {
        this.luggageRequest = luggageRequest;
        return this;
    }

    public LuggageEntity mapToEntity() {
        return new LuggageEntity(
                luggageRequest.getLuggageType(),
                luggageRequest.getExtraCharge(),
                luggageRequest.getQuantity(),
                luggageRequest.getWidth(),
                luggageRequest.getHeight(),
                luggageRequest.getLength(),
                luggageRequest.getWeight(),
                luggageRequest.getDescription(),
                luggageRequest.getUserId(),
                luggageRequest.getFlightId(),
                luggageRequest.getBookingId());
    }

}
