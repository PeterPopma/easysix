package com.peterpopma.easysix.organization.command.service;

import com.peterpopma.easysix.organization.dto.OrganizationDto;
import com.peterpopma.easysix.organization.entity.*;
import com.peterpopma.easysix.organization.mapper.OrganizationMapper;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper mapper;

    @Override
    public OrganizationDto create(OrganizationDto dto) {
        // Step 1: Convert DTO to base entity (excluding children that need org.id)
        Organization entity = mapper.toEntityForCreate(dto);

        // Step 2: Save to generate UUID id
        Organization saved = organizationRepository.save(entity);

        // Step 3: Use helper methods to add nested objects now that saved.id is available
        if (dto.roles() != null) {
            dto.roles().forEach(roleDto -> {
                OrganizationRole role = mapper.toEntity(roleDto, saved);
                saved.addRole(role);
            });
        }

        if (dto.contacts() != null) {
            dto.contacts().forEach(contactDto -> {
                OrganizationContact contact = mapper.toEntity(contactDto);
                saved.addContact(contact);
            });
        }

        if (dto.postalInfos() != null) {
            dto.postalInfos().forEach(piDto -> {
                PostalInfo pi = mapper.toEntity(piDto);
                saved.addPostalInfo(pi);
            });
        }

        if (dto.statuses() != null) {
            dto.statuses().forEach(statusType -> {
                OrganizationStatus status = mapper.toOrganizationStatus(statusType);
                status.setOrganization(saved); // setting the parent entity
                saved.addStatus(status);
            });
        }

        // Step 4: Save again to persist children
        Organization finalSaved = organizationRepository.save(saved);

        // Step 5: Return DTO
        return mapper.toDto(finalSaved);
    }

    @Override
    public OrganizationDto update(UUID id, OrganizationDto dto) {
        Organization existing = organizationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found: " + id));

        Organization updated = mapper.toEntityForUpdate(dto);

        // Make sure ID and version are correct (MapStruct might already do this)
        updated.setId(existing.getId());
        updated.setVersion(existing.getVersion());

        Organization saved = organizationRepository.save(updated);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(UUID id) {
        organizationRepository.deleteById(id);
    }
}
