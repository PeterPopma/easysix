package com.peterpopma.easysix.organization.query.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peterpopma.easysix.organization.entity.Organization;
import com.peterpopma.easysix.organization.mapper.OrganizationMapper;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrganizationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        organizationRepository.deleteAll(); // Clean before each test
    }

    @Test
    void shouldReturnOrganizationById() throws Exception {
        // Arrange: save real entity
        Organization org = new Organization();
        UUID id = UUID.randomUUID();
        org.setId(id);
        org.setOrgId("ORG-123");
        org.setEmail("org@example.com");
        // ... populate rest of required fields

        organizationRepository.save(org);

        // Act & Assert
        mockMvc.perform(get("/api/organizations/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.orgId").value("ORG-123"))
                .andExpect(jsonPath("$.email").value("org@example.com"));
    }

    @Test
    void shouldReturnNotFoundWhenOrganizationDoesNotExist() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(get("/api/organizations/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn200IfOrganizationExists() throws Exception {
        UUID id = UUID.randomUUID();
        Organization org = new Organization();
        org.setId(id);
        org.setOrgId("ORG-XYZ");
        // ... set other required fields

        organizationRepository.save(org);

        mockMvc.perform(head("/api/organizations/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404IfOrganizationDoesNotExist() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(head("/api/organizations/{id}", id))
                .andExpect(status().isNotFound());
    }
}

