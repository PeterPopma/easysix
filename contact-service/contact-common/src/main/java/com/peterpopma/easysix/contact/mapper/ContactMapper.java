package com.peterpopma.easysix.contactcommand.service;

import com.peterpopma.easysix.contactcommand.dto.AddressDto;
import com.peterpopma.easysix.contactcommand.dto.ContactDto;
import com.peterpopma.easysix.contactcommand.dto.PostalInfoDto;
import com.peterpopma.easysix.contactcommand.entity.Address;
import com.peterpopma.easysix.contactcommand.entity.Contact;
import com.peterpopma.easysix.contactcommand.entity.PostalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    // ENTITY → DTO
    ContactDto toDto(Contact contact);
    PostalInfoDto toDto(PostalInfo postalInfo);
    @Mapping(source = "sp", target = "stateProvince")
    @Mapping(source = "pc", target = "postalCode")
    @Mapping(source = "cc", target = "countryCode")
    AddressDto toDto(Address addr);

    // DTO → ENTITY
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "crDate", ignore = true)
    @Mapping(target = "upId", ignore = true)
    @Mapping(target = "upDate", ignore = true)
    @Mapping(target = "trDate", ignore = true)
    @Mapping(target = "authInfo", ignore = true)
    @Mapping(target = "statuses", ignore = true)
    @Mapping(target = "disclose", ignore = true)
    Contact toEntity(ContactDto dto);
    @Mapping(target = "id", ignore = true) // suppress warning for 'id'
    @Mapping(target = "contact", ignore = true) // suppress warning for 'contact'
    PostalInfo toEntity(PostalInfoDto dto);
    @Mapping(source = "stateProvince", target = "sp")
    @Mapping(source = "postalCode", target = "pc")
    @Mapping(source = "countryCode", target = "cc")
    @Mapping(target = "id", ignore = true) // suppress warning for 'id'
    @Mapping(target = "postalInfo", ignore = true) // suppress warning for 'postalInfo'
    Address toEntity(AddressDto dto);
}
