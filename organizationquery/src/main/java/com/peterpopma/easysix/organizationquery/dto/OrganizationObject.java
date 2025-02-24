package com.peterpopma.easysix.organizationquery.dto;

import java.time.Instant;
import java.util.UUID;

public record OrganizationObject(
        UUID id,
        String roid,
        String status,
        String postalInfo,
        String name,
        String org,
        String street1,
        String street2,
        String street3,
        String stateProvince,
        String postalCode,
        String city,
        String countryCode,
        String voice,
        String fax,
        String email,
        UUID clId,
        UUID crId,
        Instant crDate,
        UUID upId,
        Instant upDate,
        Instant trDate,
        String authInfoPw,
        String authInfoExt,
        boolean discloseVoice,
        boolean discloseEmail
) {}
