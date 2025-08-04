package com.peterpopma.easysix.organization.query.controller;

import com.peterpopma.easysix.organization.dto.OrganizationCheckRequestDto;
import com.peterpopma.easysix.organization.dto.OrganizationCheckResponseDto;
import com.peterpopma.easysix.organization.dto.OrganizationDto;
import com.peterpopma.easysix.organization.mapper.OrganizationMapper;
import com.peterpopma.easysix.organization.query.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;
    private final OrganizationMapper organizationMapper;

    @Operation(summary = "Find a organization by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Organization found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDto.class))),
            @ApiResponse(responseCode = "404", description = "Organization not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getOrganization(@Parameter(description = "Domain ID") @PathVariable UUID id) {
        var organization = organizationService.findById(id);
        return ResponseEntity.ok(organizationMapper.toDto(organization));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headExistsById(@PathVariable UUID id) {
        boolean exists = organizationService.exists(id);
        if (exists) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/check")
    public ResponseEntity<OrganizationCheckResponseDto> checkOrganizations(
            @RequestBody OrganizationCheckRequestDto requestDto) {

        OrganizationCheckResponseDto responseDto = organizationService.checkAvailability(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
