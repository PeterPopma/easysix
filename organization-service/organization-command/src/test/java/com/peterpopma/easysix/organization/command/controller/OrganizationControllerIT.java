package com.peterpopma.easysix.organization.command.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.peterpopma.easysix.organization.dto.OrganizationContactDto;
import com.peterpopma.easysix.organization.dto.OrganizationDto;
import com.peterpopma.easysix.organization.dto.OrganizationRoleDto;
import com.peterpopma.easysix.organization.dto.PostalInfoDto;
import com.peterpopma.easysix.organization.entity.Organization;
import com.peterpopma.easysix.organization.model.OrganizationRoleStatusType;
import com.peterpopma.easysix.organization.model.OrganizationStatusType;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class OrganizationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    private final String BASE_URL = "/api/organizations";

    private OrganizationDto buildOrganizationDto() {
        return new OrganizationDto(
                null,
                "ORG-123",
                "ROID-001",
                null,
                "+123456789",
                "+987654321",
                "contact@example.com",
                "https://example.com",
                "Client123",
                "Creator123",
                Instant.now(),
                "Updater123",
                Instant.now(),
                Set.of(OrganizationStatusType.ok),
                Set.of(new OrganizationRoleDto(null, "admin", "role-001", Set.of(OrganizationRoleStatusType.ok))),
                Set.of(new PostalInfoDto(null, "loc", "Example Org", "Street 1", null, null, "City", "State", "12345", "US")),
                Set.of(new OrganizationContactDto(null, "admin", "Administrator", "contact-id-123"))
        );
    }

    @Test
    void shouldUpdateOrganization() throws Exception {
        // Assume this saves a basic empty org for updating
        Organization saved = organizationRepository.save(new Organization());

        OrganizationDto dto = buildOrganizationDto();
        dto = new OrganizationDto(
                saved.getId(),
                dto.orgId(),
                dto.roid(),
                dto.parentId(),
                dto.voice(),
                dto.fax(),
                dto.email(),
                dto.url(),
                dto.clId(),
                dto.crId(),
                dto.crDate(),
                dto.upId(),
                dto.upDate(),
                dto.statuses(),
                dto.roles(),
                dto.postalInfos(),
                dto.contacts()
        );

        mockMvc.perform(put(BASE_URL + "/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(saved.getId().toString()))
                .andExpect(jsonPath("$.orgId").value("ORG-123"));
    }

    @Test
    void shouldCreateOrganization() throws Exception {
        OrganizationDto dto = buildOrganizationDto();

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orgId").value("ORG-123"))
                .andExpect(jsonPath("$.contacts[0].contactType").value("admin"))
                .andExpect(jsonPath("$.roles[0].type").value("admin"))
                .andExpect(jsonPath("$.postalInfos[0].countryCode").value("US"));
    }

    @Test
    void shouldDeleteOrganization() throws Exception {
        Organization saved = organizationRepository.save(new Organization());

        mockMvc.perform(delete(BASE_URL + "/" + saved.getId()))
                .andExpect(status().isNoContent());

        assertFalse(organizationRepository.findById(saved.getId()).isPresent());
    }
}
