package com.udea.sitas.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.sitas.domain.models.luggage.LuggageRequest;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import com.udea.sitas.domain.ports.luggage.LuggageDeletePort;
import com.udea.sitas.domain.ports.luggage.LuggageFindPort;
import com.udea.sitas.domain.ports.luggage.LuggageSavePort;
import com.udea.sitas.infraestructure.exceptions.RestException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/luggage")
@RequiredArgsConstructor
public class LuggageController {

    private final LuggageSavePort luggageSavePort;
    private final LuggageFindPort luggageFindPort;
    private final LuggageDeletePort luggageDeletePort;

    @PostMapping
    public ResponseEntity<LuggageResponse> findAll(@RequestBody LuggageRequest luggageRequest) throws RestException {
        return new ResponseEntity<>(luggageSavePort.save(luggageRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LuggageResponse>> findAll() {
        return new ResponseEntity<>(luggageFindPort.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LuggageResponse>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(luggageFindPort.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        luggageDeletePort.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
