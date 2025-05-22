package com.peterpopma.easysix.contactcommand.controller;

import com.peterpopma.easysix.contactcommand.dto.ContactDto;
import com.peterpopma.easysix.contactcommand.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/contacts")
@Tag(name = "Contact Management", description = "Endpoints for managing contacts")
public class ContactCommandController {

    private final ContactService contactService;

    public ContactCommandController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Operation(summary = "Create a new contact")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Contact created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<ContactDto> createContact(@Valid @RequestBody ContactDto dto) {
        ContactDto created = contactService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Update an existing contact")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contact updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Contact not found")
    })
    @PutMapping("/{id}")
    public ContactDto updateContact(@PathVariable UUID id, @Valid @RequestBody ContactDto dto) {
        return contactService.update(id, dto);
    }

    @Operation(summary = "Delete a contact by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Contact deleted"),
            @ApiResponse(responseCode = "404", description = "Contact not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable UUID id) {
        contactService.delete(id);
    }
}
