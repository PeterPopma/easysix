package com.peterpopma.easysix.domain.dto;

import java.util.UUID;

public record DomainHostAddressDto(
        UUID id,
        UUID hostAttrId,
        String ip,
        String ipVersion,
        long version
) {}
