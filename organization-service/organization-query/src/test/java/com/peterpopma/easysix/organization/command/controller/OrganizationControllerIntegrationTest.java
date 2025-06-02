package com.peterpopma.easysix.organization.command.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peterpopma.easysix.organization.dto.OrganizationDto;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrganizationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    private OrganizationDto testDto;

    @BeforeEach
    void setUp() {
        organizationRepository.deleteAll(); // Clean DB before each test

        testDto = new OrganizationDto(
                null,
                "PP-001",
                "MyCompany",
                "test@example.com",
                "https://example.com",
                "+123456789",
                "+987654321",
                null,
                "CL123",
                "CR123",
                Instant.now(),
                "UP123",
                Instant.now(),
                null,
                null,
                null,
                null
        );
    }

    @Test
    void shouldCreateOrganization() throws Exception {
        mockMvc.perform(post("/api/organizations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orgId").value("ORG-123"))
                .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    void shouldUpdateOrganization() throws Exception {
        // First create
        String content = mockMvc.perform(post("/api/organizations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testDto)))
                .andReturn().getResponse().getContentAsString();

        OrganizationDto created = objectMapper.readValue(content, OrganizationDto.class);

        // Modify a field
        OrganizationDto updatedDto = new OrganizationDto(
                created.id(),
                "RSR_5327-SIDN",

                "updated@example.com",
                "https://example.com/updated",
                "+111111111",
                "+999999999",
                null,
                null,
                "CL456",
                "CR456",
                created.crDate(),
                "UP456",
                Instant.now(),
                null,
                null,
                null,
                null
        );

        mockMvc.perform(put("/api/organizations/" + created.id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("updated@example.com"))
                .andExpect(jsonPath("$.clId").value("CL456"));
    }

    @Test
    void shouldDeleteOrganization() throws Exception {
        // First create
        String content = mockMvc.perform(post("/api/organizations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testDto)))
                .andReturn().getResponse().getContentAsString();

        OrganizationDto created = objectMapper.readValue(content, OrganizationDto.class);

        // Delete
        mockMvc.perform(delete("/api/organizations/" + created.id()))
                .andExpect(status().isNoContent());
    }
}
