package com.peterpopma.easysix.organizationcommand.dto;

import java.util.UUID;

public record PostalInfoDto(
        UUID id,
        String type,
        String name,
        String street1,
        String street2,
        String street3,
        String city,
        String stateProvince,
        String postalCode,
        String countryCode
) {}
