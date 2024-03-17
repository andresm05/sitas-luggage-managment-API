package com.udea.sitas.domain.mappers;

import com.udea.sitas.domain.entities.PlacementAreaEntity;
import com.udea.sitas.domain.models.placementArea.PlacementAreaResponse;

public class PlacementAreaResponseMapper {

    private PlacementAreaEntity placementAreaEntity;

    private PlacementAreaResponseMapper(){

    }

    public static PlacementAreaResponseMapper builder(){
        return new PlacementAreaResponseMapper();
    }

    public PlacementAreaResponseMapper withPlacementAreaEntity(PlacementAreaEntity placementAreaEntity){
        this.placementAreaEntity = placementAreaEntity;
        return this;
    }

    public PlacementAreaResponse mapToResponse(){
        return PlacementAreaResponse.builder()
                .id(placementAreaEntity.getId())
                .name(placementAreaEntity.getName())
                .build();
    }
    
}
