package com.peterpopma.easysix.organizationcommand.service;

import com.peterpopma.easysix.organizationcommand.dao.OrganizationEntity;
import com.peterpopma.easysix.organizationcommand.dto.OrganizationObject;
import com.peterpopma.easysix.organizationcommand.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public void createOrganization(OrganizationObject organization)
    {
        OrganizationEntity organizationEntity = OrganizationConverter.toEntity(organization);
        organizationRepository.save(organizationEntity);
    }
    
    public void updateOrganization(OrganizationObject organization)
    {
        OrganizationEntity organizationEntity = OrganizationConverter.toEntity(organization);
        Optional<OrganizationEntity> existingOrganizationOpt = organizationRepository.findById(organization.id());

        if (existingOrganizationOpt.isPresent()) {
            OrganizationEntity updatedOrganization = OrganizationConverter.toEntity(organization);
            organizationRepository.save(updatedOrganization);
        } else {
            // Handle case where the organization does not exist
            throw new EntityNotFoundException("Organization with ID " + organization.id() + " not found.");
        }
    }
    
    public void deleteOrganizationById(UUID organizationId)
    {
        Optional<OrganizationEntity> existingOrganizationOpt = organizationRepository.findById(organizationId);

        if (existingOrganizationOpt.isPresent()) {
            organizationRepository.deleteById(organizationId);
        } else {
            // Handle case where the organization does not exist
            throw new EntityNotFoundException("Organization with ID " + organizationId + " not found.");
        }
    }
}
