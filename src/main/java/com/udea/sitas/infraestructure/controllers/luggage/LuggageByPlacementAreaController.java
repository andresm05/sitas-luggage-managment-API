package com.udea.sitas.infraestructure.controllers.luggage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.sitas.application.services.luggage.LuggageFindByPlacementAreaService;
import com.udea.sitas.domain.models.luggage.LuggageResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "Luggage by placement area", description = "The luggage by placement area API")
@RequestMapping("/luggage/placement-area")
@RequiredArgsConstructor
public class LuggageByPlacementAreaController {

    private final LuggageFindByPlacementAreaService luggageFindByPlacementAreaService;

    @Operation(summary = "Get all luggages by a specific placement area",
    security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggages found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Luggages not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @SecurityRequirement(name = "JWT")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<List<LuggageResponse>> findByPlacementArea(@PathVariable Long id) {
        return new ResponseEntity<>(luggageFindByPlacementAreaService.findByPlacementArea(id), HttpStatus.OK);
    }

}
