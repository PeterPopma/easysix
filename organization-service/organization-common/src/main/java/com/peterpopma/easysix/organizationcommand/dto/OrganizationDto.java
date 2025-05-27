package com.peterpopma.easysix.organizationcommand.dto;

import com.peterpopma.easysix.organizationcommand.entity.OrganizationStatus;
import com.peterpopma.easysix.organizationcommand.model.OrganizationStatusType;

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