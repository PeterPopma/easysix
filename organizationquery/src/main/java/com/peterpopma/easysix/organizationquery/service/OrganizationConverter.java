package com.peterpopma.easysix.organizationquery.service;

import com.peterpopma.easysix.organizationquery.dao.OrganizationEntity;
import com.peterpopma.easysix.organizationquery.dto.OrganizationObject;

import java.util.List;
import java.util.UUID;

public class OrganizationConverter {

    public static OrganizationObject toDto(OrganizationEntity entity) {
        return new OrganizationObject(
            entity.getId(),
            entity.getRoid(),
            entity.getStatus() != null ? String.join(",", entity.getStatus()) : null,
            entity.getPostalInfoType(),
            entity.getPostalInfoName(),
            entity.getOrganizationId(),
            entity.getPostalInfoStreet() != null && entity.getPostalInfoStreet().size() > 0 ? entity.getPostalInfoStreet().get(0) : null,
            entity.getPostalInfoStreet() != null && entity.getPostalInfoStreet().size() > 1 ? entity.getPostalInfoStreet().get(1) : null,
            entity.getPostalInfoStreet() != null && entity.getPostalInfoStreet().size() > 2 ? entity.getPostalInfoStreet().get(2) : null,
            entity.getPostalInfoStateProvince(),
            entity.getPostalInfoPostalCode(),
            entity.getPostalInfoCity(),
            entity.getPostalInfoCountryCode(),
            entity.getVoice(),
            entity.getFax(),
            entity.getEmail(),
            null, // clId is not present in entity
            null, // crId is stored as String in entity
            entity.getCrDate(),
            null, // upId is stored as String in entity
            entity.getUpDate(),
            null, // trDate is missing in entity
            null, // authInfoPw is missing in entity
            null, // authInfoExt is missing in entity
            false, // discloseVoice not stored in entity
            false  // discloseEmail not stored in entity
        );
    }

    public static OrganizationEntity toEntity(OrganizationObject dto) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(dto.id());
        entity.setRoid(dto.roid());
        entity.setStatus(dto.status() != null ? List.of(dto.status().split(",")) : null);
        entity.setPostalInfoType(dto.postalInfo());
        entity.setPostalInfoName(dto.name());
        entity.setOrganizationId(dto.org());

        List<String> streetList = List.of(dto.street1(), dto.street2(), dto.street3());
        entity.setPostalInfoStreet(streetList.stream().filter(s -> s != null && !s.isEmpty()).toList());

        entity.setPostalInfoStateProvince(dto.stateProvince());
        entity.setPostalInfoPostalCode(dto.postalCode());
        entity.setPostalInfoCity(dto.city());
        entity.setPostalInfoCountryCode(dto.countryCode());
        entity.setVoice(dto.voice());
        entity.setFax(dto.fax());
        entity.setEmail(dto.email());
        entity.setCrDate(dto.crDate());
        entity.setUpDate(dto.upDate());

        return entity;
    }
}
