package com.peterpopma.easysix.domain.dto;

import java.util.UUID;

public record DomainStatusDto(
        UUID id,
        UUID domainId,
        String status,
        String lang,
        String message,
        long version
) {}
