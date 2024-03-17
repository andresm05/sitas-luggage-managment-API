package com.udea.sitas.application.services.luggage;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.udea.sitas.domain.ports.luggage.LuggageDeletePort;
import com.udea.sitas.infraestructure.repositories.LuggageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LuggageDeleteService implements LuggageDeletePort {

    private final LuggageRepository luggageRepository;

    @Override
    public void delete(Long id) {

        if (!luggageRepository.existsById(id)) {
            throw new NoSuchElementException("Luggage not found");
        }
        luggageRepository.deleteById(id);
    }

}
