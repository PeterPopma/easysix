package com.peterpopma.easysix.contactcommand.dto;

public record AddressDto(
    String street1,
    String street2,
    String street3,
    String city,
    String stateProvince,
    String postalCode,
    String countryCode)
{}
