package com.peterpopma.easysix.organization.dto;

import java.util.List;

public record OrganizationCheckRequestDto(
        List<String> organizationIds
) {}
