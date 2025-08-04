package com.peterpopma.easysix.organization.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.peterpopma.easysix.organization.model.OrganizationContactType;

import java.util.UUID;

public record OrganizationContactDto(
        UUID id,
        OrganizationContactType contactType,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String contactTypeName,
        String contactId
) {}
