package com.peterpopma.easysix.organizationcommand.service;

import com.peterpopma.easysix.organizationcommand.dto.OrganizationDto;

import java.util.UUID;

public interface OrganizationService {
    OrganizationDto create(OrganizationDto dto);
    OrganizationDto update(UUID id, OrganizationDto dto);
    void delete(UUID id);
}
