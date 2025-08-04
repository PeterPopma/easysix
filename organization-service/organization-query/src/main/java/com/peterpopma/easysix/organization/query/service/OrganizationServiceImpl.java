package com.peterpopma.easysix.organization.query.service;

import com.peterpopma.easysix.organization.dto.OrganizationCheckRequestDto;
import com.peterpopma.easysix.organization.dto.OrganizationCheckResponseDto;
import com.peterpopma.easysix.organization.dto.OrganizationCheckResultDto;
import com.peterpopma.easysix.organization.entity.*;
import com.peterpopma.easysix.organization.exception.OrganizationNotFoundException;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    @Transactional(readOnly = true)
    public Organization findById(UUID id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UUID> findAllOrganizationIds() {
        return organizationRepository.findAllOrganizationIds();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(UUID id){
        return organizationRepository.existsById(id);
    }

    @Override
    public OrganizationCheckResponseDto checkAvailability(OrganizationCheckRequestDto requestDto) {
        List<String> orgIds = requestDto.organizationIds();
        Set<String> existingOrgIds = organizationRepository.findByOrgIdIn(orgIds).stream()
                .map(Organization::getOrgId)
                .collect(Collectors.toSet());

        List<OrganizationCheckResultDto> results = orgIds.stream()
                .map(id -> new OrganizationCheckResultDto(
                        id,
                        !existingOrgIds.contains(id),
                        existingOrgIds.contains(id) ? "In use" : null
                ))
                .toList();

        return new OrganizationCheckResponseDto(
                results
        );
    }
}
