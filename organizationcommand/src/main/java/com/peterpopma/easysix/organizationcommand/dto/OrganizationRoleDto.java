package com.peterpopma.easysix.organizationcommand.dto;

import com.peterpopma.easysix.organizationcommand.model.OrganizationRoleStatusType;

import java.util.Set;
import java.util.UUID;

public record OrganizationRoleDto(
        UUID id,
        String type,
        String roleId,
        Set<OrganizationRoleStatusType> statuses
) {}
