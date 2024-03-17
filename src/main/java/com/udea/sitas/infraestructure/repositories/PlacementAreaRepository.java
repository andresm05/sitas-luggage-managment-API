package com.udea.sitas.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.sitas.domain.entities.PlacementAreaEntity;

@Repository
public interface PlacementAreaRepository extends JpaRepository<PlacementAreaEntity, Long> {

}
