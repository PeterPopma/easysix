package com.peterpopma.easysix.domain.command.controller;

import com.peterpopma.easysix.domain.dto.DomainDto;
import com.peterpopma.easysix.domain.mapper.DomainMapper;
import com.peterpopma.easysix.domain.command.service.DomainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/domains")
@RequiredArgsConstructor
@Tag(name = "Domain API", description = "Operations related to domain management")
public class DomainCommandController {

    private final DomainService domainService;
    private final DomainMapper domainMapper;

    @Operation(summary = "Create a new domain", responses = {
            @ApiResponse(responseCode = "201", description = "Domain created",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DomainDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<DomainDto> createDomain(@Valid @RequestBody DomainDto dto) {
        var domain = domainMapper.toEntity(dto);
        var saved = domainService.save(domain);
        return ResponseEntity.status(HttpStatus.CREATED).body(domainMapper.toDto(saved));
    }

    @Operation(summary = "Update an existing domain", responses = {
            @ApiResponse(responseCode = "200", description = "Domain updated",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DomainDto.class))),
            @ApiResponse(responseCode = "404", description = "Domain not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DomainDto> updateDomain(
            @Parameter(description = "Domain ID") @PathVariable UUID id,
            @Valid @RequestBody DomainDto dto) {

        var existing = domainService.findById(id);
        var updated = domainMapper.toEntity(dto);
        updated.setId(id);
        updated.setCreatedAt(existing.getCreatedAt());
        var saved = domainService.save(updated);
        return ResponseEntity.ok(domainMapper.toDto(saved));
    }

    @Operation(summary = "Delete a domain by ID", responses = {
            @ApiResponse(responseCode = "204", description = "Domain deleted"),
            @ApiResponse(responseCode = "404", description = "Domain not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomain(@Parameter(description = "Domain ID") @PathVariable UUID id) {
        domainService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Find a domain by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Domain found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DomainDto.class))),
            @ApiResponse(responseCode = "404", description = "Domain not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DomainDto> getDomain(@Parameter(description = "Domain ID") @PathVariable UUID id) {
        var domain = domainService.findById(id);
        return ResponseEntity.ok(domainMapper.toDto(domain));
    }
}
