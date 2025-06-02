package com.peterpopma.easysix.domain.query.controller;

import com.peterpopma.easysix.domain.dto.DomainDto;
import com.peterpopma.easysix.domain.mapper.DomainMapper;
import com.peterpopma.easysix.domain.query.service.DomainService;
import lombok.RequiredArgsConstructor;
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
public class DomainQueryController {

    private final DomainService domainService;
    private final DomainMapper domainMapper;

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
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headExistsById(@PathVariable UUID id) {
        boolean exists = domainService.exists(id);
        if (exists)
        {
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
