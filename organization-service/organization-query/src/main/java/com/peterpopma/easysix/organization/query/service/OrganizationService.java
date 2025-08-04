package com.peterpopma.easysix.organization.query.service;

import com.peterpopma.easysix.organization.dto.OrganizationCheckRequestDto;
import com.peterpopma.easysix.organization.dto.OrganizationCheckResponseDto;
import com.peterpopma.easysix.organization.entity.Organization;

import java.util.Set;
import java.util.UUID;

public interface OrganizationService {
    Organization findById(UUID id);

    Set<UUID> findAllOrganizationIds();

    boolean exists(UUID id);

    OrganizationCheckResponseDto checkAvailability(OrganizationCheckRequestDto requestDto);
}