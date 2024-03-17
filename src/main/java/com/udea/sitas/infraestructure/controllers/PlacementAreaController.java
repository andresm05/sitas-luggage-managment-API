package com.udea.sitas.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.sitas.application.services.placementArea.PlacementAreaFindService;
import com.udea.sitas.domain.models.placementArea.PlacementAreaResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/placement-area")
public class PlacementAreaController {

    private final PlacementAreaFindService placementAreaFindService;

    @GetMapping
    public ResponseEntity<List<PlacementAreaResponse>> findAll() {
        return new ResponseEntity<>(placementAreaFindService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlacementAreaResponse>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(placementAreaFindService.findById(id),
                HttpStatus.OK);
    }

}
