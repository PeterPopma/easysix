package com.peterpopma.easysix.organization.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.peterpopma.easysix.organization.model.PostalInfoType;

import java.util.UUID;

public record PostalInfoDto(
        UUID id,
        PostalInfoType type,
        String name,
        String street1,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String street2,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String street3,
        String city,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String stateProvince,
        String postalCode,
        String countryCode
) {}
