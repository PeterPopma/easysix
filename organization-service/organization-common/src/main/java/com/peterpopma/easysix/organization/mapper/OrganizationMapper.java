package com.peterpopma.easysix.organization.mapper;

import com.peterpopma.easysix.organization.dto.*;
import com.peterpopma.easysix.organization.entity.*;
import com.peterpopma.easysix.organization.model.OrganizationRoleStatusType;
import com.peterpopma.easysix.organization.model.OrganizationStatusType;
import org.mapstruct.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDto toDto(Organization organization);

    @Mapping(target = "version", constant = "0L") // ➡️ version will always be 0 when creating a new entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "statuses", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "contacts", ignore = true)
    @Mapping(target = "postalInfos", ignore = true)
    Organization toEntityForCreate(OrganizationDto dto);

    // for UPDATE: keep the ID from the DTO
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statuses", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "contacts", ignore = true)
    @Mapping(target = "postalInfos", ignore = true)
    Organization toEntityForUpdate(OrganizationDto dto);

    // Date/time conversion helpers
    default Instant map(OffsetDateTime value) {
        return value != null ? value.toInstant() : null;
    }

    default OffsetDateTime map(Instant value) {
        return value != null ? OffsetDateTime.ofInstant(value, ZoneOffset.UTC) : null;
    }

    default Set<OrganizationRoleStatusType> mapOrganizationStatuses(Set<OrganizationRoleStatus> statuses) {
        if (statuses == null) return null;
        return statuses.stream()
                .map(OrganizationRoleStatus::getStatus)
                .collect(Collectors.toSet());
    }

    default Set<OrganizationRoleStatus> mapOrganizationStatuses(Set<OrganizationRoleStatusType> statusTypes, OrganizationRole role) {
        if (statusTypes == null) return null;
        return statusTypes.stream()
                .map(type -> new OrganizationRoleStatus(role, type))
                .collect(Collectors.toSet());
    }

    default OrganizationStatus toOrganizationStatus(OrganizationStatusType statusType) {
        OrganizationStatus status = new OrganizationStatus();
        status.setStatus(statusType);
        return status; // we'll set the organization elsewhere
    }

    // Explicit mapping for Set<OrganizationStatus>
    default Set<OrganizationStatusType> map(Set<OrganizationStatus> statuses) {
        if (statuses == null) {
            return null;
        }
        return statuses.stream()
                .map(OrganizationStatus::getStatus)
                .collect(Collectors.toSet());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "statuses", ignore = true) // we handle this manually
    default OrganizationRole toEntity(OrganizationRoleDto dto, Organization parentOrg) {
        if (dto == null) return null;

        OrganizationRole role = new OrganizationRole();
        // Set id only if it's not null
        if (dto.id() != null) {
            role.setId(dto.id());
        }
        role.setType(dto.type());
        role.setRoleId(dto.roleId());
        role.setOrganization(parentOrg);
        role.setStatuses(mapOrganizationStatuses(dto.statuses(), role));
        return role;
    }

    @AfterMapping
    default void mapOrganizationStatuses(OrganizationRoleDto dto, @MappingTarget OrganizationRole role) {
        role.setStatuses(mapOrganizationStatuses(dto.statuses(), role));
    }

    List<OrganizationRoleDto> toRoleDtos(List<OrganizationRole> roles);
    List<OrganizationContactDto> toContactDtos(List<OrganizationContact> contacts);
    List<PostalInfoDto> toPostalInfoDtos(List<PostalInfo> postalInfos);

    @Named("toInstant")
    static Instant toInstant(OffsetDateTime dateTime) {
        return dateTime != null ? dateTime.toInstant() : null;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "organization", ignore = true)
    OrganizationContact toEntity(OrganizationContactDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "organization", ignore = true)
    PostalInfo toEntity(PostalInfoDto dto);
}

