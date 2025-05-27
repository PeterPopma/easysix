package com.peterpopma.easysix.domain.dto;

import java.util.UUID;

public record DomainHostObjectDto(
        UUID id,
        UUID domainId,
        String hostName,
        long version
) {}

