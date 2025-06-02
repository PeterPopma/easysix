package com.peterpopma.easysix.organization.query.service;

import com.peterpopma.easysix.organization.entity.Organization;

import java.util.Set;
import java.util.UUID;

public interface OrganizationService {
    Organization findById(UUID id);
    Set<UUID> findAllOrganizationIds();
    boolean exists(UUID id);
}
