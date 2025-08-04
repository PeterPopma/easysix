package com.peterpopma.easysix.contactcommand.dto;

public record PostalInfoDto(
        String name,
        String org,
        String type, // "int" or "loc",
        AddressDto addr
) {}
