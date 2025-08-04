package com.peterpopma.easysix.contactcommand.dto;

public record AuthInfoDto(
        String pw,
        String ext,
        PostalInfoDto postalInfo
) {}
