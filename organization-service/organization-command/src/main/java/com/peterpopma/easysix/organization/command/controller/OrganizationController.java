package com.peterpopma.easysix.organization.command.controller;

import com.peterpopma.easysix.organization.dto.OrganizationDto;
import com.peterpopma.easysix.organization.command.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(summary = "Create a new organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organization created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@Valid @RequestBody OrganizationDto dto) {
        OrganizationDto created = organizationService.create(dto);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Update an existing organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organization updated successfully"),
            @ApiResponse(responseCode = "404", description = "Organization not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(
            @PathVariable UUID id,
            @Valid @RequestBody OrganizationDto dto
    ) {
        OrganizationDto updated = organizationService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete an organization by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Organization deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Organization not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable UUID id) {
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
