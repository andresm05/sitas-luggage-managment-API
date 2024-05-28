package com.udea.sitas.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.udea.sitas.domain.entities.PlacementAreaEntity;

// This interface is the repository for the placement area entity
@Repository
@RepositoryRestResource(collectionResourceRel = "placement-area", path = "placement-area")
public interface PlacementAreaRepository extends JpaRepository<PlacementAreaEntity, Long> {

}
