package com.peterpopma.easysix.organization.dto;

import com.peterpopma.easysix.organization.model.OrganizationRoleStatusType;

import java.util.Set;
import java.util.UUID;

public record OrganizationRoleDto(
        UUID id,
        String type,
        String roleId,
        Set<OrganizationRoleStatusType> statuses
) {}
