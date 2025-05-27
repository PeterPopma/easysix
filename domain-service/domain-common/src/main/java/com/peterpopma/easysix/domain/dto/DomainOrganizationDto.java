package com.peterpopma.easysix.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record DomainOrganizationDto(
        UUID id,
        UUID domainId,
        UUID organizationId,
        String role,
        String status,
        Instant createdAt,
        Instant updatedAt,
        long version
) {}
