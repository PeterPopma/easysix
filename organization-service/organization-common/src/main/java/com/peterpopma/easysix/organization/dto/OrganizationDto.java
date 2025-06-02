package com.peterpopma.easysix.organization.dto;

import com.peterpopma.easysix.organization.model.OrganizationStatusType;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record OrganizationDto(
        UUID id,
        String orgId,
        String roid,
        String parentId,
        String voice,
        String fax,
        String email,
        String url,
        String clId,
        String crId,
        Instant crDate,
        String upId,
        Instant upDate,
        Set<OrganizationStatusType> statuses,
        Set<OrganizationRoleDto> roles,
        Set<PostalInfoDto> postalInfos,
        Set<OrganizationContactDto> contacts
) {}