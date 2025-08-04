package com.peterpopma.easysix.organization.dto;

import java.util.List;

public record OrganizationCheckResponseDto(
        List<OrganizationCheckResultDto> results
) {}
