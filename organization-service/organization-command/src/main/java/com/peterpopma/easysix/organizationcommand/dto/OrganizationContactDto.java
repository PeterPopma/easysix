package com.peterpopma.easysix.organizationcommand.dto;

import java.util.UUID;

public record OrganizationContactDto(
        UUID id,
        String contactType,
        String contactTypeName,
        String contactId
) {}
