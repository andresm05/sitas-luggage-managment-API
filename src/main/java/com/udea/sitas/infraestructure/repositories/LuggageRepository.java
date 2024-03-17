package com.udea.sitas.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.sitas.domain.entities.LuggageEntity;

// This interface is the repository for the luggage entity
@Repository
public interface LuggageRepository extends JpaRepository<LuggageEntity, Long>{
    
}
