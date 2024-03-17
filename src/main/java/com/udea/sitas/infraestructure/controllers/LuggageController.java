package com.udea.sitas.infraestructure.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.domain.ports.luggage.LuggageSavePort;
import com.udea.sitas.infraestructure.exceptions.RestException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/luggage")
@RequiredArgsConstructor
public class LuggageController {

    private final LuggageSavePort luggageSavePort;

    @PostMapping
    public ResponseEntity<LuggageResponse> findAll(@RequestBody LuggageRequest luggageRequest) throws RestException {
        return new ResponseEntity<>(luggageSavePort.save(luggageRequest), HttpStatus.CREATED);
    }

}
