package com.peterpopma.easysix.organization.query.service;

import com.peterpopma.easysix.organization.dto.OrganizationDto;

import java.util.UUID;

public interface OrganizationService {
    OrganizationDto create(OrganizationDto dto);
    OrganizationDto update(UUID id, OrganizationDto dto);
    void delete(UUID id);
}
