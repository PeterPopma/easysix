package com.peterpopma.easysix.organization.dto;
public record OrganizationCheckResultDto(
        String id,
        boolean available,
        String reason // nullable, only present if available == false
) {}
