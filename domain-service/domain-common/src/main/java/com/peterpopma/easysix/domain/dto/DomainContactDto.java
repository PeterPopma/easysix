package com.peterpopma.easysix.domain.dto;

import java.util.UUID;

public record DomainContactDto(
        UUID id,
        UUID domainId,
        UUID contactId,
        String role,
        long version
) {}
